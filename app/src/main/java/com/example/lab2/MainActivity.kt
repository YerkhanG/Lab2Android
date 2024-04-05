package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isEmpty
import com.example.lab2.adapter.DogListAdapter
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.model.ApiClient
import com.example.lab2.model.Dog
import com.example.lab2.model.DogApi
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val client = ApiClient.instance
    private val adapter = DogListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            dogList.adapter = adapter
        }

        binding.search.setOnClickListener {
            performSearch()
        }
    }

    private fun performSearch() {
        val searchQuery = binding.searchField.text.toString()

        val response = client.fetchOfferList(searchQuery)
        response.enqueue(object : Callback<List<DogApi>> {
            override fun onResponse(call: Call<List<DogApi>>, response: Response<List<DogApi>>) {
                if (response.isSuccessful) {
                    val dogList = response.body()
                    dogList?.let {
                        val offerListMap = ArrayList(it.map { dogApi ->
                            Dog.toDog(dogApi)
                        })
                        adapter.submitList(offerListMap)
                        updateTextViewVisibility(offerListMap.isNotEmpty())
                    }
                } else {
                    Log.e("MainActivity", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<DogApi>>, t: Throwable) {
                Log.e("MainActivity", "Error: ${t.message}", t)
            }
        })
    }

    private fun updateTextViewVisibility(hasItems: Boolean) {
        binding.placeholder.visibility = if (hasItems) View.GONE else View.VISIBLE
    }
}