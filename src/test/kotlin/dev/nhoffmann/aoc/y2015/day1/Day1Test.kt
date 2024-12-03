package dev.nhoffmann.aoc.y2015.day1

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day1Test {
    companion object {
        @JvmStatic
        fun partOneTestDataSets(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("(())", 0L),
                Arguments.of("()()", 0L),
                Arguments.of("(((", 3L),
                Arguments.of("(()(()(", 3L),
                Arguments.of("))(((((", 3L),
                Arguments.of("())", -1L),
                Arguments.of("))(", -1L),
                Arguments.of(")))", -3L),
                Arguments.of(")())())", -3L)
            )
        }

        @JvmStatic
        fun partTwoTestDataSets(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(")", 1L),
                Arguments.of("()())", 5L),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("partOneTestDataSets")
    fun solveDay1PartOneTest(value: String, expectedResult: Long) {
        val result = solveDay1PartOne(value)
        Assertions.assertThat(result).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("partTwoTestDataSets")
    fun solveDay1PartTwoTest(value: String, expectedResult: Long) {
        val result = solveDay1PartTwo(value)
        Assertions.assertThat(result).isEqualTo(expectedResult)
    }
}
