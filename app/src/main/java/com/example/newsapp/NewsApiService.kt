package com.example.newsapp

import retrofit2.http.GET

interface NewsApiService {
    @GET("top-headlines?country=us&apiKey=cb783fc0425c4c71bf69e4a0bb4631c7")

    suspend fun getNews(): News
}