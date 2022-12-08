package dev.nhoffmann.aoc.y2022.day7

import dev.nhoffmann.aoc.loadAsSingle
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day7Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2022/day-7-test.txt"
    }

    private lateinit var lines: String

    @BeforeEach
    internal fun setUp() {
        lines = loadAsSingle(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay7PartOneTest() {
        val result = solveDay7PartOne(lines)
        Assertions.assertThat(result).isEqualTo(95437)
    }

    @Test
    fun solveDay7PartTwoTest() {
        val result = solveDay7PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(24933642)
    }
}
