package Chapter_09

fun main(){
    maps()
    sets()
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
    creatingMaps()
    alteringMaps()
     loopingOverMaps()
    hashCodes()
}
fun creatingMaps(){
    // yoiu can create a map using mapof method
    var yearOfBirth = mapOf("Anna" to 1984,"James" to 1990, "Tony" to 1992)
    // to create a mutable map you can use mutableMapOf
    var yearOfBirthMutable = mutableMapOf("Anna" to 1984,"James" to 1990, "Tony" to 1992)
    //you can create an empty map using above methods
    var newMap = HashMap<Int,String>()

    println(yearOfBirth.get("Anna"))
    println(yearOfBirth["James"])

    var bobData: MutableMap<String,String> = mutableMapOf("Age" to "24", Pair("Height", "5'9\""))
    bobData.put("Role","Software Engineer")
    val keys = bobData.keys
    for(key in keys){
        println("$key ${bobData.get(key)}")
    }
}

/**
 * We can add a value to existing key in the map, if key does not exist then the key will be added
 */
fun alteringMaps(){
    var bobData: MutableMap<String,String> = mutableMapOf("Age" to "24", Pair("Height", "5'9\""))
    bobData.put("Age","25")
    val keys = bobData.keys
    for(key in keys){
        println("$key ${bobData.get(key)}")
    }
}
fun loopingOverMaps(){
    var bobData: MutableMap<String,String> = mutableMapOf("Age" to "24", Pair("Height", "5'9\""))
    for((key, value) in bobData){
        println("$key $value")
    }
}
fun hashCodes(){
    //In kotlin every type has a hashcode
    val a: String = "java"
    println(a.hashCode())
}

fun sets(){

}

