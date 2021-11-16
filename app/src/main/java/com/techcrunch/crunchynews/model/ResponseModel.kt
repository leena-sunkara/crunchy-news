package com.techcrunch.crunchynews.model

data class ResponseModel(
	val status: String? = null,
	val totalResults: Int? = null,
	val articles: List<ArticlesModel?>? = null
)