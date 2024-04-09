package com.gwizz.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.gwizz.myapplication.adapters.FactalkAdapter
import com.gwizz.myapplication.adapters.PodcastAdapter
import com.gwizz.myapplication.databinding.ActivityPodcastsBinding
import com.gwizz.myapplication.models.CategoryModel

class FactalkActivity : AppCompatActivity() {

    companion object {
        lateinit var category : CategoryModel
    }

    lateinit var binding: ActivityPodcastsBinding
    lateinit var factalkAdapter: FactalkAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPodcastsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvCoverTitle.text = category.name
        Glide.with(binding.ivCover).load(category.coverurl).apply(
            RequestOptions().transform(
                RoundedCorners(32)
            ))
            .into(binding.ivCover)
        setupFactRV()

    }

    fun setupFactRV(){
        factalkAdapter = FactalkAdapter(category.factalks)
        binding.rvPodcasts.layoutManager = LinearLayoutManager(this )
        binding.rvPodcasts.adapter = factalkAdapter
    }
}