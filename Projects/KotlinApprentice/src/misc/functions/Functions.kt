package misc.functions

import misc.Cycle
import misc.Person

class Functions {
    //fun functionName(parameter1: Type1, parameter2: Type2....): returnType {//body which does some work }
    fun sum(number1: Int, number2: Int = 10): Int{
        println(number1 + number2)
        return number1 + number2
    }
    fun multiply(a: Int, b: Int): Int = a * b

    fun additionAndMultiplication(a: Int, b:Int): Pair<Int,Int>{
        val sum = a + b
        val multiplication = a * b
        return Pair(sum,multiplication)

    }
    fun printMyName(name: String = "-"){
        println("My name is $name")
    }

    fun manyParamsFunction(integer: Int, string: String, double: Double, cycle: Cycle, person: Person){
        //anything

    }

    fun returnPairOfSumAndName(baseSalary: Int, bonus: Int, name: String): Pair<Int, String> {
        return Pair(bonus + baseSalary, name)
    }

    var returnSumName:(Int,Int,String) -> Pair<Int,String> = ::returnPairOfSumAndName

    fun printSumAndName(a: Int, b: Int, name: String, returnPairOfSumAndName: (Int,Int,String) -> Pair<Int,String>){
        println("name is: ${returnPairOfSumAndName(a,b,name).second} and salary is:${returnPairOfSumAndName(a,b,name).first} " )
    }

    fun addition(a: Int, b: Int): Int{
        return a + b
    }
    fun addition(a: Int, b: Int, c: Int): Int{
        return a + b + c
    }
    fun addition(a: String, b: String): String{
        return a + b
    }

    // when NUMBER of arguments are different
    //when TYPE of argumants are different
}
