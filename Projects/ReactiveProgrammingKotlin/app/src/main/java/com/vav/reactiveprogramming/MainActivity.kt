package com.vav.reactiveprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vav.reactiveprogramming.Chapter_01.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Observables.observables()
        Disposing.disposingAndTerminating()
        Disposing.compositeDisposables()
        Create.create()
        Factory.factory()
        SingleMaybeCompletable.SingleMaybeCompletable()
    }
}
