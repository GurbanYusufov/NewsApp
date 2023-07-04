package com.example.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        swipeRefreshLayout = binding.swipeRefresh
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        newsAdapter = NewsAdapter(emptyList())
        recyclerView.adapter = newsAdapter
        newsViewModel.fetchNews()

        newsViewModel.newsLiveData.observe(this, { newsList ->
            newsAdapter.updateData(newsList)
        })
        swipeRefreshLayout.setOnRefreshListener {
            refreshContent()
        }
    }
    private fun refreshContent() {
        newsViewModel.newsLiveData.observe(this, { newsList ->
            newsAdapter.updateData(newsList)
            Toast.makeText(applicationContext,"Data Guncellendi",Toast.LENGTH_LONG).show()
        })
        swipeRefreshLayout.isRefreshing = false
    }
}