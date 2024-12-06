package dev.nhoffmann.aoc.y2024.day5

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day5Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2024/day-5-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay5PartOneTest() {
        val result = solveDay5PartOne(lines)
        Assertions.assertThat(result).isEqualTo(143)
    }

    @Test
    fun solveDay5PartTwoTest() {
        val result = solveDay5PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(123)
    }
}