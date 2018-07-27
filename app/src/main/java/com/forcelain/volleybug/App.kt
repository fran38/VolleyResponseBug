package com.forcelain.volleybug

import android.app.Application
import android.graphics.Bitmap
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley

class App : Application() {

    lateinit var queue: RequestQueue
    lateinit var imageLoader: ImageLoader

    override fun onCreate() {
        super.onCreate()
        queue = Volley.newRequestQueue(this)
        queue.start()
        imageLoader = ImageLoader(queue, NoImageCache())
    }

    class NoImageCache : ImageLoader.ImageCache {

        override fun getBitmap(url: String?): Bitmap? = null

        override fun putBitmap(url: String?, bitmap: Bitmap?) {}

    }
}