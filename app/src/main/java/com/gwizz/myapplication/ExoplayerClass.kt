package com.gwizz.myapplication

import android.annotation.SuppressLint
import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.gwizz.myapplication.models.PodcastModel

object ExoplayerClass {

    private var exoPlayer : ExoPlayer? = null
    private var currentMedia : PodcastModel? = null


    fun getInstance() : ExoPlayer? {
        return exoPlayer
    }

    fun getCurrentMedia(): PodcastModel? {
        return currentMedia
    }


    @SuppressLint("SuspiciousIndentation")
    fun startPlaying(context : Context, media : PodcastModel){
        if(exoPlayer== null)
        exoPlayer = ExoPlayer.Builder(context).build()
        if(currentMedia != media){
            currentMedia = media
            currentMedia?.url?.apply {
                val mediaItem = MediaItem.fromUri(this)
                exoPlayer?.setMediaItem(mediaItem)
                exoPlayer?.prepare()
                exoPlayer?.play()

            }
        }



    }
}