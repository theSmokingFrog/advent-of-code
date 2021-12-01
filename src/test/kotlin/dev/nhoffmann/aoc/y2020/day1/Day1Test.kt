package dev.nhoffmann.aoc.y2020.day1

import dev.nhoffmann.aoc.loadInt
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {
    companion object {
        const val DAY1_TEST_DATA_FILE = "/inputs/2020/day-1-test.txt"
    }

    @Test
    fun `Part One Example is correctly calculated`() {
        val solvedNumber = solveDayOnePartOne(loadInt(DAY1_TEST_DATA_FILE))
        assertEquals(514579, solvedNumber)
    }

    @Test
    fun `Part Two Example is correctly calculated`() {
        val solvedNumber = solveDayOnePartTwo(loadInt(DAY1_TEST_DATA_FILE))
        assertEquals(241861950, solvedNumber)
    }
}
