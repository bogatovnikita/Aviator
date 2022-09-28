package com.elephant.aviator.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.elephant.aviator.R
import com.elephant.aviator.databinding.ItemViewPagerBinding

class ViewPagerAdapter(private val listPictures: Set<String>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {

    class ViewPagerHolder(val binding: ItemViewPagerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewPagerBinding.inflate(inflater, parent, false)
        return ViewPagerHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val picture = listPictures.elementAt(position)
        holder.binding.imageViewPager.load(picture) {
            placeholder(R.drawable.ic_image_search)
        }
    }

    override fun getItemCount(): Int = listPictures.size
}