package com.vav.reactiveprogramming.Chapter_02

import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.disposables.CompositeDisposable

/**
 * Create function is used to create custom observables of a specific type
 * it takes an object of ObservableOnSubscribe which is a SAM(functional interface)
 * the sam has a single method subscribe where you can emit any stream
 * you can also pass a lambda to create
 *
 * rest all is same, you get an observable returned from create, you call subscribe from it and
 * return a disposable and then you can dispose this disposable
 *
 * If you dont dispose the disposable and do not call onError or onComplete then memory will leak
 */
object Create {
    fun create(){
        val disposables = CompositeDisposable()
        val observable = Observable.create(object : ObservableOnSubscribe<String>{
            override fun subscribe(emitter: ObservableEmitter<String>) {
                emitter.onNext("Hello")
                emitter.onNext("we")
                emitter.onNext("are")
                emitter.onNext("emitting!")
                emitter.onComplete()
            }
        })
        val disposable = observable.subscribe({println(it)})
//        val disposable = observable.subscribe(object : Observer<String>{
//            override fun onComplete() {
//            }
//
//            override fun onSubscribe(d: Disposable) {
//            }
//
//            override fun onNext(t: String) {
//            }
//
//            override fun onError(e: Throwable) {
//            }
//        })
        disposables.add(disposable)
        disposables.dispose()
    }
}