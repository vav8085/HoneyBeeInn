package Basics

fun main(args: Array<String>) {
    fun LambdasBasics(){
        { x: Int -> x*2}  //A lambda function in Kotlin
        // Declaration      Definition
        val timesTwo: (Int) -> (Int) = { x -> x*2}  //A variable of type function
        val times2 = { x:Int -> x*2}  //Can also be written as, but in this case we have to specify the type of x
        val timesTo: (Int) -> (Int) = {it*2}  //Can also be written using it if there is only one input
        val add: (Int,Int) -> (Int) = {x: Int, y: Int -> x*y}

        /**If you see a lambda expression you can understand that its similar to an object of type of a functional Interface
         * So suppose your functional Interface is:
         * public class LambdaTest implements Runnable{
        public void run() {
        System.out.println("thread running");
        }
        public static void main( String[] args ){
        Thread t = new Thread(new LambdaTest());
        t.start();
        }
        }
        Any Object of LambdaTest will be of type Runnable
        To use it you will do :
        Thread t = new Thread(new LambdaTest());
        t.start();
         *
         * If you convert this to a java lambda it will look like
         *  Runnable run = () -> {
        System.out.println("Thread");
        };
         *
         * the run object here is simply an object of functional Interface Runnable
         * When this object is passed to a Thread then it simply calls the run method of this lambda
         *
         *  Thread t = new Thread(run);
        t.start();

        similarly timesTwo, times2 and add are also objects of a functional interface which we cannot see here.
        But seeing the functional interface is not important because we only cared about the input and output types
        of its method which a lambda can easily express.
         */

        /**
         * Why use Lambdas ->
         * After reading above we can understand that we do not need to worry about the name of this function. We just need to
         * worry about the input and the output of a Lambda. This is the best thing about lambda functions. You can pass them to
         * any client method to complete a piece of work and return a response. But the question is why to pass a Lambda expression?
         * The answer is simple, You do not want client to be independent on which work to do, you just pass the function that
         * can complete the set of work.
         *
         * This is just like giving a machine some input and also what to do on that input. Just like a 3D printer. YOu give it material
         * and the blueprint of the object it need to create and it creates it. Nothing hardcoded there.
         *
         * Similarly you can return a lambda from a function. With different inputs the client method should be able to return different functions
         *
         */

    }

    fun higherOrderFunctions(){
        /**
         * Higher order functions are the functions that take a function and can also return a function.
         *
         * An example of higher order functions is filter() function
         */

        val list = (1..100).toList() //creating a list
        list.filter { element: Int -> element % 2 ==0 } // we are passing a lambda that identify if the element is even
                                                        // the filter function simply iterates over each input and verifies it using this lambda
                                                        // thus filter is a higher order function

        //Using 'it' this can be written as
        list.filter {it -> it % 2 ==0}
        //much simplified
        list.filter {it % 2 ==0}
    }
}
