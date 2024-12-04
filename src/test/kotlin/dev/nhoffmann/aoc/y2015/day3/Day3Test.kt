package dev.nhoffmann.aoc.y2015.day3

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day3Test {
    companion object {
        @JvmStatic
        fun partOneTestDataSets(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(">", 2),
                Arguments.of("^>v<", 4),
                Arguments.of("^v^v^v^v^v", 2),
            )
        }

        @JvmStatic
        fun partTwoTestDataSets(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("^v", 3),
                Arguments.of("^>v<", 3),
                Arguments.of("^v^v^v^v^v", 11)
            )
        }
    }


    @ParameterizedTest
    @MethodSource("partOneTestDataSets")
    fun solveDay3PartOneTest(value: String, expectedResult: Long) {
        val result = solveDay3PartOne(value)
        Assertions.assertThat(result).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("partTwoTestDataSets")
    fun solveDay3PartTwoTest(value: String, expectedResult: Long) {
        val result = solveDay3PartTwo(value)
        Assertions.assertThat(result).isEqualTo(expectedResult)
    }
}
