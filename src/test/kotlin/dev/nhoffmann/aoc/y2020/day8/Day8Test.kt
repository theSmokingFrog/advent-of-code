package dev.nhoffmann.aoc.y2020.day8

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day8Test {
    companion object {
        const val DAY8_TEST_DATA_FILE = "/2020/inputs/day-8-test.txt"
    }

    @Test
    fun `Part One Example is correctly calculated`() {
        val accumulatorValue = solveDay8PartOne(load(DAY8_TEST_DATA_FILE))
        assertThat(accumulatorValue).isEqualTo(5)
    }

    @Test
    fun `Part Two Example is correctly calculated`() {
        val accumulatorValue = solveDay8PartTwo(load(DAY8_TEST_DATA_FILE))
        assertThat(accumulatorValue).isEqualTo(8)
    }
}
