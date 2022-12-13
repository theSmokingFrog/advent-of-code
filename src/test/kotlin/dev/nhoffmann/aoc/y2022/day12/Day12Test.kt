package dev.nhoffmann.aoc.y2022.day12

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day12Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2022/day-12-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    @Disabled("Not yet started")
    fun solveDay12PartOneTest() {
        val result = solveDay12PartOne(lines)
        Assertions.assertThat(result).isEqualTo(-1)
    }

    @Test
    @Disabled("Not yet started")
    fun solveDay12PartTwoTest() {
        val result = solveDay12PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(-1)
    }
}
