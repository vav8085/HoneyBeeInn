package com.vav.reactiveprogramming.Chapter_02

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

object Factory {
    /**
     * you can create observable factories which return different observables depending on condition
     */
    fun factory(){
        val disposables = CompositeDisposable()
        val choice = 0
        val factory = Observable.defer {
            if(choice==1){
                Observable.just(1,2,3)
            }else{
                Observable.just(40,50,60)
            }
        }
        val disposable = factory.subscribe({ println(it)})
        disposables.add(disposable)
        disposables.dispose()
    }
}