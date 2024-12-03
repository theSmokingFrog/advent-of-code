package dev.nhoffmann.aoc.y2015.day2

import dev.nhoffmann.aoc.load

fun solveDay2PartOne(loadedData: List<String>): Int {
    return loadedData.map { Box(it) }.sumOf { it.calcRequiredWrappingPaper() }
}

fun solveDay2PartTwo(loadedData: List<String>): Int {
    return loadedData.map { Box(it) }.sumOf { it.calcRibbonLength() }
}

fun main() {
    val loadedData = load("/inputs/2015/day-2.txt")
    println("Solution to Day 2, Part 1 is '${solveDay2PartOne(loadedData)}'")
    println("Solution to Day 2, Part 2 is '${solveDay2PartTwo(loadedData)}'")
}
