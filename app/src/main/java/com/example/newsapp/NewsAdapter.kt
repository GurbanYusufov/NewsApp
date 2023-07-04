package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private var articleList: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val content: TextView = itemView.findViewById(R.id.contentTextView)
        val img: ImageView = itemView.findViewById(R.id.img_news)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articleList[position]
        holder.titleTextView.text = article.title
        holder.dateTextView.text = article.publishedAt
        holder.content.text=article.content


        Glide.with(holder.itemView.context)
            .load(article.urlToImage)
            .into(holder.img)

    }

    override fun getItemCount(): Int {
        return articleList.size
    }


    fun updateData(newArticleList: List<Article>) {
        this.articleList = newArticleList
        notifyDataSetChanged()
    }
}