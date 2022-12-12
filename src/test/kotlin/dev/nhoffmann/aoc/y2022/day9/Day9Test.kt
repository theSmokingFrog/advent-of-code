package dev.nhoffmann.aoc.y2022.day9

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day9Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2022/day-9-test.txt"
        const val TEST_DATA_FILE_2 = "/inputs/2022/day-9-test-2.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay9PartOneTest() {
        val result = solveDay9PartOne(lines)
        Assertions.assertThat(result).isEqualTo(13)
    }

    @Test
    fun solveDay9PartTwoTest() {
        val result = solveDay9PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(1)
    }

    @Test
    fun solveDay9PartTwoTest2() {
        val linesTwo = load(TEST_DATA_FILE_2)
        Assertions.assertThat(linesTwo).isNotEmpty
        val result = solveDay9PartTwo(linesTwo)
        Assertions.assertThat(result).isEqualTo(36)
    }
}
