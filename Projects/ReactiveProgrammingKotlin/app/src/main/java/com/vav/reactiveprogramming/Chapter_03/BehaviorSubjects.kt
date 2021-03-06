package com.vav.reactiveprogramming.Chapter_03

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.BehaviorSubject

object BehaviorSubjects {
    /**
     * BehaviorSubject can be initialized with a default value. When a subscriber
     *
     * These are useful when we want to update views with some existing value until new value is observed.
     *
     * Usually we dont pass subjects as observables. THe reason is because they can be used to send data.
     *
     * We usually call the hide() method of this subject to get its Observable. We can pass this observable and pass it everywhere.
     */
    fun behaviorSubjects(){
        println("BehaviorSubject:")
        val disposables = CompositeDisposable()

        val behaviorSubject = BehaviorSubject.createDefault(0)
        // 0 will be printed by the subscription because it will replay the default value if there is no new value
        val disposable1 = behaviorSubject.subscribeBy(onNext = { println("subscriber1 ${it}")}, onComplete = { println("Complete 1")})
        disposables.add(disposable1)

        behaviorSubject.onNext(1)
        behaviorSubject.onNext(2)
        //2 will be printed by below subscription because it can be replayed. subscription 1 will print 1,2,3
        val disposable2 = behaviorSubject.subscribeBy(onNext = { println("subscriber2 ${it}")}, onComplete = { println("Complete 2")})
        disposables.add(disposable2)

        behaviorSubject.onNext(3)
        behaviorSubject.onComplete() //complete will be sent to both subscribers
        disposables.dispose()
    }

}