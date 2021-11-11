package dev.nhoffmann.aoc.y2020.day7

import dev.nhoffmann.aoc.load
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day7Test {
    companion object {
        const val DAY7_TEST_DATA_FILE = "/2020/inputs/day-7-test.txt"
        const val DAY7_2_TEST_DATA_FILE = "/2020/inputs/day-7.2-test.txt"
    }

    @Test
    fun `Part One Example is correctly calculated`() {
        val fittingBags = solveDay7PartOne(load(DAY7_TEST_DATA_FILE), "shiny gold")
        Assertions.assertEquals(4, fittingBags)
    }

    @Test
    fun `Part Two Example One is correctly calculated`() {
        val bagCount = solveDay7PartTwo(load(DAY7_TEST_DATA_FILE), "shiny gold")
        Assertions.assertEquals(32, bagCount)
    }

    @Test
    fun `Part Two Example Two is correctly calculated`() {
        val bagCount = solveDay7PartTwo(load(DAY7_2_TEST_DATA_FILE), "shiny gold")
        Assertions.assertEquals(126, bagCount)
    }
}
