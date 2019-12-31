package com.vav.reactiveprogramming.Chapter_01

import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe
import io.reactivex.rxkotlin.subscribeBy

object SingleMaybeCompletable {
    /**
     * Along with Observables we have other kind of observables as well.
     * Single, Maybe and Completable
     *
     * Single:
     *  Singles either return a success or error events. Success is combination of next and complete
     *  success returns a value.
     *  This is good when we do some operation that runs only once, does it work and returns either results or fails.
     *
     *  Completable:
     *  Returns either completed or error, completed does not have a value. It just tells that operation
     *  completed successfully.
     *
     */
    fun SingleMaybeCompletable(){
        val single = Single.create(object : SingleOnSubscribe<String>{
            override fun subscribe(emitter: SingleEmitter<String>) {
                emitter.onSuccess("Emitting single!")
            }
        })
        //val disposable = single.subscribe{println(it)} // this does not work due to some reason
        val disposable = single.subscribeBy {println(it)}
        disposable.dispose()
    }
}