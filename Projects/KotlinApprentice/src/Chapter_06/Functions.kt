package Chapter_06

fun main(){
    multiplyByFive(input = 6) // named argument
    multiplyByFive()
    multiplier(number2 = 4, number1 = 5)
    println(squareOf(5))
    val (number, square) = squareOf(5) //pair is returned as  val (a,b) where a and b are the pair values
    println(number)
}
fun multiplyByFive(input: Int = 4){ //Default value
    println("Multiplying $input by 5 returns ${input*5}")
}

fun multiplier(number1: Int, number2: Int): Int{
    return number1 * number2
}
fun squareOf(number: Int): Pair<Int,Int>{ //returning a pair
    return Pair(number,number*number)
}