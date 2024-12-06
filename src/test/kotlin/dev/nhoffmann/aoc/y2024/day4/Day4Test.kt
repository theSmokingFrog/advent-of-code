package dev.nhoffmann.aoc.y2024.day4

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Day4Test {

    @ParameterizedTest
    @CsvSource(
        "/inputs/2024/day-4-test-1.txt, 4",
        "/inputs/2024/day-4-test-2.txt, 18"
    )
    fun solveDay4PartOneTest(filePath: String, expectedResult: Int) {
        val lines = load(filePath)
        Assertions.assertThat(lines).isNotEmpty
        val result = solveDay4PartOne(lines, "XMAS")
        Assertions.assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    fun solveDay4PartTwoTest() {
        val lines = load("/inputs/2024/day-4-test-2.txt")
        Assertions.assertThat(lines).isNotEmpty
        val result = solveDay4PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(9)
    }
}
