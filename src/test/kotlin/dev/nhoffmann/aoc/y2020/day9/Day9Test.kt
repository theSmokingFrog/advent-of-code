package dev.nhoffmann.aoc.y2020.day9

import dev.nhoffmann.aoc.loadLong
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day9Test {
    companion object {
        const val DAY9_TEST_DATA_FILE = "/2020/inputs/day-9-test.txt"
    }

    @Test
    fun `Part One Example is correctly calculated`() {
        val result = solvePartOne(loadLong(DAY9_TEST_DATA_FILE), 5)
        Assertions.assertThat(result).isEqualTo(127)
    }
}
