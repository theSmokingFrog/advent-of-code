package dev.nhoffmann.aoc.y2022.day3

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day3Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2022/day-3-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay3PartOneTest() {
        val result = solveDay3PartOne(lines)
        Assertions.assertThat(result).isEqualTo(157)
    }

    @Test
    fun solveDay3PartTwoTest() {
        val result = solveDay3PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(70)
    }
}
