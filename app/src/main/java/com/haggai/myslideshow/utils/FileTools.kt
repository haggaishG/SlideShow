package com.haggai.myslideshow.utils

import java.net.URLConnection
import java.net.URLConnection.guessContentTypeFromName


fun isImageFile(path:String ): Boolean {
    val mimeType = guessContentTypeFromName(path);
    return mimeType != null && mimeType.startsWith("image");
}

fun isVideoFile(path:String):Boolean {
    val mimeType = guessContentTypeFromName(path);
    return mimeType != null && mimeType.startsWith("video");
}