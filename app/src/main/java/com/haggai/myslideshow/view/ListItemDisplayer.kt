package com.haggai.myslideshow.view

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.haggai.myslideshow.databinding.ListItemDisplayerBinding

class ListItemDisplayer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private var binding: ListItemDisplayerBinding

    init { // inflate binding and add as view
        binding = ListItemDisplayerBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)
    }

    fun loadContent(contentKey:String){
        return ; //TODO
    }

}

data class MediaItem(
    val uri: Uri,
    val type: MediaType // Enum to indicate IMAGE or VIDEO
)

enum class MediaType {
    IMAGE, VIDEO
}


