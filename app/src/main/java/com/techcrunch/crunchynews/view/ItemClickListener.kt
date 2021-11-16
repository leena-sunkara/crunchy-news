package com.techcrunch.crunchynews.view

import com.techcrunch.crunchynews.model.ArticlesModel

interface ItemClickListener {
    fun onItemClicked(model: ArticlesModel, position: Int)
}