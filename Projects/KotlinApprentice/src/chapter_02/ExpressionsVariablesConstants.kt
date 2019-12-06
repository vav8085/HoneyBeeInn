package chapter_02

const val z = 24 //a constant declared outside any method, must be initialized with a primitive or a string

fun main(){
 arithmaticOperators()
    println(z)
    variableNames()
    miniExercise()
}
fun arithmaticOperators(){
    //TODO Left and right shift in kotlin
    var a = 1 shl 3 //multiplying 1 by 2 thrice
    println(a)
    var b = 30 shr 2 //dividing 30 by 2 twice
    println(b)
}
fun variableNames(){
    var a = 1_000_000 // You can use underscores in kotlin numbers to make them more readable
    a+=1
    a-=1
    a*=2
    a/=2
    println(a)
}
fun miniExercise(){
    val myAge: Int = 32
    var averageAge = 32
    averageAge = (32 + 30)/2
    println(averageAge)
    val testNumber = 5
    val evenOdd = 5%2
    println(evenOdd)
}