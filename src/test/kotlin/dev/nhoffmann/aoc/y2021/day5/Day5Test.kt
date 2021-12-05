package dev.nhoffmann.aoc.y2021.day5

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day5Test {

    companion object {
        const val TEST_DATA_FILE = "/inputs/2021/day-5-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDayFivePartOne() {
        val result = solveDayFivePartOne(lines)
        Assertions.assertThat(result).isEqualTo(5)
    }

    @Test
    fun solveDayFivePartTwo() {
        val result = solveDayFivePartTwo(lines)
        Assertions.assertThat(result).isEqualTo(12)
    }
}
