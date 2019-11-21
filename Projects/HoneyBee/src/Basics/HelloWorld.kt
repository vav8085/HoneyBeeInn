import java.io.IOException

var age = 22
val name: String = "Peter"

val lastName: String? = null


fun main(args: Array<String>) {
//        declarationAndDefination() //RIGHT this will throw null pointer exception if a is null ..
//        println()
//        println()
//        conditionalStatements()
//        println()
//        println()
//        collections()
//        println()
//        println()
        loopingStatements()
        println()
        println()
//        functions()
//        println()
//        println()
//        namedArguments()
//        println()
//        println()
//        exceptions()
//        namedArguments()
//        println()
//        println()
//        nullSafety()
}

fun nullSafety() {
        //As we know that kotlin allows us to create variables both with types and without specifying a type
        //SO we can define
        var a: Int = 25
        //we can also define a variable
        var b = 25
        // usually all the variables that have types are not nullable
        //so if you define a variable or even try to assign a to null the compiler throws an error.
        //a = null //will not work
        //we can assign b to null though only during its first assignment, for next assignment if its assigned a null then it can be null
        //otherwise it cannot be assigned as a null because its considered a not null
        //b = null //wont work
        var c = null //works though
        c = null // works again because compiler now knows c is nullable.
        //also note that:
        //var d: Int = null // wont work because Int is not a nullable type

        //Nullable types
        //To make a type nullable just add a ? during declaration
        var e: Int? = null //works fine
        //also
        var f: String? = "Hello"
        //f = null // works fine now
        //Note that if you ever use f then you cannot use f.length
        //val length: Int?  = f.length // wont work
        //val length  = f.length // again wont work
        val length  = f?.length // works fine!
        //to call a method of a nullable type always check for null

        //Also check that if we are using a nullable inside an if statement then you dont have to put a ? against it
        //so if we
        if(f!=null){
                println(f.length) //no need to put ?
        }
}

private fun declarationAndDefination() {
        age = 24
        println(age)

        /**Declaration null check**/
        var b: Int? = null              // b was null
        //var a: Int = b                // cannot be assigned to a
        var a: Int? = b                 // a is nullable now

        /**Calling null check**/
        //println(a.compareTo(age))  WRONG , wont compile
        //println(a?.compareTo(b)) //WRONG b cannot be null
        println(a?.compareTo(b!!)) //RIGHT if a is null then a.compareTo will return null
        println(age?.compareTo(b
                ?: 24)) //RIGHT using elvis expression we can replace if there is a null with some value
        //println(a!!.compareTo(age)) //Will throw null pointer exception because a is null
}

fun conditionalStatements() {
        /**TODO     if expression   */
        val i = 17
        if(i<15 && i>2){
                print("i is very small")
        } else{
                print("i is pretty large!")
        }
        //if and when blocks are expressions in kotlin so you can assign them to a variable
        val j = 17
        val x = if(j<15 && j>2){
                println("i is very small")
                "small" //This value will be assigned to x, it can be of any type
        } else{
                println("i is pretty large!")
                "large"
        }
        println(x) //prints x which is the return value of the if expression
        //if the value is not returned from the expression, x will be assigned the value -> Unit which is equivilant to void in java

        val str: String? = "hello"
        // println(str.length) // Will not compile because str is nullable
        if(str!=null){
                println(str.length)  //Kotlin understands that this statement will execute only if str is not null so it wont give compile time error
        }
        /**TODO     when expression */
        //When are equivilant to switch statements in java
        val price = 29
        when(price){
                0 -> println("Free for Today")
                !in 1..19 -> println("Free for Today")
                in 20..29 -> println("normal price!")
                else -> println("Overpriced!")

        }
        when{
                price ==19 -> println("Fixed price!")
                price in 19..24 -> println("medium price!")
                else -> println("high price!")
        }
}

fun collections() {
        /**
        Kotlin separates collections from mutable collections.
        List will have all the methods to get the collection
        while MutableList will have the methods to change the collection
         */
        val array = arrayOf(1,2,3,4,5) // you cannot create an empty array but you can create an empty list just like in java
        println(array.joinToString()) //because arrays do not have toString method.

        val array2 = intArrayOf(1,2,3,3,5)
        val list = listOf<String>("Hi ","This ","is ","kotlin") //We can also give a type explicitly, this list is immutable
        println(list.joinToString())
        val mutableList = mutableListOf(1,2,3,3,4)      //For creating a mutable list
        mutableList[4] = 10
        val set = setOf(1,2,3,3,5) //will accept only one 3 even if we add more
        println(set.joinToString())

        val map = mapOf(Pair(1,"Hi"), "hi" to 2,Pair(3,"Hello")) //map accepts Pair varargs objects
        val mutableMap = mutableMapOf(1 to "kotlin",2 to "Android", Pair(3,"Java")) //the to operator returns a tuple of type Pair, to is an infix function
}


fun loopingStatements() {
        /**    For Loop */
        for(i in 1..10){    //The .. operator only works when its an increasing sequence
                print("$i ") //$ is used to dereference

        }
        println()
        for(i in 10 downTo 1){    //For decreasing sequence, downTo is an infix function
                print("$i ") //$ is used to dereference

        }
        println()
        for(i in 10 downTo 1 step 2){    //For decreasing sequence with step 2
                print("$i ") //$ is used to dereference

        }
        println()
        /**ToDo remember that in kotlin we can only iterate over the objects that provide an iterator*/
        for(c in "Kotlin"){
                print(" ${c}")
                print(" ${c-'A'}")  //Kotlin finds out that the data type of c is a character and it prints all characters
        }
        println()
        val languages = listOf("English", "Hindi", 1)
        for (lang in languages){
               for(c in lang.toString()){
                       print("$c ")
               }
                print("")
        }
        println()
        /** While loops */
        var i=1
        while (i<=10){
                print("$i ")
                i++
        }

}
fun functions() {
        println(addNumbers(5,4))
        println(multiplyNumbers(5,4))
}

fun addNumbers(a: Int,b: Int): Int{ // name(param: type): returnType
        return a+b
}
fun multiplyNumbers(a: Int,b: Int): Int = a*b //when there is only one statement in the function


fun namedArguments() {
        val concatenated = concat(listOf("Kotlin","Java","Scala"))
        println(concatenated)   // without param, this will take default value, if default value is not given this will give a runtime error
        println(concat(listOf("Kotlin","Java","Scala")," : "))  //with param
        println(concat(separator = ":",items = listOf("Kotlin","Java","Scala")))        //Named arguments, order does not matter here

}
fun concat(items: List<String>, separator: String = ", ") = items.joinToString(separator) //default value if separator is set here


fun exceptions() {
        val input = try {                       //Assigning the return of try catch to input
            throwsIOException()
        }catch (e: IOException){
                "${e.localizedMessage}"         //Return the string message to input variable
        }finally {
                println("finally")
        }
        println(input)                          //print the value of input
}
fun throwsIOException(): String{
        throw IOException("IOException thrown!")                //In kotlin there are no checked exceptions, so if there is a checked exception then we
                                                                // do not have to throw it
}



