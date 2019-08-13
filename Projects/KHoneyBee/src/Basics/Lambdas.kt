package Basics

fun main(args: Array<String>) {
    { x: Int -> x*2}  //A lambda function in Kotlin

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

}
