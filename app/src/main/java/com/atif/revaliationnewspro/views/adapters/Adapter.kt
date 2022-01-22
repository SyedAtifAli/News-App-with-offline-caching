package com.atif.revaliationnewspro.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.atif.revaliationnewspro.R
import com.atif.revaliationnewspro.model.api.Article
import com.atif.revaliationnewspro.views.fragments.NewsListFragmentDirections
import com.bumptech.glide.Glide

class Adapter(private val list: List<Article>, private val navController: NavController) : RecyclerView.Adapter<Adapter.AdapterViewHolder>() {

    class AdapterViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val newsHeading: TextView = view.findViewById<TextView>(R.id.txt_news_heading)
        val newsTitle: TextView = view.findViewById<TextView>(R.id.txt_news_name)
        val newsTime: TextView = view.findViewById<TextView>(R.id.txt_news_time)
        val newsImg: ImageView = view.findViewById<ImageView>(R.id.img_news_banner)
        val item = view.findViewById<CardView>(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.newsHeading.text = list.get(position).source.name
        holder.newsTitle.text = list.get(position).title
        holder.newsTime.text = list.get(position).publishedAt
        if(list.get(position).urlToImage == null){
            holder.newsImg.setImageResource(R.drawable.placeholder_news)
        }
        else Glide.with(holder.newsImg).load(list.get(position).urlToImage).into(holder.newsImg)

        holder.item.setOnClickListener {
            val action = NewsListFragmentDirections.actionNewsListFragmentToNewsDetailFragment(list.get(position).title,list.get(position).urlToImage,
            list.get(position).source.name,list.get(position).publishedAt,list.get(position).content,list.get(position).url,list.get(position).description)
            navController.navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}