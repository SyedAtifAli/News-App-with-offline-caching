package com.atif.revaliationnewspro.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atif.revaliationnewspro.model.api.Article
import com.atif.revaliationnewspro.model.api.NewsApi
import com.atif.revaliationnewspro.model.roomdb.NewsDatabase
import com.atif.revaliationnewspro.util.NetworkUtil.Companion.internetIsConnected

class NewsRepository (
    private val newsApi: NewsApi,
    private val database : NewsDatabase
    ){
    private val newsLiveData = MutableLiveData<List<Article>>()

    val news : LiveData<List<Article>>
    get() = newsLiveData

    suspend fun getNews(country : String, api: String){
        Log.d("atif##","repo getNews")

        if(internetIsConnected()){
            val result = newsApi.getTopHeadlines(country, api)
            if ( result.body() != null ){
                database.newsdao().insert(result.body()!!.articles)
                newsLiveData.value = (result.body()!!.articles)
            }
            else Log.d("atif##","repo getNews result.body is null")
        }
        else
            newsLiveData.postValue(database.newsdao().getNewsfromRoom())

    }
}