package dev.nhoffmann.aoc.y2021.day9

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day9Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2021/day-9-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay9PartOneTest() {
        val result = solveDay9PartOne(lines)
        Assertions.assertThat(result).isEqualTo(15)
    }

    @Test
    fun solveDay9PartTwoTest() {
        val result = solveDay9PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(Int.MAX_VALUE)
    }
}
