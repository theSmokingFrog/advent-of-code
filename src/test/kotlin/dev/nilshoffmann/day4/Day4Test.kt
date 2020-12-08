package dev.nilshoffmann.day4

import dev.nilshoffmann.load
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day4Test {
    companion object {
        const val DAY4_TEST_DATA_FILE = "/inputs/day-4-test.txt"
    }

    @Test
    fun `Part One Example is correctly calculated`() {
        val validPassports = solveDay4PartOne(load(DAY4_TEST_DATA_FILE))
        assertEquals(2, validPassports)
    }
}