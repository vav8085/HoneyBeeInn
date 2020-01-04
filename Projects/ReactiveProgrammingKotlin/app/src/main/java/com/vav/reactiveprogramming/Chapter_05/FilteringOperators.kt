package com.vav.reactiveprogramming.Chapter_05

import com.vav.reactiveprogramming.Chapter_03.BehaviorSubjects
import com.vav.reactiveprogramming.Chapter_03.PublishSubjects
import io.reactivex.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

object FilteringOperators {
    /**
     * Operators can be added to observables. They modify the flow of events. Like if you use ignoreElements
     * the subscribeBy does not have onNext.
     *
     * IgnoreElements is used when we want to block any events except onError and onComplete
     * Even if we try to emit onNext events they wont make it through to observers.
     *
     */
    fun ignoreElements(){
        println("Filtering operators:")
        println()
        println("Ignore Elements:")
        val disposables = CompositeDisposable()
        val numbers = PublishSubject.create<Int>()

        disposables.add(
            numbers.ignoreElements().subscribeBy(onComplete = { println("Stream complete!")})
        )
        numbers.onNext(1)
        numbers.onNext(2)
        numbers.onNext(3)
        numbers.onComplete()
    }

    /**
     * This operator is used when you want a specific event. You receive a maybe observable as a result
     * This is because you may or may not have a value at this specific location. You can implement a success
     * or complete block to perform action on this observable. Remember that success returns only one element
     */
    fun elementAt(){
        println("elementAt:")
        val disposables = CompositeDisposable()
        val observable = Observable.create(object: ObservableOnSubscribe<Int>{
            override fun subscribe(emitter: ObservableEmitter<Int>) {
                emitter.onNext(10)
                emitter.onNext(20)
                emitter.onNext(30)
                emitter.onNext(40)
                emitter.onComplete()
            }
        }).elementAt(2)
        val disposable = observable.subscribeBy(
            onSuccess = {
                println(it)
            },
            onComplete = {
            println("Completed!")
        })
        disposables.add(disposable)
        disposables.dispose()
    }

    /**
     * Filter accepts a predicate which will be applied to each item in the stream. Only the items
     * which qualify the condition in predicate are passed to the stream.
     */
    fun filter(){
        println("filter:")
        val disposables = CompositeDisposable()
        val observable = Observable.fromIterable(listOf(1,2,3,4,5,6)).filter { it > 5 } //only 6 should print
        val disposable = observable.subscribeBy(onNext = {
            println(it)
        })
        disposables.add(disposable)

        val subject = BehaviorSubject.createDefault(0)
        disposables.add(subject.subscribeBy { println(it) })
        subject.onNext(1)
        subject.onNext(2)
        subject.onNext(8)
        subject.onNext(9)
        subject.onNext(11)
        subject.filter { it > 5 }
        subject.onComplete()
        disposables.dispose()
    }

    /**
     * Skip is used if we want to skip all the elements from first to a value. Skip 1 will skip "Hello"
     */
    fun skip(){
        println("Skip:")
        val disposables = CompositeDisposable()
        val subject = PublishSubject.create<String> { emitter ->
            emitter.onNext("Hello")
            emitter.onNext("how")
            emitter.onNext("are")
            emitter.onNext("you?")
            emitter.onComplete()
        }.skip(1)
        val disposable = subject.subscribe{ println(it)}
        disposables.add(disposable)
        disposables.dispose()
    }
    fun skipWhile(){
        println("SkipWhile:")
        val disposables = CompositeDisposable()
        val subject = PublishSubject.create<Int> { emitter ->
            emitter.onNext(1)
            emitter.onNext(2)
            emitter.onNext(3)
            emitter.onNext(4)
            emitter.onComplete()
        }.skipWhile { it % 3 !=0 } //****While condition is not met skip items
        val disposable = subject.subscribe{ println(it)}
        disposables.add(disposable)
        disposables.dispose()
    }
    fun skipUntil(){
        
    }
}