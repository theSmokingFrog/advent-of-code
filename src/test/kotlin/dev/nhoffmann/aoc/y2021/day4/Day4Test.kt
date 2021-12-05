package dev.nhoffmann.aoc.y2021.day4

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class Day4Test {

    companion object {
        const val TEST_DATA_FILE = "/inputs/2021/day-4-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDayFourPartOneTest() {
        val result = solveDay4PartOne(lines)
        Assertions.assertThat(result).isEqualTo(4512)
    }

    @Test
    fun solveDayFourPartTwoTest() {
        val result = solveDay4PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(1924)
    }
}

