package Basics

fun main(args: Array<String>) {
    maps()
    takeAndDrop()
    println()
    println()
    zipFunction()
    chaining()
    lazySequences()
    letOperator()
    withOperator()
    useOperator()
}

fun maps(){
    val list = (1..100).toList()
    val doubled = list.map { it*2 } //Applies the lambda to input list items and returns the result
    println(doubled)
    println()
    println()
    /**
     * Maps vs flatmaps
     */
    val nestedLists = listOf(
            (1..10).toList()
            ,(11..20).toList()
            ,(21..30).toList())

    val notFLatened = nestedLists.map { it.sortedDescending() }
    val flatened = nestedLists.flatMap { it.sortedDescending() } //flat the map. Can be also done by         val notFLatened = nestedLists.map { it.sortedDescending() }.flatten()

    println(notFLatened)
    println(flatened)
}

fun takeAndDrop() {
    // take items from a list, drop items from a list
}
fun zipFunction(){      // combines two lists and returns a List<Pair<T, R>>
    val list = listOf("Hello","there","this","is","kotlin")
    val containsT = listOf(false,true,true,false,true)

    val zipped = list.zip(containsT)
    println(zipped)

    val zippedLogically = list.zip(list.map { it.contains('t') })
    println(zippedLogically)
}
fun chaining() {
        //chain various standard functions like a fluent interface
}
fun lazySequences(){
        // improves performance of chaining
}
fun letOperator(){
    //Used for scoping
    //Used also for working with nullables
    var a: Int? = 45
    val b = 40
    a?.let { it: Int ->
        a = it.plus(b)
    }
}
fun withOperator() {
    // used with we do not want to repeat using a variable, the functions of the variable just like its available in entire scope
    // so if you are calling multiple SharedPreferences.editor(). ... then you can simply do with(SharedPreferences.editor()){//do something }
}
fun useOperator(){
    //can be called on a closable ie the classes that implement the closable interface
    //the function automatically calls close method which is handy for any operations which need closing
}

