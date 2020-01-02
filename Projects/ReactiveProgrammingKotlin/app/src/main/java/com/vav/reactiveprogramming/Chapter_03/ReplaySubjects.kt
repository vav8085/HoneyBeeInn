package com.vav.reactiveprogramming.Chapter_03

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.ReplaySubject

object ReplaySubjects {

    /**
     *  ReplaySubject comes with a buffer where you can save as many values that can be replayed to a new subscriber.
     *  The buffer is in the memory so we have to be careful about the size of the buffer for larger objects like pictures.
     *
     *  note that buffered elements will keep getting printed even after onComplete or onError are called
     */
    fun replaySubjects(){
        println("ReplaySubject:")
        val disposables = CompositeDisposable()

        val replaySubject = ReplaySubject.createWithSize<Int>(2) //2 is the size of the buffer
        replaySubject.onNext(1)
        replaySubject.onNext(2)
        replaySubject.onNext(3)
        //This will print 2,3 and 4 because the capacity is 2 so 1 wont be in the buffer
        val disposable1 = replaySubject.subscribeBy(onNext = { println("Subscription1 ${it}")},onComplete = { println("Completed 1")})
        disposables.add(disposable1)
        replaySubject.onNext(4)
        val disposable2 = replaySubject.subscribeBy(onNext = { println("Subscription2 ${it}")},onComplete = { println("Completed 2")})
        disposables.add(disposable2)
        replaySubject.onNext(5)
        replaySubject.onComplete()
        //This will keep printing 4 and 5 because buffer remains even after completion
        val disposable3 = replaySubject.subscribeBy(onNext = { println("Subscription3 ${it}")},onComplete = { println("Completed 3")})
        disposables.add(disposable3)
        disposables.dispose()
    }
}