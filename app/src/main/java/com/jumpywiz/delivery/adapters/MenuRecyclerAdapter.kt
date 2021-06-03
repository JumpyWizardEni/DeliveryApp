package com.jumpywiz.delivery.adapters

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jumpywiz.delivery.BuildConfig
import com.jumpywiz.delivery.R
import com.jumpywiz.delivery.model.Food
import com.jumpywiz.delivery.model.MenuItem
import com.jumpywiz.delivery.model.RequestAnswer
import com.jumpywiz.delivery.presentation.ui.MenuViewHolder
import com.squareup.picasso.Picasso

class MenuRecyclerAdapter(private val context: Context) : RecyclerView.Adapter<MenuViewHolder>() {
    private var menuItems: MutableList<MenuItem> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item_view_holder, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.minPrice.text = context.getString(R.string.price)
        holder.itemName.text = menuItems[position].foodName
        Picasso.with(context).load(menuItems[position].imageURL).into(holder.menuItemImage)
    }

    fun setData(data: List<MenuItem>) {
        menuItems.clear()
        menuItems.addAll(data)
        this.notifyDataSetChanged()
    }
}