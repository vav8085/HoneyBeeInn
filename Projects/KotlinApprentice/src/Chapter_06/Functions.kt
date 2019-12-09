package Chapter_06

fun main(){
    multiplyByFive(input = 6) // named argument
    multiplyByFive()
    multiplier(number2 = 4, number1 = 5)
    println(squareOf(5))
    val (number : Int, square) = squareOf(5) //pair is returned as  val (a,b) where a and b are the pair values
    println(number)
    println(square)
    println(multiplyInferred(3,9))
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

