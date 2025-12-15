package dev.nhoffmann.aoc.y2025.day2

import dev.nhoffmann.aoc.loadAsSingle
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day2Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2025/day-2-test.txt"
    }

    private lateinit var lines: String

    @BeforeEach
    internal fun setUp() {
        lines = loadAsSingle(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay1PartOneTest() {
        val result = solveDay2PartOne(lines)
        Assertions.assertThat(result).isEqualTo(1227775554)
    }

    @Test
    fun solveDay1PartTwoTest() {
        val result = solveDay2PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(6)
    }
}