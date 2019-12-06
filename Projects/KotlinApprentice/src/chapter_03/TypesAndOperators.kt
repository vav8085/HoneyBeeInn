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
    //ToDo pairs and triples can be used to save 2 or 3 values of data, for more than 3 values use kotlin data classes

    //ToDO Pairs
    //ToDO pairs and triples once created cannot be changed. THe values in them remain the same. If you want to change them
    //ToDo then you can extract the value and change it and then save it in a new triple or pair
    val coordinates: Pair<Int, Int> = Pair(2,3)
    val coordinates1 = Pair(2,3)
    val coordinates2 = 2 to 3
    val coordinates3 = 2 to null
    //fetching pair values
    val x = coordinates.first
    val y = coordinates.second

    //ToDO Triples
    val coordinates3D = Triple(2,3,4)
    val x1 = coordinates3D.first
    val x2 = coordinates3D.second
    val x3 = coordinates3D.third
}

fun anyUnitNothing(){
    //ToDO all the types in kotlin except nullables extend Any, ***notice what Control Shift + P returns for these
    val a: Any = 20 //its an int
    val b: Any = 20.23 //its a double here
    unitFunction()
}

fun unitFunction(): Unit {
    println("A function that returns nothing has return type unit just like void in java")
}

/**
 * This function never returns
 */
fun nothingFunction(): Nothing{
    while (true){

    }
}
