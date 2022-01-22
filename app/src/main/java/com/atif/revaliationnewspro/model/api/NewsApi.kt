package com.atif.revaliationnewspro.model.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country : String , @Query("apiKey") api: String) : Response<NewsList>
}