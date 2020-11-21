package com.indiewalkabout.mapo.shoppingcart.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.indiewalkabout.mapo.shoppingcart.R
import com.indiewalkabout.mapo.shoppingcart.databinding.ShoppingListItemBinding
import com.indiewalkabout.mapo.shoppingcart.model.ShoppingItem

class ShoppingAdapter(val items: ArrayList<ShoppingItem>, val context: Context,
                      val itemEditListener: (position: Int) -> Unit,
                      val itemDeleteListener: (position: Int) -> Unit) : RecyclerView.Adapter<ViewHolder>() {
    // Gets the number of groceries in the list
    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ShoppingListItemBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.shopping_list_item,
                parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val description = item.amount.toString() + "x: " + item.itemName
        holder.bind(items[position])
        holder.binding.buttonEdit.setOnClickListener { itemEditListener(position) }
        holder.binding.buttonDelete.setOnClickListener { itemDeleteListener(position) }
    }
}

class ViewHolder(val binding: ShoppingListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ShoppingItem) {
        binding.apply {
            itemName = "${item.amount}x: ${item.itemName}"
            price = item.price.toString()
        }
    }
}