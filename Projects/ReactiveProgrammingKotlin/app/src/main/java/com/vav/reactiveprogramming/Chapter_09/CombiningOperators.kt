package com.vav.reactiveprogramming.Chapter_09

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

object CombiningOperators {
    val disposables = CompositeDisposable()
    fun startWith(){
        println("StartWith:")
        val phones = Observable.just("iPhone 10", "iPhone 11")
        val phonesObservable = phones.startWith(listOf("iPhone 6","iPhone 7")) // these will be added to phones observable
        val phonesDisposable = phonesObservable.subscribe { println(it) }
        disposables.add(phonesDisposable)
    }
    fun concat(){
        println("Concat:")

    }
}