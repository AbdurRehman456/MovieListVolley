package com.example.movielistvolley

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdaptar(val context: Context, val movieList:List<Movie>): RecyclerView.Adapter<NewsAdaptar.ArticleViewHolder>(){

    class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var newsImage=itemView.findViewById<ImageView>(R.id.newsImages)
        var newsTitle=itemView.findViewById<TextView>(R.id.newsTitle)
        var newsRating=itemView.findViewById<TextView>(R.id.newsrating)
        var newsOverview=itemView.findViewById<TextView>(R.id.newsOverview1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)

        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val movie:Movie=movieList[position]
        holder.newsTitle.text=movie.title
        holder.newsRating.text=movie.rating.toString()
        holder.newsOverview.text=movie.overview
        Glide.with(context).load(movie.poster).into(holder.newsImage)
        holder.itemView.setOnClickListener {
            val intentt = Intent(context, DetailActivity::class.java).apply {
                putExtra("title", movie.title)
                putExtra("rating", movie.rating)
                putExtra("overview", movie.overview)
                putExtra("poster", movie.poster)
            }
            context.startActivity(intentt)
        }

    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}