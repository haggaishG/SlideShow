package com.haggai.myslideshow.view

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.DecelerateInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import com.haggai.myslideshow.databinding.ListItemDisplayerBinding

class ListItemDisplayer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private var binding: ListItemDisplayerBinding

    private var fadeIn :AlphaAnimation
    private var fadeOut: AlphaAnimation
    var isDisplaying = false;
    init { // inflate binding and add as view
        binding = ListItemDisplayerBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)
        fadeIn  = AlphaAnimation(0f, 1f)
        fadeOut = AlphaAnimation(1f, 0f)
        fadeIn.interpolator = DecelerateInterpolator()
        fadeIn.duration = 1000

        fadeOut.interpolator = AccelerateInterpolator()
        fadeOut.duration = 1000

    }

    fun loadContent(contentKey:String){
        //TODO
        isDisplaying = true
        this.setAnimation(fadeIn)
    }
    fun removeContent(){
        isDisplaying = false
        this.setAnimation(fadeOut)
    }

}

data class MediaItem(
    val uri: Uri,
    val type: MediaType // Enum to indicate IMAGE or VIDEO
)

enum class MediaType {
    IMAGE, VIDEO
}


