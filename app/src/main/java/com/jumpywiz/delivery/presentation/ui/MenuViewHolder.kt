package com.jumpywiz.delivery.presentation.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jumpywiz.delivery.R

class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val minPrice = itemView.findViewById(R.id.minPrice) as TextView
    val itemName = itemView.findViewById(R.id.menuItemName) as TextView
    val menuItemImage = itemView.findViewById(R.id.menuItemImage) as ImageView
}