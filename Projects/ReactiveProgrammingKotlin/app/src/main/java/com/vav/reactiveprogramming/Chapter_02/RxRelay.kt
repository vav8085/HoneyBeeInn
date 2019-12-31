package com.vav.reactiveprogramming.Chapter_02

import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.disposables.CompositeDisposable

object RxRelay {
    /**
     * Rxrelay can be any kind of subject. The difference is that it does not have either complete or error
     * Its like an infinite stream
     */
    fun rxRelay(){
        println("RxRelay:")
        val disposables = CompositeDisposable()
        val publishRelay = PublishRelay.create<Int>()
        val disposable = publishRelay.subscribe{ println(it)}
        disposables.add(disposable)

        publishRelay.accept(1)
        publishRelay.accept(2)
        publishRelay.accept(3)
        publishRelay.accept(4)

    }
}