package com.gwizz.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.gwizz.myapplication.adapters.CategoryAdapter
import com.gwizz.myapplication.databinding.ActivityMainBinding
import com.gwizz.myapplication.models.CategoryModel

/// TODO: Either setup Magazines, or setup Podcast Player

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var categoryAdapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imgBanner = findViewById<ImageView>(R.id.ivLandingAd)
        getHomeContent()
        supportActionBar?.hide()
        imgBanner.setOnClickListener {
            val explicitIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.auk.edu.kw/"))
            startActivity(explicitIntent)
        }

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