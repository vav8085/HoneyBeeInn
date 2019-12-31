package com.vav.reactiveprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vav.reactiveprogramming.Chapter_01.*
import com.vav.reactiveprogramming.Chapter_02.BehaviorSubjects
import com.vav.reactiveprogramming.Chapter_02.PublishSubjects

/**
 * Understand rx java as Observables, observers and subscriber objects
 *
 * Compare it with a normal observer pattern
 * 1. you create an interface that has some methods Observer onSuccess(List data)
 * 2. you create an object of this interface and implement methods and specify what should happen if somebody calls them
 * 3. you pass this object to observables who can call its methods and send data
 *
 * Similarly you have these classes predefined in rxjava.
 *
 * Observer is an interface with methods like, onNext, onComplete and onError
 *
 * you **create its instance**, **implement methods** and  and **pass it to subscribe()** method of an observable object
 * now observable has your observers object and it can call various methods of observer.
 * This is automatically done by just, fromIterable etc methods. You can use create method to call methods on observer and
 * send data. THe data will be sent to all subscribers.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Chapter 1
        Observables.observables()
        Disposing.disposingAndTerminating()
        Disposing.compositeDisposables()
        Create.create()
        Factory.factory()
        SingleMaybeCompletable.SingleMaybeCompletable()
        //Chapter 2
        PublishSubjects.publishSubjects()
        BehaviorSubjects.behaviorSubjects()
    }
}
