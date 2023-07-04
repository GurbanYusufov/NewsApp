package com.example.newsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://newsapi.org/v2/ --> get

object NewsRepository {

    private const val BASE_URL = "https://newsapi.org/v2/"


    private val apiService: NewsApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(NewsApiService::class.java)
    }

    suspend fun getNews(): News {
        return apiService.getNews()
    }
}