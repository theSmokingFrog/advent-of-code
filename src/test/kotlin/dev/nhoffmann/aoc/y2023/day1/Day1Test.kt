package dev.nhoffmann.aoc.y2023.day1

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day1Test {
    companion object {
        const val TEST_DATA_FILE_PT_1 = "/inputs/2023/day-1-test-1.txt"
        const val TEST_DATA_FILE_PT_2 = "/inputs/2023/day-1-test-2.txt"
    }

    internal fun loadFile(filePath: String): List<String> {
        val lines = load(filePath)
        Assertions.assertThat(lines).isNotEmpty
        return lines
    }

    @Test
    fun solveDay1PartOneTest() {
        val result = solveDay1PartOne(loadFile(TEST_DATA_FILE_PT_1))
        Assertions.assertThat(result).isEqualTo(142)
    }

    @Test
    fun solveDay1PartTwoTest() {
        val result = solveDay1PartTwo(loadFile(TEST_DATA_FILE_PT_2))
        Assertions.assertThat(result).isEqualTo(281)
    }
}
