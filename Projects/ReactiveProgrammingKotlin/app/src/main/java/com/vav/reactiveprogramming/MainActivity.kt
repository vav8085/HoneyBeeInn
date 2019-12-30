package com.vav.reactiveprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.rxkotlin.subscribeBy

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observables()
        disposingAndTerminating()
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
        println("expanded lambda")
        listObservable.subscribe({list: List<Int> -> list.forEach { item: Int -> println(item) }})

        //Notice here that just, fromIterable etc are called operators on observables. These two above are operators
        //used to create observables.
        println("empty observable")        // unit = void in java
        val emptyObservable = Observable.empty<Unit>()
        //The subscribeBy method lets you specify which block you want to execute
        emptyObservable.subscribeBy (onNext = { println(it)}, onError = { println(it.localizedMessage)},onComplete = { println("Completed")})

        println("observable from range")
        val rangeObservable = Observable.range(1,15)
        rangeObservable.subscribeBy (onNext = {println(it)})

        println("print fibonacci")
        val fiboObservable = Observable.range(1,5)
        fiboObservable.subscribeBy (onNext = {
            //ToDo implement a fibonacci sequence in a method and call it here
        })
    }

    private fun disposingAndTerminating() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
