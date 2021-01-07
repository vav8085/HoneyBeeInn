package misc

import misc.functions.Functions

  fun main(){
      //val referenceVariableName: Type = Constructor()
      val functionsObj: Functions = Functions()
      functionsObj.sum(number1 = 5,number2 = 10)
      functionsObj.sum(6,7)
      functionsObj.sum(8,15)

      val total: Int = functionsObj.multiply(functionsObj.sum(5,6),7)
      val total2 = functionsObj.sum(5,6) + functionsObj.multiply(7,8) //11 + 56
      val total3 = functionsObj.sum(functionsObj.sum(5,6),functionsObj.multiply(7,8)) //11 + 56

      functionsObj.printMyName("vaibhav")
      functionsObj.printMyName("Varun")
      functionsObj.printMyName("Ram")
      functionsObj.printMyName()

      functionsObj.manyParamsFunction(integer = 1,double = 2.0,string = "Hello",person = Person("Ram","Sharma"),cycle = Cycle(1,1,1,1))


      val pairAddandMult: Pair<Int,Int> = functionsObj.additionAndMultiplication(5,6)
      println("sum is: ${pairAddandMult.first} and multiplication is: ${pairAddandMult.second}")

      val pair = functionsObj.returnSumName(100_000,500,"Ram" )
      println("Name: ${pair.second} and salary: ${pair.first}")

      functionsObj.printSumAndName(100_000,500,"Ram",functionsObj.returnSumName)

  }
/*

 */