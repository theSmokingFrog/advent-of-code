package dev.nhoffmann.aoc.y2020.day5

import dev.nhoffmann.aoc.load
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day5Test {
    companion object {
        const val DAY5_TEST_DATA_FILE = "/2020/inputs/day-5-test.txt"
    }

    @Test
    fun `Part One Example is correctly calculated`() {
        val highestSeatId = solveDay5PartOne(load(DAY5_TEST_DATA_FILE))
        assertEquals(highestSeatId, 820)
    }
}
