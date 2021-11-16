package com.techcrunch.crunchynews.view

import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techcrunch.crunchynews.R
import com.techcrunch.crunchynews.model.ArticlesModel

class NewsViewHolder(itemView: View, var itemClickListener: ItemClickListener) :
    RecyclerView.ViewHolder(itemView) {

    private var image: ImageView = itemView.findViewById(R.id.newsImage)
    private var title: TextView = itemView.findViewById(R.id.newsTitle)
    private var description: TextView = itemView.findViewById(R.id.newsDescription)
    private var author: TextView = itemView.findViewById(R.id.newsAuthor)
    private var relativeLayout: RelativeLayout = itemView.findViewById(R.id.relativeLayout)

    fun setData(articlesModel: ArticlesModel) {
        Glide.with(itemView).load(articlesModel.urlToImage)
            .placeholder(R.drawable.playo_logo).into(image)
        title.text = articlesModel.title
        description.text = articlesModel.description
        author.text = articlesModel.author
        relativeLayout.setOnClickListener {
            itemClickListener.onItemClicked(articlesModel, adapterPosition)
        }
    }
}