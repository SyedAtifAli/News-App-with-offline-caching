package com.atif.revaliationnewspro.model.api

data class NewsList(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)