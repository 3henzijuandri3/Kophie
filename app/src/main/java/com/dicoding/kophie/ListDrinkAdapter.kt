package com.dicoding.kophie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListDrinkAdapter(private val listDrink: ArrayList<Drinks>) : RecyclerView.Adapter<ListDrinkAdapter.ListViewHolder>() {
//    companion object {
//        const val KEY_DRINKS = "key_drinks"
//    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_drink, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listDrink.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, ingredients ,photo) = listDrink[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{
            val intentToDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentToDetail.putExtra(DetailActivity.KEY_DRINKS, listDrink[holder.adapterPosition])
            holder.itemView.context.startActivity(intentToDetail)
        }
    }

}































