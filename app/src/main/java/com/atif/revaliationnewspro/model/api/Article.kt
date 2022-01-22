package com.atif.revaliationnewspro.model.api

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newstable")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)