package com.svkylmz.kotlinrunnables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var counter = 0
    var runnable: Runnable = Runnable {  }
    var handler: Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start (v: View) {
        counter = 0
        runnable = object : Runnable {
            override fun run() {
                counter ++
                textView.text = "Time : $counter"

                handler.postDelayed(this, 1000) //in how many seconds should it run? //1000ms=1second
            }
        }
        handler.post(runnable)
        startButton.isClickable = false
    }

    fun stop (v: View) {
        handler.removeCallbacks(runnable)
        counter = 0
        startButton.isClickable = true
    }
}