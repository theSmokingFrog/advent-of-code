package dev.nhoffmann.aoc.y2022.day10

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day10Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2022/day-10-test.txt"
    }

    private lateinit var lines: List<String>

    @BeforeEach
    internal fun setUp() {
        lines = load(TEST_DATA_FILE)
        Assertions.assertThat(lines).isNotEmpty
    }

    @Test
    fun solveDay10PartOneTest() {
        val result = solveDay10PartOne(lines)
        Assertions.assertThat(result).isEqualTo(13140)
    }

    @Test
    fun solveDay10PartTwoTest() {
        val result = solveDay10PartTwo(lines)
        Assertions.assertThat(result).isEqualTo(
            """
            ##..##..##..##..##..##..##..##..##..##..
            ###...###...###...###...###...###...###.
            ####....####....####....####....####....
            #####.....#####.....#####.....#####.....
            ######......######......######......####
            #######.......#######.......#######.....
        """.trimIndent()
        )
    }
}
