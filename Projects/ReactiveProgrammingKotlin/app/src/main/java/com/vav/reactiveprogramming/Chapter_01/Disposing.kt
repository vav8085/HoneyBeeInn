package com.vav.reactiveprogramming.Chapter_01

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

/**
 * If you forget to dispose a subscription after you are done with it then it can cause memory leaks
 *
 * THere are many doOn methods which can be used to add side effects by adding handlers which will take some action but will
 * not affect observable. doOnDispose
 */
object Disposing {
     fun disposingAndTerminating() {
        // An observable does not emit objects until a subscriber is attached to it
         // An observable does not stop emitting until it receives a complete or an error
         val observable: Observable<String> = Observable
             .just("Hello","This","is","Reactive", "Programming")
             .doOnSubscribe { println("Subscribed!!!!") }
         //The subscribe method returns a disposable
         val disposable = observable.subscribe {
             println(it)
         }
        disposable.dispose()
    }
    fun compositeDisposables(){
        val observable: Observable<Int> = Observable.just(1,2,3,4,5,6)
        val disposables = CompositeDisposable() // an object where you can keep all the disposables
        val disposable = observable.subscribe({ println(it)})
        disposables.add(disposable)
        disposables.dispose() //disposes all the disposables here
    }
}