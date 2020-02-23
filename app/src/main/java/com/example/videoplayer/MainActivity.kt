package com.example.videoplayer

import android.net.Uri
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity() : AppCompatActivity(), Parcelable {
    //create class reference
    private var vid: VideoView? = null

    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vid = findViewById<View>(R.id.videoView) as VideoView

    }

    fun View.playVideo() {
        val m = MediaController(this@MainActivity)
        vid!!.setMediaController(m)
        val path = "android.resource://com.example.videoPlayer/" + R.raw.elmo
        val u = Uri.parse(path)
        vid!!.setVideoURI(u)
        vid!!.start()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}