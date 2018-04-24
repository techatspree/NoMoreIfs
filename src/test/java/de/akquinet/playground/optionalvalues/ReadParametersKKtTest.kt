package de.akquinet.playground.optionalvalues

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ReadParametersKKtTest {

    @Test
    fun readFloatParamOnEmptyMap() {
        val emptyMap = mapOf<String, Set<String>>()

        assertEquals(null,
                readFloatParamK("key", emptyMap))
    }

    @Test
    fun readFloatParamOnOneCorrectValue() {
        val key = "key"
        val emptyMap = mapOf(key to setOf("3.14"))

        assertEquals( 3.14f,
                readFloatParamK("key", emptyMap))
    }

    @Test
    fun readFloatParamOnOneIncorrectValue() {
        val key = "key"
        val emptyMap = mapOf(key to setOf("abc"))

        assertEquals( null,
                readFloatParamK("key", emptyMap))
    }

    @Test
    fun readFloatParamOnTwoValues() {
        val key = "key"
        val emptyMap = mapOf(key to setOf("3.14", "4.23"))

        assertEquals( null,
                readFloatParamK("key", emptyMap))
    }

    @Test
    fun readFloatParamOnNoValues() {
        val key = "key"
        val emptyMap = mapOf(key to setOf<String>())

        assertEquals( null,
                readFloatParamK("key", emptyMap))
    }

}