package com.rizky.myrecyclerviewjava

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import java.util.ArrayList

class GridHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_hero, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
                .load(listHero[position].photo)
                .apply(RequestOptions().override(350, 550))
                .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    internal inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView

        init {
            imgPhoto = itemView.findViewById(R.id.img_item_photo)
        }
    }
}