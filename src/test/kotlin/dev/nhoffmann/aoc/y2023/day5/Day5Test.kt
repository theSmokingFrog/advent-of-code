package dev.nhoffmann.aoc.y2023.day5

import dev.nhoffmann.aoc.loadAsSingle
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day5Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2023/day-5-test.txt"
    }

    private lateinit var lines: String

    @BeforeEach
    internal fun setUp() {
        lines = loadAsSingle(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay5PartOneTest() {
        val result = solveDay5PartOne(lines)
        Assertions.assertThat(result).isEqualTo(35L)
    }

    @Test
    fun solveDay5PartTwoTest() {
        val result = solveDay5PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(46L)
    }
}
