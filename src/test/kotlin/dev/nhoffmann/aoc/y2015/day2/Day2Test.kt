package dev.nhoffmann.aoc.y2015.day2

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day2Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2015/day-2-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay2PartOneTest() {
        val result = solveDay2PartOne(lines)
        Assertions.assertThat(result).isEqualTo(101)
    }

    @Test
    fun solveDay2PartTwoTest() {
        val result = solveDay2PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(48)
    }
}
