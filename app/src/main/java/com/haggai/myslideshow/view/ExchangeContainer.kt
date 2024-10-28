package com.haggai.myslideshow.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.haggai.myslideshow.databinding.ContentExchangeContainerBinding
import com.haggai.myslideshow.databinding.ListItemDisplayerBinding

class ExchangeContainer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private var binding: ContentExchangeContainerBinding

    init { // inflate binding and add as view
        binding = ContentExchangeContainerBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)
    }

    fun loadContent(contentKey:String){
        when (binding.firstDisplayer.isDisplaying) {
            true -> {
                binding.secondDisplayer.loadContent(contentKey)
                binding.secondDisplayer.removeContent()
            }

            else ->{
                binding.firstDisplayer.loadContent(contentKey)
                binding.secondDisplayer.removeContent()
            }
        }
    }

}