package com.amyris.kgb

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import com.github.ajalt.clikt.parameters.types.int


/**
 * Cli is an 'HelloWorld´ example of cli for kotlin using clikt.
 * @param(repeats) The number of greetings to be made.
 * @param(name) The name of the person to greet.
 */
class Cli : CliktCommand() {
    private val repeats: Int by option(help="Number of greetings").int().default(1)
    private val name: String by option(help="The person to greet").prompt("Your name")

    override fun run() {
        echo(Greeting(name).sayHello(repeats))
    }
}

fun main(args: Array<String>) = Cli().main(args)
