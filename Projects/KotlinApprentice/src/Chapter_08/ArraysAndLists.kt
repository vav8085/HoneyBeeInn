package Chapter_08

fun main(){
 creatingArrays()
}

/**
 * Kotlin arrays are just like java arrays
 */
fun creatingArrays(){
    //you can create an array in kotlin using the standard function arrayOf
    val evenNumbers= arrayOf(2,4,6,8) //doing control shift P here will show the type as Array<Int>
    val arrayOfMultipleOfTen = Array<Int>(5,{i -> i * 10}) //the lambda is calculated for each value of array, i is the index here
    println(arrayOfMultipleOfTen.joinToString())

    //THe arrayOf function returns an array of objects. in terms of java this is array of Integer type and not int type
    //To create an array of primitives you can use intArrayOf(), floatArrayOf() methods

    val primitiveIntArray = intArrayOf(2,4,6,7,9)
    val objectIntArray = arrayOf(1,2,3,4,5,6).toIntArray()// you can also convert objects to primitives using toIntArray etc methods

    for(arg in primitiveIntArray){ //A for each loop to loop over arrays in kotlin
        println(arg)
    }
    primitiveIntArray.forEach { t: Int -> println("value is ${t}") }

    for(i in 1..primitiveIntArray.size-1){
        println(primitiveIntArray.get(i))
    }
}