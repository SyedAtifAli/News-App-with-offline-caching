package com.atif.revaliationnewspro.view_models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atif.revaliationnewspro.model.api.Article
import com.atif.revaliationnewspro.repo.NewsRepository
import kotlinx.coroutines.launch

class NewsListViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    private val API_KEY = "04705c05a4ca48eda345a77e0a0940c2"

    val news: LiveData<List<Article>>
    get() = repository.news

    init {
        Log.d("atif##","view model init")

        viewModelScope.launch {
            repository.getNews("in",API_KEY)
        }
    }
}