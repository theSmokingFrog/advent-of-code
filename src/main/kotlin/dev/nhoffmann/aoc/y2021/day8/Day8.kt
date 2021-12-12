package dev.nhoffmann.aoc.y2021.day8

import dev.nhoffmann.aoc.load

fun solveDay8PartOne(loadedData: List<String>): Int {
    return loadedData.asSequence()
        .map { it.substringAfter('|').trim().split(' ') }
        .flatten()
        .map { SevenSegmentDisplay.fromString(it) }
        .filter { it.config != SevenSegmentValue.UNKNOWN }
        .count { it.value() in listOf<Short>(1, 4, 7, 8) }
}

fun solveDay8PartTwo(loadedData: List<String>): Int {
    return loadedData.map { MalfunctionData(it) }.sumOf { it.fixedNumericValue() }
}

fun main() {
    val loadedData = load("/inputs/2021/day-8.txt")
    println("Solution to Day 8, Part 1 is '${solveDay8PartOne(loadedData)}'")
    println("Solution to Day 8, Part 2 is '${solveDay8PartTwo(loadedData)}'")
}
