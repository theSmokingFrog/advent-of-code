package dev.nilshoffmann.day1

import dev.nilshoffmann.loadNumbers
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {
    companion object {
        const val DAY1_TEST_DATA_FILE = "/inputs/day-1-test.txt"
    }

    @Test
    fun `Part One Example is correctly calculated`() {
        val solvedNumber = solveDayOnePartOne(loadNumbers(DAY1_TEST_DATA_FILE))
        assertEquals(514579, solvedNumber)
    }

    @Test
    fun `Part Two Example is correctly calculated`() {
        val solvedNumber = solveDayOnePartTwo(loadNumbers(DAY1_TEST_DATA_FILE))
        assertEquals(241861950, solvedNumber)
    }
}