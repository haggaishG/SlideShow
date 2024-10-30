package com.haggai.myslideshow.view_model

import android.app.Application
import android.os.CountDownTimer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.haggai.myslideshow.model.NvsFetchedMeta
import com.haggai.myslideshow.model.PlayListItem
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.net.HttpURLConnection
import java.net.URL

val SLIDE_DISPLAY_INTERVAL:Long = 40*1000
class MainViewModel(application: Application) :
    AndroidViewModel(application)
{



    val creativeFechBaseUrl:String = "https://test.onsignage.com/PlayerBackend/creative/get/";
    val itemToPlay: LiveData<PlayListItem> get() = _item
    val error: LiveData<String> get() = _error
    private lateinit var listToPlay:List<PlayListItem>
    private lateinit var displayTimer:CountDownTimer
    var creativeIndex:Int = 0


    interface ApiService {
        @GET("PlayerBackend/screen/playlistItems/e490b14d-987d-414f-a822-1e7703b37ce4")
        suspend fun fetchExampleData(): NvsFetchedMeta
    }

    object RetrofitInstance {
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://test.onsignage.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: ApiService = retrofit.create(ApiService::class.java)
    }





    fun fetchData() {
        viewModelScope.launch {
            try {
                val parsedData = RetrofitInstance.api.fetchExampleData()
                if(parsedData != null){
                    listToPlay = ArrayList<PlayListItem>()
                    for(list in parsedData.playlists){

                        listToPlay = listToPlay+list.playlistItems
                    }
                    if(listToPlay.isNotEmpty()){
                        displayTimer = object : CountDownTimer(100* SLIDE_DISPLAY_INTERVAL, SLIDE_DISPLAY_INTERVAL) {

                            override fun onTick(millisUntilFinished: Long) {
                                setCurrentCreative()
                            }

                            override fun onFinish() {
                                displayTimer.start()
                            }
                        }
                        displayTimer.start()
                    }
                }
            } catch (e: Exception) {
                _error.value = "Error fetching data: ${e.message}"
            }
        }
    }


    private fun setCurrentCreative(){
        if(listToPlay.isEmpty())
            return
        _item.value = listToPlay.get(creativeIndex++ % listToPlay.size )
    }

    private val _item = MutableLiveData<PlayListItem>()
    private val _error = MutableLiveData<String>()
}