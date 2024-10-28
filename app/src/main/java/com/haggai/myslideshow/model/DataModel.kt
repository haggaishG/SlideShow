package com.haggai.myslideshow.model

import android.net.Uri




//{
//    "screenKey": "e490b14d-987d-414f-a822-1e7703b37ce4",
//    "breakpointInterval": 0,
//    "playlists": [
//    {
//        "channelTime": 0,
//        "playlistItems": [
//        "fileKey": "62ee6d0f-e058-43ce-907c-4133f12999c1.jpg"
//        ]
//    }
//    ]
//}
data class PlayListItem( val fileKey:String){
}


data class PlayList(val channelTime:Int, val playlists:List<PlayListItem>){
}
data class NvsFetchedMeta(val screenKey:String, val breakPointInterval:Int,val playLists:List<PlayList> ){}
