package dev.nhoffmann.aoc.y2022.day8

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day8Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2022/day-8-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay8PartOneTest() {
        val result = solveDay8PartOne(lines)
        Assertions.assertThat(result).isEqualTo(21)
    }

    @Test
    fun solveDay8PartTwoTest() {
        val result = solveDay8PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(8)
    }
}
