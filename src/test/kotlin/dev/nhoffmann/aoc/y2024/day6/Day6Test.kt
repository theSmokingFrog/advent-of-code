package dev.nhoffmann.aoc.y2024.day6

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day6Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2024/day-6-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay6PartOneTest() {
        val result = solveDay6PartOne(lines)
        Assertions.assertThat(result).isEqualTo(41)
    }

    @Test
    fun solveDay6PartTwoTest() {
        val result = solveDay6PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(-1)
    }
}