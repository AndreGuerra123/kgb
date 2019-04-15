
package com.amyris.kgb

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class GreetingTest {
    @Test
    fun testHello() {
        Assertions.assertEquals("Hello, Guerra.Hello, Guerra.", Greeting("Guerra").sayHello(2))
    }
}