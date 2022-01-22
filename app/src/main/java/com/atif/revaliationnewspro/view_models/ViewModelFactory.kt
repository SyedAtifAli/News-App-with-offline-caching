package com.atif.revaliationnewspro.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atif.revaliationnewspro.repo.NewsRepository

class ViewModelFactory(private val repository: NewsRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsListViewModel(repository) as T
    }
}