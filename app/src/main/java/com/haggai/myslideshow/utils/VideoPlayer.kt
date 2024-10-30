package com.haggai.myslideshow.utils

import android.content.Context
import android.net.Uri
import android.widget.VideoView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class VideoPlayer(
    private val context: Context,
    private val videoView: VideoView,
    private val videoUrl: String
) : LifecycleObserver {

    // Initialize video and prepare it
    fun initializePlayer() {
        val uri = Uri.parse(videoUrl)
        videoView.setVideoURI(uri)
        videoView.setOnPreparedListener {
            videoView.start()  // Start playing automatically when prepared
        }
    }

    // Release video resources when no longer needed
    fun releasePlayer() {
        videoView.stopPlayback()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pausePlayer() {
        if (videoView.isPlaying) {
            videoView.pause()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resumePlayer() {
        videoView.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        releasePlayer()
    }
}