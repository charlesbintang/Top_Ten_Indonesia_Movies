package com.charles.toptenindonesiamovies

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listHero.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, photo, tahun, penonton, produksi) = listHero[position]
        Glide.with(holder.itemView.context).load(photo).into(holder.imgPhoto)
        holder.tvTitle.text = title
        holder.tvDescription.text = description
        holder.tvTahun.text = "Tahun: $tahun"
        holder.tvPenonton.text = "Penonton: $penonton"

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.EXTRA_DATA, listHero[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        val tvTahun: TextView = itemView.findViewById(R.id.tv_item_tahun)
        val tvPenonton: TextView = itemView.findViewById(R.id.tv_item_penonton)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}