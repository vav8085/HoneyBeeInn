package com.vav.reactiveprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observables()
    }

    private fun observables() {
        //creating an observable using just
        val intObservable: Observable<Int> = Observable.just(1)
        //crearting an observable with 10 items max, it will emit 10 items
        val intsObservable: Observable<Int> = Observable.just(1,2,3,4,5,6,7,8,9,0)
        //This observable will emit a single item which will be a list
        val listObservable = Observable.just(listOf(1,2,3,4,5,6,7))
        //fromIterable creates an observable which emits items in the list one at a time
        val observableFromIterable = Observable.fromIterable(listOf(1,2,3,4,5))

        //Subscribing to the observables
        observableFromIterable.subscribe({ println(it)})
        println("list observable values")
        listObservable.subscribe({
            it.forEach { println(it) }
        })
    }
}
