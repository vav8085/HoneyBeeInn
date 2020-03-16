package com.vav.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vav.kotlincoroutines.chapter_03.Content_01_GettingStarted
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val content01Gettingstarted = Content_01_GettingStarted()
        content01Gettingstarted.joiningCoroutines()
    }
}
