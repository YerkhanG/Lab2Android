package com.example.lab2.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.lab2.model.Dog

class DogItemCallBack : DiffUtil.ItemCallback<Dog>() {
    override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem == newItem
    }
}