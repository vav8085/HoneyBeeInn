/* i522074 created on 2020-03-04*/
package com.vav.kotlincoroutines.chapter_03

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Content_01_GettingStarted {

    /**
     * As you can see here we are launching a Couroutine using GlobalScope.launch
     * THe body of the Coroutine is actually passed as a parameter to the launch function.
     *
     * Actually launch has 3 parameters
     * 1. Coroutine context - this is the contextual information about the coroutine. This may contain Job and Dispatcher information.
     * 2. Coroutine start - the mode in which coroutine will start Default, Lazy, Atomic, Undispatched
     * 3. a lambda function
     *
     * CoroutineScope is created to avoid running of couroutine when application is stopped. Each scope is related to a context.
     * if the lifecycle of a scope ends then all the work of a coroutine will be stopped.
     * ** in examples we use thread.sleep to keep application running until coroutine is running. This is equivalent to an application which called
     * a coroutine and simulates the same behavior.
     *
     * To create your own scope you can implement CoroutineScope interface.
     *
     * Whatever you pass inside the launch() function is called a Job
     *
     * Launch does not immediately start a Job but queues it. It returns a Job instance which is a handle to the work.
     *
     * Work is actually started by system.
     *
     * You can Join two jobs and create relationships between them.
     */
    fun startingCoroutines(){
        GlobalScope.launch(block = {
            println("This is a Coroutine!")
        })
    }

    fun joiningCoroutines(){
        val job1 = GlobalScope.launch(start = CoroutineStart.LAZY, block = {
            delay(200)
            println("pong")
            delay(200)
        })
        GlobalScope.launch {
            delay(200)
            println("ping")
            job1.join() //job 1 will start here because its started lazily
            println("ping")
            delay(200)
        }
        Thread.sleep(1000)
    }

    fun parentChildJobRelationship(){
        with(GlobalScope){
            val parent = launch {
                delay(200)
                println(" I m the parent")
                delay(200)
            }
            launch (context = parent){
                delay(200)
                println("I am child")
                delay(200)
            }
            if (parent.children.iterator().hasNext()) {
            println("The Job has children ${parent.children}")
        } else {
            println("The Job has NO children")
        }
            Thread.sleep(1000)
        }
    }
    fun repeatAndRetry(){
        var isDoorOpen = false

        println("Unlocking the door... please wait.\n")
        GlobalScope.launch {
            delay(3000)

            isDoorOpen = true
        }

        GlobalScope.launch {
            repeat(4) {
                println("Trying to open the door...\n")
                delay(800)

                if (isDoorOpen) {
                    println("Opened the door!\n")
                } else {
                    println("The door is still locked\n")
                }
            }
        }

        Thread.sleep(5000)
    }

    /**
     * 
     */
    fun postingToUI(){

    }
}