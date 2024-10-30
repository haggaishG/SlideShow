package com.haggai.myslideshow.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.haggai.myslideshow.databinding.ContentExchangeContainerBinding

class ExchangeContainer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private var binding: ContentExchangeContainerBinding

    init { // inflate binding and add as view
        binding = ContentExchangeContainerBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)
    }

    fun loadContent(creativeKey:String){
        when (binding.firstDisplayer.isDisplaying) {
            true -> {
                binding.secondDisplayer.loadContent(creativeKey)
                binding.firstDisplayer.visibility = GONE
                binding.secondDisplayer.visibility = VISIBLE
            }

            else ->{
                binding.firstDisplayer.loadContent(creativeKey)
                binding.firstDisplayer.visibility = VISIBLE
                binding.secondDisplayer.visibility = GONE

            }
        }
    }

}