package dev.nhoffmann.aoc.y2022.day5

import dev.nhoffmann.aoc.loadAsSingle
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day5Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2022/day-5-test.txt"
    }

    private lateinit var input: String

    @BeforeEach
    internal fun setUp() {
        input = loadAsSingle(TEST_DATA_FILE)
        Assertions.assertThat(input).isNotEmpty
    }

    @Test
    fun solveDay5PartOneTest() {
        val result = solveDay5PartOne(input)
        Assertions.assertThat(result).isEqualTo("CMZ")
    }

    @Test
    fun solveDay5PartTwoTest() {
        val result = solveDay5PartTwo(input)
        Assertions.assertThat(result).isEqualTo("MCD")
    }
}
