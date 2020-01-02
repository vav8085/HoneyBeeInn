package com.vav.reactiveprogramming.Chapter_03

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject

object PublishSubjects {
    /**
     * We usually set data in the observable and then observers subscribe to it. This is good
     * Sometimes we want to keep adding data to the observable MANUALLY. So we need an object to which
     * we can keep adding data whenever we want. And here comes Subjects to help us.
     *
     * Subjects are both observables and observers
     *
     * after onComplete or onError events, the subscribers do not get new onNext events.
     *
     * publish subjects send the new events only to existing subscribers. newer subscribers get the
     * events sent after they are subscribed. older next events wont be shared.
     *
     * an exception to this are error and completion events which will still be sent
     */
    fun publishSubjects(){
        println("PublishSubjects:")
        val disposables = CompositeDisposable()
        val publishSubject = PublishSubject.create<Int>() //creating a publishSubject
        publishSubject.onNext(1) //set data
        publishSubject.onNext(2)
        publishSubject.onNext(3)
        publishSubject.onNext(4)
        val disposable1 = publishSubject.subscribeBy(onNext = { println("Subscriber1 ${it}")}, onComplete = { println("Complete1")})  //subscribe an observer
        disposables.add(disposable1)
        println("Notice that nothing got printed here")
        publishSubject.onNext(5)
        publishSubject.onNext(6)
        publishSubject.onNext(7)
        publishSubject.onNext(8)
        val disposable2 = publishSubject.subscribeBy(onNext = { println("Subscriber2 ${it}")}, onComplete = { println("Complete2")})
        disposables.add(disposable2)
        publishSubject.onNext(9)
        println("values that are emitted to the subscriber after subscription are sent so 5,6,7,8 are printed")
        publishSubject.onComplete()
        publishSubject.onNext(10) //This wont be sent
        val disposable3 = publishSubject.subscribeBy(onNext = { println("Subscriber3 ${it}")}, onComplete = { println("Complete3")})
        //all the subscribers will receive the onComplete event
        disposables.add(disposable3)
        disposables.dispose()
    }
}