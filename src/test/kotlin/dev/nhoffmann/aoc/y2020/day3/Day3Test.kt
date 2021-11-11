package dev.nhoffmann.aoc.y2020.day3

import dev.nhoffmann.aoc.load
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day3Test {
    companion object {
        const val DAY3_TEST_DATA_FILE = "/2020/inputs/day-3-test.txt"
    }

    @Test
    fun `Part One Example is correctly calculated`() {
        val treeCount = solveDay3PartOne(load(DAY3_TEST_DATA_FILE))
        assertEquals(7, treeCount)
    }

    @Test
    fun `Part Two Example is correctly calculated`() {
        val treeCount = solveDay3PartTwo(load(DAY3_TEST_DATA_FILE))
        assertEquals(336, treeCount)
    }
}
