package com.vav.reactiveprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vav.reactiveprogramming.Chapter_01.Create
import com.vav.reactiveprogramming.Chapter_01.Disposing
import com.vav.reactiveprogramming.Chapter_01.Observables

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Observables.observables()
        Disposing.disposingAndTerminating()
        Disposing.compositeDisposables()
        Create.create()
    }
}
