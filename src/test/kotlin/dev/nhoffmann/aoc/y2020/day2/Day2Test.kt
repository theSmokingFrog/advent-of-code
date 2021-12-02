package dev.nhoffmann.aoc.y2020.day2

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Verify Day 2 Solutions")
class Day2Test {
    companion object {
        const val DAY2_TEST_DATA_FILE = "/inputs/2020/day-2-test.txt"
    }

    private lateinit var passwords: List<Password>

    @BeforeEach
    internal fun setUp() {
        passwords = parseRawPasswords(load(DAY2_TEST_DATA_FILE))
    }

    @Test
    fun `Part One Example is correctly calculated`() {
        val validPasswords = solveDayTwoPartOne(passwords)
        assertThat(validPasswords).isEqualTo(2)
    }

    @Test
    fun `Part Two Example is correctly calculated`() {
        val validPasswords = solveDayTwoPartTwo(passwords)
        assertThat(validPasswords).isEqualTo(1)
    }
}
