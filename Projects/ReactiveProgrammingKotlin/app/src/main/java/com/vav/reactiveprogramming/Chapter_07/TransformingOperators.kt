package com.vav.reactiveprogramming.Chapter_07

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import java.lang.RuntimeException

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
        val mazdaObservable = mazda.hide().sorted()
        val audi = BehaviorSubject.createDefault("Audi TT")
        val audiObservable = audi.hide()
        val honda = BehaviorSubject.createDefault("City")
        val hondaObservable = honda.hide()
        val cars = PublishSubject.create<Observable<String>>()
        val carsObservable: Observable<String> = cars.flatMap{it} //flatmap returns an observable of type int, notice that
        // flatMap accepts a function. You can filter, skip or do anything inside this function which will be applied to each observable
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

    /**
     * Switchmap is used when we want to switch between two or more streams and flatten their results.
     * Whenever a new stream is added the older ones new next events are ignored.
     */
    fun switchMap(){
        println("SwitchMap:")
        val disposables = CompositeDisposable()
        val mazda = BehaviorSubject.createDefault("Mazda 6")
        val audi = BehaviorSubject.createDefault("Audi TT")
        val honda = BehaviorSubject.createDefault("City")
        val cars = PublishSubject.create<BehaviorSubject<String>>()
        val carsObservable: Observable<String> = cars.switchMap{it} //flatmap returns an observable of type int
        val carsDisposable = carsObservable.subscribe{ println(it)}
        cars.onNext(mazda)
        mazda.onNext("Mazda 3")
        cars.onNext(audi)
        mazda.onNext("Mazda Miata") //will be skipped as audi has joined
        audi.onNext("A8")
        cars.onNext(honda)
        audi.onNext("R8") //will be skipped as honda has joined
        honda.onNext("Civic")
        disposables.add(carsDisposable)
        disposables.dispose()
    }
    fun materialize(){
        println("Materialize/ Dematerialize:")
        val disposables = CompositeDisposable()
        val student1 = BehaviorSubject.createDefault(70)
        val student2 = BehaviorSubject.createDefault(80)
        val student3 = BehaviorSubject.createDefault(90)
        val students = PublishSubject.create<BehaviorSubject<Int>>()
        val studentsObservable = students.flatMap { it.materialize() }
            .filter { if(it.error!=null){
                println(it.error)
                false
        }else true
        }.dematerialize<Int>() //so if there is an error on one stream then we have to handle it. But with materialize
                                // we can convert it to a notification. But notification will need dematerialize so we filter the
                                // materialized event and do not return the error values.
        val studentsDisposable = studentsObservable.subscribe { println(it) } //THis wont print actual value but Notifications like: OnNextNotification[72]
        students.onNext(student1)
        students.onNext(student2)
        students.onNext(student3)
        student1.onNext(71)
        student1.onNext(72)
        student2.onNext(80)
        student2.onNext(81)
        student2.onError(RuntimeException("Error!"))
        student3.onNext(91)
        student3.onNext(92)
        disposables.add(studentsDisposable)
        disposables.dispose()
    }
}