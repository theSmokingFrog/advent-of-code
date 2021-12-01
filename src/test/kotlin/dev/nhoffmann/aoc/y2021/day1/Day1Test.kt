package dev.nhoffmann.aoc.y2021.day1

import dev.nhoffmann.aoc.loadInt
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {
    companion object {
        const val DAY1_TEST_DATA_FILE = "/inputs/2021/day-1-test.txt"
    }

    @Test
    fun `Part One Example is correctly calculated`() {
        val depthIncreases = solveDayOnePartOne(loadInt(DAY1_TEST_DATA_FILE))
        assertEquals(7, depthIncreases)
    }

    @Test
    fun `Part Two Example is correctly calculated`() {
        val preciseDepthIncreases = solveDayOnePartTwo(loadInt(DAY1_TEST_DATA_FILE))
        assertEquals(5, preciseDepthIncreases)
    }
}
