package Chapter_10

fun main(){
    lambdas2()
    println(returnsLambda().invoke(4))
}
fun lambdas2(){
    /**
     * Lambdas are anonymous functions
     * Lambda can access, store and manipulate a value of any variable or constant in the enclosing scope
     * THe variable or constant accessed by lambda is said to be captured by lambda
     */
    var multiplyLambda: (Int, Int) -> Int //declaration
    multiplyLambda = {a: Int, b: Int -> a*b} //assignment....can also use type inference and be written as {a, b -> a*b}
    var product = multiplyLambda.invoke(5,6) //invoking
    println(product) //printing

    //named arguments do not work with lambda multiplyLambda.invoke(a=5,b=6) wont work
}

fun returnsLambda(): (Int) -> (Int){
    val a = 5
    val lambdaToReturn: (Int) -> (Int) = {c -> c * a}
    return lambdaToReturn
}