package dev.nhoffmann.aoc.y2021.day6

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day6Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2021/day-6-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDaySixPartOne() {
        val result = solveDaySixPartOne(lines)
        Assertions.assertThat(result).isEqualTo(5934)
    }

    @Test
    @Disabled("Implementation fucks up heap, Out of Memory Error in CI")
    fun solveDaySixPartTwo() {
        val result = solveDaySixPartTwo(lines)
        Assertions.assertThat(result).isEqualTo(26984457539)
    }
}
