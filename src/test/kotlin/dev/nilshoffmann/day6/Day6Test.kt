package dev.nilshoffmann.day6

import dev.nilshoffmann.load
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day6Test {
    companion object {
        const val DAY6_TEST_DATA_FILE = "/inputs/day-6-test.txt"
    }

    @Test
    fun `Part One Example is correctly calculated`() {
        val yesCount = solveDay6PartOne(load(DAY6_TEST_DATA_FILE))
        assertEquals(11, yesCount)
    }


    @Test
    fun `Part Two Example is correctly calculated`() {
        val yesCount = solveDay6PartTwo(load(DAY6_TEST_DATA_FILE))
        assertEquals(6, yesCount)
    }
}