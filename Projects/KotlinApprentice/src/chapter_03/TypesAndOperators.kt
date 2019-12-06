package chapter_03

fun main(){
    primitives()
    multilineStrings()
}
fun primitives(){
    val age = 32 //inferred type you can do Control + Shift + P to see the type of this constant
    val isDouble = 3.toDouble()
    val isAlsoDouble: Double = 3.0
    println("isdouble = $isDouble and isAlsoDouble = $isAlsoDouble")
    miniexercisePrimitives()
}
fun miniexercisePrimitives(){
    val age1 = 42
    val age2 = 21

    val avg1 = (age1 + age2)/2 //Control shift P shows avg1 is of type Int
    val avg2 = (age1.toDouble() + age2.toDouble())/2 //Control shift P shows avg2 is of type Double

    val character: Char = 'd'

    val string: String = "Hello"
}
fun multilineStrings(){
    val string: String = """
        Hello
        my 
        name
        is
        kotlin
    """.trimIndent()
    println(string)

    val firstName: String = "Kotlin"
    val lastName: String = "programming"
    val fullName = firstName +" "+ lastName
    println(fullName)
    val myDetails = "Hello, My name is $fullName"
    println(myDetails)
}
fun pairsAndTriples(){
    
}