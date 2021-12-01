package dev.nhoffmann.aoc.y2020.day4

import dev.nhoffmann.aoc.load
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day4Test {
    companion object {
        const val DAY4_TEST_DATA_FILE = "/inputs/2020/day-4-test.txt"
        const val DAY4_2_VALID_TEST_DATA_FILE = "/inputs/2020/day-4.2-valid-test.txt"
        const val DAY4_2_INVALID_TEST_DATA_FILE = "/inputs/2020/day-4.2-invalid-test.txt"
    }

    @Test
    fun `Part One Example is correctly calculated`() {
        val validPassports = solveDay4PartOne(load(DAY4_TEST_DATA_FILE))
        assertEquals(2, validPassports)
    }

    @Test
    fun `Part Two Valid Examples are correctly calculated`() {
        val validPassports = solveDay4PartTwo(load(DAY4_2_VALID_TEST_DATA_FILE))
        assertEquals(4, validPassports)
    }

    @Test
    fun `Part Two Invalid Examples are correctly calculated`() {
        val validPassports = solveDay4PartTwo(load(DAY4_2_INVALID_TEST_DATA_FILE))
        assertEquals(0, validPassports)
    }
}
