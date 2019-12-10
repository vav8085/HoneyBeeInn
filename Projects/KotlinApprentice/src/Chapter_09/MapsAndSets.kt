package Chapter_09

fun main(){
    maps()
}

/**
 * in kotlin maps are unordered collection of Pairs. notice that a Pair is comparized of a key and a value
 *
 * Keys are unique
 *
 * all keys should be of same type
 *
 * all values should be of same type
 *
 */
fun maps(){

}
fun creatingMaps(){
    // yoiu can create a map using mapof method
    var yearOfBirth = mapOf("Anna" to 1984,"James" to 1990, "Tony" to 1992)
    // to create a mutable map you can use mutableMapOf
    var yearOfBirthMutable = mutableMapOf("Anna" to 1984,"James" to 1990, "Tony" to 1992)
    //you can create an empty map using above methods
}

