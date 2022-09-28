package com.elephant.aviator.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.elephant.aviator.R
import com.elephant.aviator.databinding.ItemCardAircraftBinding
import com.elephant.domain.models.InfoModel

class AircraftCardAdapter(private val listener: Listener) :
    ListAdapter<InfoModel, AircraftCardAdapter.AircraftCardHolder>(ItemCallback),
    View.OnClickListener {

    class AircraftCardHolder(val binding: ItemCardAircraftBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface Listener {
        fun onCLickInfoModel(infoModel: InfoModel)
    }

    object ItemCallback : DiffUtil.ItemCallback<InfoModel>() {
        override fun areItemsTheSame(oldItem: InfoModel, newItem: InfoModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: InfoModel, newItem: InfoModel): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AircraftCardHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardAircraftBinding.inflate(inflater, parent, false)
        binding.root.setOnClickListener(this)

        return AircraftCardHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: AircraftCardHolder, position: Int) {
        val aircraft = getItem(position)

        with(holder.binding) {
            root.tag = aircraft

            titleTv.text = aircraft.title
            if (aircraft.images.isEmpty()) {
                picture.setImageResource(R.drawable.ic_no_picture)
            } else {
                picture.load(aircraft.images.elementAt(0)) {
                    placeholder(R.drawable.ic_image_search)
                }
            }
        }
    }

    override fun onClick(view: View) {
        val airCraft = view.tag as InfoModel
        listener.onCLickInfoModel(airCraft)
    }
}