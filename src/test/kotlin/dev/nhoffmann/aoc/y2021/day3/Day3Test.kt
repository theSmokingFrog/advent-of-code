package dev.nhoffmann.aoc.y2021.day3

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class Day3Test {

    companion object {
        const val TEST_DATA_FILE = "/inputs/2021/day-3-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDayThreePartOne() {
        val result = solveDayThreePartOne(lines)
        Assertions.assertThat(result).isEqualTo(198)
    }

    @Test
    fun solveDayThreePartTwo() {
        val result = solveDayThreePartTwo(lines)
        Assertions.assertThat(result).isEqualTo(230)
    }
}
