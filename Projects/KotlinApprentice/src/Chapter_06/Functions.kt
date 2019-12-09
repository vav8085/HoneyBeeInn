package Chapter_06

import java.util.concurrent.atomic.DoubleAdder

fun main(){
    multiplyByFive(input = 6) // named argument
    multiplyByFive()
    multiplier(number2 = 4, number1 = 5)
    println(squareOf(5))
    val (number : Int, square) = squareOf(5) //pair is returned as  val (a,b) where a and b are the pair values
    println(number)
    println(square)
    println(multiplyInferred(3,9))
    println(printFullName("vaibhav","pathak"))
    val fullName = printFullName("Vaibhav", "Pathak")
    val (firstName, lastName) = fullName("Vaibhav", "Pathak")
    println("$firstName $lastName")
    kotlinAssigningFunctionsToVar()
    //nonReturningFunctions(5,6)
    challenges()
}
fun multiplyByFive(input: Int = 4){ //Default value
    println("Multiplying $input by 5 returns ${input*5}")
}

fun multiplier(number1: Int, number2: Int): Int{
    //number1++ this wont work because function parameters are always constant
    return number1 * number2
}
fun squareOf(number: Int): Pair<Int,Int>{ //returning a pair
    return Pair(number,number*number)
}
fun multiplyInferred(a: Int, b: Int): Int = a*b //in kotlin if you have a single line function body then you can put it with =

/**
 * Overloaded functions
 * 1.   Number of params
 * 2.   Type of params
 * 3.   order of params
 */
fun overloading(a: Int, b: String){

}
fun overloading(a: String, b: Int){

}

fun miniExercise(){

}
fun printFullName(firstName: String, lastName: String): String{
    //return firstName + " " + lastName
    return "$firstName $lastName"
}
fun fullName(firstName: String, lastName: String): Pair<String, String> {
    return Pair(firstName, lastName)
}

fun kotlinAssigningFunctionsToVar(){
    //:: is method reference operator here
    var function1: (Int, Int) -> Int = ::add
    function1(2,3) //you can use the function variables just like the function itself
    println(addNumbers(5,6,::add)) //passing function to another function
}
fun add(a: Int, b: Int): Int{
 return a + b
}

fun addNumbers(a: Int, b: Int,function: (Int,Int)-> Int): Int{
    return function.invoke(a,b)
}

/**
 * A non returning function is good when we want a function to never return . these kind of functions are good when
 * we want to keep taking some inputs from user and actually never end the function, the entire thing starts with
 * some default input and just keep running forever
 * We do this by making the function return type as Nothing
 */
fun nonReturningFunctions(a: Int, b: Int): Nothing{
    while (true){
        //run an event loop or some never ending thing here
    }
}
fun challenges(){
    println(isPrime(8))
    println(fibonacci(3))
}
fun isDivisible(divisor: Int, number: Int): Int{
    return number % divisor
}
fun isPrime(number: Int): Boolean{
    if(number<=1){
        return false
    }
    for(i in 2..(number-1)){
        if(isDivisible(i,number)==0){
            return false
        }
    }
    return true
}

fun fibonacci(number: Int): Int{
    if(number <= 2){
        return 1
    }
    return (fibonacci(number-1) + fibonacci(number-2))
}

