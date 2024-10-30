package com.haggai.myslideshow.model

import android.net.Uri
import com.squareup.moshi.Json


//{
//    "screenKey": "e490b14d-987d-414f-a822-1e7703b37ce4",
//    "breakpointInterval": 0,
//    "playlists": [
//    {
//        "channelTime": 0,
//        "playlistItems": [
//        {
//            "creativeRefKey": "7cb17a54-a1ea-4299-a1ed-f5bc67eeef26.jpg",
//            "duration": 10,
//            "expireDate": "9999-12-30 00:00:00",
//            "startDate": "0000-00-00 00:00:00",
//            "collectStatistics": false,
//            "creativeLabel": "10.jpg",
//            "slidePriority": 0,
//            "playlistKey": "804d2f17-25b8-4c2d-aac7-b75cc6c954c6",
//            "creativeKey": "62ee6d0f-e058-43ce-907c-4133f12999c1.jpg",
//            "orderKey": 0,
//            "eventTypesList": []
//        },
//        ]
//    }
//    ]
//}
data class PlayListItem(
    @Json(name = "creativeRefKey") val creativeRefKey : String , // "7cb17a54-a1ea-4299-a1ed-f5bc67eeef26.jpg",
    @Json(name = "duration") val duration : Int , // 10,
    @Json(name = "expireDate") val expireDate : String , // "9999-12-30 00:00:00",
    @Json(name = "startDate") val startDate : String , // "0000-00-00 00:00:00",
    @Json(name = "collectStatistics") val collectStatistics : Boolean , // false,
    @Json(name = "creativeLabel") val creativeLabel : String , // "10.jpg",
    @Json(name = "slidePriority") val slidePriority : Int , // 0,
    @Json(name = "playlistKey") val playlistKey : String , // "804d2f17-25b8-4c2d-aac7-b75cc6c954c6",
    @Json(name = "creativeKey") val creativeKey : String , // "62ee6d0f-e058-43ce-907c-4133f12999c1.jpg",
    @Json(name = "orderKey") val orderKey : Int , // 0,
    @Json(name = "eventTypesList") val eventTypesList : List<String> , // []
)


data class PlayList(
    @Json(name = "channelTime") val channelTime: Int,
    @Json(name = "playlistItems") val playlistItems: List<PlayListItem>
)

data class NvsFetchedMeta(
    @Json(name = "screenKey") val screenKey: String,
    @Json(name = "breakpointInterval") val breakpointInterval: Int,
    @Json(name = "playlists") val playlists: List<PlayList>

)