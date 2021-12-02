package dev.nhoffmann.aoc.y2021.day2

import dev.nhoffmann.aoc.load
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class Day2Test {
    companion object {
        const val TEST_DATA_FILE = "/inputs/2021/day-2-test.txt"
    }

    private lateinit var commands: List<Command>

    @BeforeEach
    internal fun setUp() {
        commands = commandsFromStrings(load(TEST_DATA_FILE))
    }

    @Test
    fun solveDayTwoPartOneTest() {
        assertThat(commands).isNotEmpty
        val result = solveDayTwoPartOne(commands)
        assertThat(result).isEqualTo(150)
    }

    @Test
    fun solveDayTwoPartTwoTest() {
        assertThat(commands).isNotEmpty
        val result = solveDayTwoPartTwo(commands)
        assertThat(result).isEqualTo(900)
    }
}
