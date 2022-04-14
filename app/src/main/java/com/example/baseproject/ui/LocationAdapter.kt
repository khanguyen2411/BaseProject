package com.example.baseproject.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.R
import com.example.baseproject.data.model.Location

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationHolder>() {
    private var locationsList = mutableListOf<Location>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Location>) {
        locationsList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.location_item, parent, false)

        return LocationHolder(view)
    }

    override fun onBindViewHolder(holder: LocationHolder, position: Int) {
        val location = locationsList[position]
        holder.tvTitle?.text = location.title
        holder.tvLattLong?.text = location.latt_long
        holder.tvLocation?.text = location.location_type
        holder.tvWoeId?.text = location.woeid.toString()
    }

    override fun getItemCount(): Int = locationsList.size

    class LocationHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView? = itemView.findViewById(R.id.tvTitleContent)
        val tvLocation: TextView? = itemView.findViewById(R.id.tvLocationTypeContent)
        val tvWoeId: TextView? = itemView.findViewById(R.id.tvWoeIdContent)
        val tvLattLong: TextView? = itemView.findViewById(R.id.tvLattLongContent)
    }
}