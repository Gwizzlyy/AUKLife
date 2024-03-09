package com.gwizz.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gwizz.myapplication.databinding.RvcategoryStructureBinding
import com.gwizz.myapplication.models.CategoryModel


class CategoryAdapter(private val categoryList : List<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    class MyViewHolder(private val binding: RvcategoryStructureBinding) :
        RecyclerView.ViewHolder(binding.root){
            //bind Data
            fun bindData(category : CategoryModel){
                binding.tvThumbnailText.text = category.name
                Glide.with(binding.ivThumbnail).load(category.coverurl).into(binding.ivThumbnail)
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