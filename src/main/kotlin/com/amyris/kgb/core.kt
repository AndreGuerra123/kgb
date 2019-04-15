package com.amyris.kgb

/**
 * Greeting is a class for greeting someone.
 * @constructor
 */
class Greeting(val name: String){

    /**
    * 'sayHello' is a function to greet someone with an "Hello".
     *@param repeats The number of time to repeat the Hello greeting.
    */
    fun sayHello(repeats: Int):String{
           return "Hello, $name.".repeat(repeats)
    }
}