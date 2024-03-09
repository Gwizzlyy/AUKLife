package com.gwizz.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.gwizz.myapplication.adapters.CategoryAdapter
import com.gwizz.myapplication.databinding.ActivityMainBinding
import com.gwizz.myapplication.models.CategoryModel


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var categoryAdapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getHomeContent()

    }

    // return all documents
    fun getHomeContent(){
        FirebaseFirestore.getInstance().collection("newest_banners").get().addOnSuccessListener {
            val categoryList = it.toObjects(CategoryModel::class.java)
            rvContentSetup(categoryList)
        }

    }

    fun rvContentSetup(categoryList : List<CategoryModel>){
        categoryAdapter = CategoryAdapter(categoryList)
        binding.rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = categoryAdapter
    }
}