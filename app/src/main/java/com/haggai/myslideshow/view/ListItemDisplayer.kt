package com.haggai.myslideshow.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.VideoView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.haggai.myslideshow.R
import com.haggai.myslideshow.databinding.ListItemDisplayerBinding
import com.haggai.myslideshow.utils.VideoPlayer
import com.haggai.myslideshow.utils.isImageFile
import com.haggai.myslideshow.utils.isVideoFile
import java.io.File
import androidx.lifecycle.LifecycleOwner

class ListItemDisplayer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private var binding: ListItemDisplayerBinding
    private lateinit var videoPlayer: VideoPlayer
    private var fadeIn :AlphaAnimation
    private var fadeOut: AlphaAnimation
    var isDisplaying = false;
    init { // inflate binding and add as view
        binding = ListItemDisplayerBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)
        fadeIn  = AlphaAnimation(0f, 1f)
        fadeOut = AlphaAnimation(1f, 0f)
        fadeIn.interpolator = DecelerateInterpolator()
        fadeIn.duration = 5000

        fadeOut.interpolator = AccelerateInterpolator()
        fadeOut.duration = 5000

    }

    fun loadContent(contentPath:String){
        var file =  File(contentPath)
        if(isImageFile(contentPath)){
            loadImage(contentPath)
        }else if (isVideoFile(contentPath)){
            loadVideo(contentPath)
        } else {
            loadError()
        }
        isDisplaying = true
        fadeIn.reset()
        this.setAnimation(fadeIn)
    }

    private fun loadVideo(contentPath: String) {
        binding.imageViewContainer.visibility = GONE
        binding.videoViewContainer.visibility = VISIBLE
        var videoView = VideoView(context)
        videoPlayer = VideoPlayer(this.context, videoView, contentPath)
        val lifecycleOwner = context as? LifecycleOwner
        val lifecycle = lifecycleOwner?.lifecycle
        lifecycle?.addObserver(videoPlayer)
        videoPlayer.initializePlayer()
        binding.videoViewContainer.removeAllViews()
        binding.videoViewContainer.addView(videoView,LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT)
    }

    private fun loadImage(path: String) {
        binding.imageViewContainer.visibility = VISIBLE
        binding.videoViewContainer.visibility = GONE
        var imageView = ImageView(context)
        // Use Glide to load the image into the ImageView
        Glide.with(this)
            .load(path)
            .placeholder(R.drawable.placeholder_image) // placeholder while loading
            .error(R.drawable.error_icon) // error placeholder if image fails to load
            .diskCacheStrategy(DiskCacheStrategy.ALL) // cache strategy
            .into(imageView) // specify the target ImageView
        binding.imageViewContainer.removeAllViews()
        binding.imageViewContainer.addView(imageView,LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT)
    }
    private fun loadError() {
        binding.imageViewContainer.visibility = VISIBLE
        binding.videoViewContainer.visibility = GONE
        var errorView = ImageView(context)
        // Use Glide to load the image into the ImageView
        errorView.setImageResource(R.drawable.error_icon)
        binding.imageViewContainer.removeAllViews()
        binding.imageViewContainer.addView(errorView,LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT)
    }

}



