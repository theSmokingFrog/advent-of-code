package dev.nhoffmann.aoc.y2020.day2

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Verify Day 2 Solutions")
class Day2Test {
    companion object {
        const val DAY2_TEST_DATA_FILE = "/inputs/2020/day-2-test.txt"
    }

    @Test
    fun `Part One Example is correctly calculated`() {
        val validPasswords = solveDayTwoPartOne(loadPasswords(DAY2_TEST_DATA_FILE))
        assertEquals(2, validPasswords)
    }

    @Test
    fun `Part Two Example is correctly calculated`() {
        val validPasswords = solveDayTwoPartTwo(loadPasswords(DAY2_TEST_DATA_FILE))
        assertEquals(1, validPasswords)
    }
}
