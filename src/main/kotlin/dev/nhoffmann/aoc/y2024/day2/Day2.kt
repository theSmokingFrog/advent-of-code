package dev.nhoffmann.aoc.y2024.day2

import dev.nhoffmann.aoc.load

fun solveDay2PartOne(loadedData: List<String>): Int {
    return loadedData
        .map { Report(it) }
        .count { it.isSafe() }
}

fun solveDay2PartTwo(loadedData: List<String>): Int {
    return loadedData
        .map { Report(it) }
        .count { it.isSafeWhenDampened() }
}

fun main() {
    val loadedData = load("/inputs/2024/day-2.txt")
    println("Solution to Day 2, Part 1 is '${solveDay2PartOne(loadedData)}'")
    println("Solution to Day 2, Part 2 is '${solveDay2PartTwo(loadedData)}'")
}
