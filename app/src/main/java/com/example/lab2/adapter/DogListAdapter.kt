package com.example.lab2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab2.R
import com.example.lab2.databinding.ItemDogBinding
import com.example.lab2.model.Dog

class DogListAdapter : ListAdapter<Dog, DogListAdapter.ViewHolder>(DogItemCallBack()) {
    inner class ViewHolder(
        private val binding: ItemDogBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dog: Dog) {

            with(binding) {
                Glide
                    .with(root.context)
                    .load(dog.imageLink)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(dogImage)
                dogName.text = dog.name
                maxLifeExp.text = "Maximum life expectancy: " +  dog.maxLifeExpectancy.toString()
                minLifeExp.text = "Minimum life expectancy: " +dog.minLifeExpectancy.toString()
                goodWithChildren.text = "How its with children: " +dog.goodWithChildren.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDogBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}