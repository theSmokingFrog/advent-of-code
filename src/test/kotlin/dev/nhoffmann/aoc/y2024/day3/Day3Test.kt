package dev.nhoffmann.aoc.y2024.day3

import dev.nhoffmann.aoc.loadAsSingle
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day3Test {
    companion object {
        const val TEST_DATA_FILE_PT_1 = "/inputs/2024/day-3-test.txt"
        const val TEST_DATA_FILE_PT_2 = "/inputs/2024/day-3-test-2.txt"
    }

    private fun loadFile(filePath: String): String {
        val lines = loadAsSingle(filePath)
        Assertions.assertThat(lines).isNotEmpty
        return lines
    }

    @Test
    fun solveDay3PartOneTest() {
        val result = solveDay3PartOne(loadFile(TEST_DATA_FILE_PT_1))
        Assertions.assertThat(result).isEqualTo(161L)
    }

    @Test
    fun solveDay3PartTwoTest() {
        val result = solveDay3PartTwo(loadFile(TEST_DATA_FILE_PT_2))
        Assertions.assertThat(result).isEqualTo(48L)
    }
}
