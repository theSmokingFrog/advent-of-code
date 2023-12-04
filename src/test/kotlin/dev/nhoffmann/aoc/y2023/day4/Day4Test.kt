package dev.nhoffmann.aoc.y2023.day4

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day4Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2023/day-4-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay4PartOneTest() {
        val result = solveDay4PartOne(lines)
        Assertions.assertThat(result).isEqualTo(13)
    }

    @Test
    fun solveDay4PartTwoTest() {
        val result = solveDay4PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(30)
    }
}
