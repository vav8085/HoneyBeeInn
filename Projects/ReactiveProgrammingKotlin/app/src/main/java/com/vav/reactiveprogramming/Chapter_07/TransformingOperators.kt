package com.vav.reactiveprogramming.Chapter_07

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

object TransformingOperators {
    /**
     * Convert elements to a list, returns an observable of type list
     */
    fun toList(){
        println("To List:")
        val disposables = CompositeDisposable()
        val observable = Observable.create<Int> {
            emitter ->
            emitter.onNext(1)
            emitter.onNext(2)
            emitter.onNext(3)
            emitter.onNext(4)
            emitter.onNext(5)
            emitter.onComplete()
        }.toList()
        val disposable = observable.subscribeBy{ it.forEach { println(it) } }
        disposables.add(disposable)
        disposables.dispose()
    }

    /**
     * Map is used to perform some operation on all the events emitted. Below are examples both using subjects and observables
     */
    fun map(){
        println("Map:")
        val disposables = CompositeDisposable()
        val observable = Observable.create<Int> {
                emitter ->
            emitter.onNext(1)
            emitter.onNext(2)
            emitter.onNext(3)
            emitter.onNext(4)
            emitter.onNext(5)
            emitter.onComplete()
        }.map { it * 2 }
        val disposable = observable.subscribeBy{ println(it) }
        disposables.add(disposable)
        disposables.dispose()

        val subject = PublishSubject.create<Int>()
        val subjectObservable = subject.map { it * 5 } // you have to subscribe the observable from map operator
        val subjectDisposable = subjectObservable.subscribe { println(it) }
        subject.onNext(10)
        subject.onNext(20)
        subject.onNext(30)
        subject.onNext(40)
        subject.onComplete()
        disposables.add(subjectDisposable)
    }

    fun flatMap(){
        println("Flatmap:")
        val disposables = CompositeDisposable()
        val mazda = BehaviorSubject.createDefault("Mazda 6")
        val audi = BehaviorSubject.createDefault("Audi TT")
        val honda = BehaviorSubject.createDefault("City")
        val cars = PublishSubject.create<BehaviorSubject<String>>()
        val carsObservable: Observable<String> = cars.flatMap{it} //flatmap returns an observable of type int
        val carsDisposable = carsObservable.subscribe{ println(it)}
        cars.onNext(mazda)
        cars.onNext(audi)
        cars.onNext(honda)
        mazda.onNext("Mazda Miata")
        audi.onNext("A8")
        mazda.onNext("Mazda 3")
        disposables.add(carsDisposable)
        disposables.dispose()
    }

    /**
     * Flatmap flattens multiple observables into a single one, you can filter other observables independently or
     * do filtering all the items at last after flatmap
     */
    fun moreFlatMap(){
        println("More Flatmap:")
        val disposables = CompositeDisposable()
        val mazda = BehaviorSubject.createDefault("Mazda6")
        val mazdaObservable = mazda.hide().sorted()// ToDO not working
        val audi = BehaviorSubject.createDefault("Audi TT")
        val audiObservable = audi.hide()
        val honda = BehaviorSubject.createDefault("City")
        val hondaObservable = honda.hide()
        val cars = PublishSubject.create<Observable<String>>()
        val carsObservable: Observable<String> = cars.flatMap{it} //flatmap returns an observable of type int
        val carsDisposable = carsObservable.subscribe{ println(it)}
        cars.onNext(mazdaObservable)
        cars.onNext(audiObservable)
        cars.onNext(hondaObservable)
        mazda.onNext("MazdaMiata")
        audi.onNext("A8")
        mazda.onNext("Mazda3")
        mazda.onComplete() // If you wont call onComplete then sorting will not work
        disposables.add(carsDisposable)
        disposables.dispose()
    }
    fun switchMap(){

    }
}