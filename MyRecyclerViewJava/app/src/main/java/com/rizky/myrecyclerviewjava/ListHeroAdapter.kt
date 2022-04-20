package com.rizky.myrecyclerviewjava

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import java.util.ArrayList

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_hero, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]
        Glide.with(holder.itemView.context)
                .load(hero.photo)
                .apply(RequestOptions().override(55, 55))
                .into(holder.imgPhoto)
        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    internal inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView
        var tvName: TextView
        var tvDetail: TextView

        init {
            imgPhoto = itemView.findViewById(R.id.img_item_photo)
            tvName = itemView.findViewById(R.id.tv_item_name)
            tvDetail = itemView.findViewById(R.id.tv_item_detail)
        }
    }
}