package Chapter_10

fun main(){
    lambdas()
}
fun lambdas(){
    mainFunction()
    mainFunctionX()
}
// to create a lambda you follow 3 steps
//1. signature
val lambdaFunction: (Int) -> Int = {a -> a+1}
//  name                signature   value
//you can pass this to any function with above signature
fun incrementNumber(number: Int, incrementer: (Int) -> (Int)){
    incrementer.invoke(number)
}
//you can use this function anywhere you like
fun mainFunction(){
    incrementNumber(2, lambdaFunction)
    incrementNumber(2, ::incrementFunction)
    //doing same thing by passing lambda inline
    incrementNumber(2){a:Int -> a+1} // lambda can be moved out of function as this is final argument to incrementNumber
}

//Now suppose we had a function that increments and has the same signature (Int) -> (Int), it can also be passed to incrementNumber
fun incrementFunction(a: Int): Int{
    return a + 1
}

//You can also define a lambda inline

/*----------------------------------------------------*/


// lets do the same using an anonymous object
// First create an interface of type incrementer
interface Incrementer{
    fun increment(number: Int): Int

}
// Add incrementerFunction that takes an integer and above interface
fun incrementNumber(number: Int, incrementer: Incrementer){
    incrementer.increment(number)
}
//Using above incrementer
fun mainFunctionX(){
    incrementNumber(5,object: Incrementer{
        override fun increment(number: Int): Int {
            var incremented = number
            return incremented++
        }
    } )

    // you can see that incrementNumber is overridden, in both cases it accepts an integer but at one place it accepts a lambda while at other
    //place it accepts an anonymous object
}