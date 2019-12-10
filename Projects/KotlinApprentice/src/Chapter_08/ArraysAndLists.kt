package Chapter_08

import kotlin.math.min

fun main(){
    creatingArrays()
    creatingLists()
    creatingMutableLists()
    slicing()
    findingElementInList()
    addingRemovingElements()
    listIteration()
}

/**
 * Kotlin arrays are just like java arrays
 */
fun creatingArrays(){
    //you can create an array in kotlin using the standard function arrayOf
    val evenNumbers= arrayOf(2,4,6,8) //doing control shift P here will show the type as Array<Int>
    val arrayOfMultipleOfTen = Array<Int>(5,{i -> i * 10}) //the lambda is calculated for each value of array, i is the index here
    println(arrayOfMultipleOfTen.joinToString())
    val arrayx = Array<Int>(5,{it}) //the lambda is calculated for each value of array, i is the index here
    println("arrayx ${arrayx.joinToString()}")
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

fun creatingLists(){
    //kotlin lists are just like java lists. the method listOf is used to create a list in kotlin and returns the same
    //java List object. To create an array list you can use method arrayListOf
    //the lists created using these methods are immutable
    //you can also create an empty list by passing no arguments to listOf method

    val listOfIntegers = listOf<Int>(2,6,7,3,4)
    val subscribers = listOf<Int>() //empty list. immutable empty lists do not have much use
}
fun creatingMutableLists(){
    val outerPlanets = mutableListOf<String>("Jupiter","Saturn", "Uranus", "Neptune")
    val exoPlanets = mutableListOf<String>()
    //lists also have isEmpty method just like in java

    //lists have the first and last methods to print the first and last values in teh list
    val firstOuterPlanet = outerPlanets.first()
    println(firstOuterPlanet)
    val lastOuterPlanet = outerPlanets.last()
    println(lastOuterPlanet)

    //lists also have min and max methods that return the minimum and maximum values in the list
    val minPlanet = outerPlanets.min()
    println(minPlanet) // returns jupiter because j< n or u or s

    //you can get an element at an index from list or arrays by using name[x] or .get(x) methods
    val firstPlanet = outerPlanets[0]
    val firstPlanetAgain = outerPlanets.get(0)
}
fun slicing(){
    //TO get some of the values from the list you can also slice them

    val listOfCars = listOf<String>("Subaru","Mazda","Mercedes","Kia","Honda","Toyota")
    val last4Cars = listOfCars.slice(2..5) //returns a list
    println(last4Cars.joinToString())

}
fun findingElementInList(){
    //you can use the in operator to find if a certain element exist in the list
    val listOfCars = listOf<String>("Subaru","Mazda","Mercedes","Kia","Honda","Toyota")
    if("Mazda" in listOfCars){
        println("Mazda exists!")
    }
    //you can also use contains() method just like in java
    if(listOfCars.contains("Tesla")){
        println("Tesla exists!")
    }
}
fun addingRemovingElements(){
    val listOfCars = mutableListOf<String>("Subaru","Mazda","Mercedes","Kia","Honda","Toyota")
    // you can add an element using add method of the list
    listOfCars.add("Ferrari")
    //you can also add an item at a certain position in the list
    listOfCars.add(4,"Aston Martin") //notice that list starts from 0
    println(listOfCars.joinToString())
    //you can use remove or removeAAt methods to remove items from a list
    listOfCars.remove("Honda")
    listOfCars.removeAt(4)
    println(listOfCars.joinToString())
    //to update an element you can either remove than add but thats slow so you can use indexing to replace
    listOfCars.set(4,"Tata")
    println(listOfCars.joinToString())
}
fun listIteration(){
    val listOfCars = mutableListOf<String>("Subaru","Mazda","Mercedes","Kia","Honda","Toyota")
    for(car in listOfCars){
        println(car)
    }
    listOfCars.forEach { println(it) }
    println()
    for(car in 1..listOfCars.size-1){
        println(listOfCars[car])
    }
}
fun nullableAndList(){
    //Sometimes a list can be nullable and sometimes the elements inside it can be
    //You have to be careful when defining list or its elements nullable
    val listOfCars: List<String>? = null //A nullable list
    val listOfCars2: List<String?> = mutableListOf("Kia",null,"Toyota") //list of cars with null values

}
