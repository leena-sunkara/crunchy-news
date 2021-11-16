package com.techcrunch.crunchynews.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techcrunch.crunchynews.R
import com.techcrunch.crunchynews.model.ArticlesModel

class NewsAdapter(
    private var articlesList: List<ArticlesModel>,
    private var itemClickListener: ItemClickListener
) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.news_item_layout, parent, false)
        return NewsViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val articlesModel = articlesList[position]
        holder.setData(articlesModel)
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(articlesList: List<ArticlesModel>) {
        this.articlesList = articlesList
        notifyDataSetChanged()
    }
}