package com.neha.fabcoder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.neha.fabcoder.R
import com.neha.fabcoder.data.model.DrinksList
import kotlinx.android.synthetic.main.list_item_layout.view.*

class DrinksListAdapter(
    private val DrinksLists: ArrayList<DrinksList>
) : RecyclerView.Adapter<DrinksListAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(DrinksList: DrinksList) {
            itemView.textViewUserName.text = DrinksList.drinks[0].strDrink
            Glide.with(itemView.imageViewAvatar.context)
                .load(DrinksList.drinks[0].strDrinkThumb)
                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = DrinksLists.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(DrinksLists[position])

    fun addData(list: List<DrinksList>) {
        DrinksLists.addAll(list)
    }

}