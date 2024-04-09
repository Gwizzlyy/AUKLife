package com.gwizz.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.OptIn
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.gwizz.myapplication.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {

    lateinit var binding: ActivityPlayerBinding
    lateinit var exoPlayer : ExoPlayer
    @OptIn(UnstableApi::class) override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ExoplayerClass.getCurrentMedia()?.apply {
            binding.tvCurrentTitle.text = title
            binding.tvCurrentSubtitle.text = subtitle
            Glide.with(binding.ivCurrentCover).load(coverurl).apply(
                RequestOptions().transform(
                    RoundedCorners(32)
                ))
                .into(binding.ivCurrentCover)

            exoPlayer = ExoplayerClass.getInstance()!!
            binding.playerView.player = exoPlayer
            binding.playerView.showController()


        }

    }
}