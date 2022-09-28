package com.elephant.aviator.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.elephant.aviator.databinding.ItemDescriptionAircraftBinding
import com.elephant.domain.models.TextModel

class AircraftDescriptionAdapter :
    ListAdapter<TextModel, AircraftDescriptionAdapter.AircraftDescriptionHolder>(ItemCallback) {

    class AircraftDescriptionHolder(val binding: ItemDescriptionAircraftBinding) :
        RecyclerView.ViewHolder(binding.root)

    object ItemCallback : DiffUtil.ItemCallback<TextModel>() {
        override fun areItemsTheSame(oldItem: TextModel, newItem: TextModel): Boolean {
            return oldItem.text == newItem.text
        }

        override fun areContentsTheSame(oldItem: TextModel, newItem: TextModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AircraftDescriptionHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDescriptionAircraftBinding.inflate(inflater, parent, false)
        return AircraftDescriptionHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: AircraftDescriptionHolder, position: Int) {
        val aircraft = getItem(position)
        with(holder.binding) {
            if (aircraft.isHeader) {
                headTitleTv.text = aircraft.text
                descriptionTv.visibility = View.GONE
            } else {
                headTitleTv.visibility = View.GONE
                descriptionTv.text = aircraft.text
            }
        }
    }
}