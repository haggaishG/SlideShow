package com.haggai.myslideshow.view

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.haggai.myslideshow.R
import com.haggai.myslideshow.databinding.ListItemDisplayerBinding
import com.haggai.myslideshow.utils.VideoPlayer
import com.haggai.myslideshow.utils.isImageFile
import com.haggai.myslideshow.utils.isVideoFile
import java.io.File
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
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
            binding.imageView.setImageResource(R.drawable.error_icon)
            binding.imageView.visibility = VISIBLE
            binding.videoView.visibility = GONE
        }
        isDisplaying = true
        this.setAnimation(fadeIn)
    }

    private fun loadVideo(contentPath: String) {
        binding.imageView.visibility = GONE
        binding.videoView.visibility = VISIBLE
        videoPlayer = VideoPlayer(this.context, binding.videoView, contentPath)
        val lifecycleOwner = context as? LifecycleOwner
        val lifecycle = lifecycleOwner?.lifecycle
        lifecycle?.addObserver(videoPlayer)
        videoPlayer.initializePlayer()
    }

    private fun loadImage(path: String) {
        binding.imageView.visibility = VISIBLE
        binding.videoView.visibility = GONE

        // Use Glide to load the image into the ImageView
        Glide.with(this)
            .load(path)
            .placeholder(R.drawable.placeholder_image) // placeholder while loading
            .error(R.drawable.error_icon) // error placeholder if image fails to load
            .diskCacheStrategy(DiskCacheStrategy.ALL) // cache strategy
            .into(binding.imageView) // specify the target ImageView
    }

    fun removeContent(){
        isDisplaying = false
        this.setAnimation(fadeOut)
    }



    /*
    public static String getMimeType(File file, Context context)
{
    Uri uri = Uri.fromFile(file);
    ContentResolver cR = context.getContentResolver();
    MimeTypeMap mime = MimeTypeMap.getSingleton();
    String type = mime.getExtensionFromMimeType(cR.getType(uri));
    return type;
}

     */
}



