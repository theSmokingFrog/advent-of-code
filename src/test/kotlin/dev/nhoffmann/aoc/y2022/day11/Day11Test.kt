package dev.nhoffmann.aoc.y2022.day11

import dev.nhoffmann.aoc.loadAsSingle
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day11Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2022/day-11-test.txt"
    }

    private lateinit var lines: String

    @BeforeEach
    internal fun setUp() {
        lines = loadAsSingle(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay11PartOneTest() {
        val result = solveDay11PartOne(lines)
        Assertions.assertThat(result).isEqualTo(10_605L)
    }

    @Test
    fun solveDay11PartTwoTest() {
        val result = solveDay11PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(2_713_310_158L)
    }
}
