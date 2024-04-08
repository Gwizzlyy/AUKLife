package com.gwizz.myapplication.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.gwizz.myapplication.PodcastsActivity
import com.gwizz.myapplication.databinding.RvcategoryStructureBinding
import com.gwizz.myapplication.models.CategoryModel


class CategoryAdapter(private val categoryList : List<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    class MyViewHolder(private val binding: RvcategoryStructureBinding) :
        RecyclerView.ViewHolder(binding.root){
            //bind Data
            fun bindData(category : CategoryModel){
                binding.tvThumbnailText.text = category.name
                Glide.with(binding.ivThumbnail).load(category.coverurl).apply(RequestOptions().transform(RoundedCorners(32)))
                    .into(binding.ivThumbnail)
                Log.i("Podcasts",category.podcasts.size.toString())

                //  Start Podcast Activity
                val context = binding.root.context
                binding.root.setOnClickListener {
                    PodcastsActivity.category = category
                    context.startActivity(Intent(context, PodcastsActivity::class.java)) }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvcategoryStructureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(categoryList[position])
    }
}