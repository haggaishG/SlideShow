package com.haggai.myslideshow.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ExchageContinerViewModel(application: Application) : AndroidViewModel(application) {

    // Internal MutableLiveData that can be updated within the ViewModel
    private val currentCreativePath = MutableLiveData<String>()

    // Exposed immutable LiveData to be observed by the UI
    val creativeToDisplay: LiveData<String> = currentCreativePath

    // Initialize or update the value of text
    fun updateCreativePath(path: String) {
        currentCreativePath.value = path
    }
}