package dev.nhoffmann.aoc.y2022.day1

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day1Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2022/day-1-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay1PartOneTest() {
        val result = solveDay1PartOne(lines)
        Assertions.assertThat(result).isEqualTo(24000)
    }

    @Test
    fun solveDay1PartTwoTest() {
        val result = solveDay1PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(45000)
    }
}
