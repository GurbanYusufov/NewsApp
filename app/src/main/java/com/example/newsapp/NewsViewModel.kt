package com.example.newsapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    val newsLiveData = MutableLiveData<List<Article>>()

    fun fetchNews() {
        MainScope().launch {
            val news = NewsRepository.getNews()
            newsLiveData.value = news.articles
        }
    }
}