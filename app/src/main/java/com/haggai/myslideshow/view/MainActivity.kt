package com.haggai.myslideshow.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.haggai.myslideshow.R
import com.haggai.myslideshow.view_model.MainViewModel

import androidx.activity.viewModels

import androidx.lifecycle.Observer
import com.haggai.myslideshow.databinding.ActivityMainBinding
import com.haggai.myslideshow.databinding.ContentExchangeContainerBinding


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        viewModel.itemToPlay.observe(this, Observer { data ->
            data?.let {
                binding.slideDisplayer.loadContent(viewModel.creativeFechBaseUrl+it.creativeKey)
            }
        })

        viewModel.error.observe(this, Observer { errorMessage ->
            errorMessage?.let {
                // Show error message, e.g., Toast or Snackbar
            }
        })

        viewModel.fetchData()
    }
}