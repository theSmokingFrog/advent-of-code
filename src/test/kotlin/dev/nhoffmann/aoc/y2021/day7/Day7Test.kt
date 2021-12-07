package dev.nhoffmann.aoc.y2021.day7

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day7Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2021/day-7-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDaySevenPartOneTest() {
        val result = solveDaySevenPartOne(lines)
        Assertions.assertThat(result).isEqualTo(37)
    }

    @Test
    fun solveDaySevenPartTwoTest() {
        val result = solveDaySevenPartTwo(lines)
        Assertions.assertThat(result).isEqualTo(168)
    }

    @Test
    fun calculateFuelCostGaussTest() {
        val result = calculateFuelCostGauss(lines.first().split(',').map { it.toInt() }, 2)
        Assertions.assertThat(result).isEqualTo(206)
    }
}
