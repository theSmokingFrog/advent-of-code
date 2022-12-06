package dev.nhoffmann.aoc.y2022.day6

import dev.nhoffmann.aoc.loadAsSingle
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day6Test {
    companion object {

        @JvmStatic
        fun partOneTestDataSets(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("/inputs/2022/day-6-test-1.txt", 7),
                Arguments.of("/inputs/2022/day-6-test-2.txt", 5),
                Arguments.of("/inputs/2022/day-6-test-3.txt", 6),
                Arguments.of("/inputs/2022/day-6-test-4.txt", 10),
                Arguments.of("/inputs/2022/day-6-test-5.txt", 11)
            )
        }

        @JvmStatic
        fun partTwoTestDataSets(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("/inputs/2022/day-6-test-1.txt", 19),
                Arguments.of("/inputs/2022/day-6-test-2.txt", 23),
                Arguments.of("/inputs/2022/day-6-test-3.txt", 23),
                Arguments.of("/inputs/2022/day-6-test-4.txt", 29),
                Arguments.of("/inputs/2022/day-6-test-5.txt", 26)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("partOneTestDataSets")
    fun solveDay6PartOneTest(filePath: String, expectedResult: Int) {
        val input = loadAsSingle(filePath)
        solveDay6PartOne(input).let {
            Assertions.assertThat(it).isEqualTo(expectedResult)
        }
    }

    @ParameterizedTest
    @MethodSource("partTwoTestDataSets")
    fun solveDay6PartTwoTest(filePath: String, expectedResult: Int) {
        val input = loadAsSingle(filePath)
        solveDay6PartTwo(input).let {
            Assertions.assertThat(it).isEqualTo(expectedResult)
        }
    }
}
