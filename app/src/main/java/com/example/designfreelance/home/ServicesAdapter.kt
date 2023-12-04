package com.example.designfreelance.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.designfreelance.R

class ServicesAdapter(private val arrayList: ArrayList<ServiceItem>) : Adapter<ServicesAdapter.ServicesViewHolder>() {

    class ServicesViewHolder(view: View) : ViewHolder(view) {
        val textServiceName: TextView = view.findViewById(R.id.textServiceName)
        val textServiceDescription: TextView = view.findViewById(R.id.textServiceDescription)
        val textServicePeriod: TextView = view.findViewById(R.id.textServicePeriod)
        val textServicePrice: TextView = view.findViewById(R.id.textServicePrice)
        val imageService: ImageView = view.findViewById(R.id.imageService)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        return ServicesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_service, parent, false))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.textServiceName.text = arrayList[position].name
        holder.textServiceDescription.text = arrayList[position].description
        holder.textServicePrice.text = arrayList[position].price
        holder.textServicePeriod.text = holder.itemView.context.getString(arrayList[position].period.periodText)
        holder.imageService.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context, arrayList[position].type.imageType))
    }

}