package dev.nhoffmann.aoc.y2025.day2

import dev.nhoffmann.aoc.loadAsSingle

fun solveDay2PartOne(loadedData: String): Long {
    val ranges = loadedData
        .split(",")
        .map { it.split("-") }
        .map { it[0].toLong() .. it[1].toLong() }

    return ranges.sumOf { range ->
        range
            .map { it.toString() }
            .filter { it.length % 2 == 0 }
            .filter {
                val middleIndex = it.length / 2
                val firstHalf = it.substring(0, middleIndex)
                val secondHalf = it.substring(middleIndex)
                firstHalf == secondHalf
            }
            .sumOf { it.toLong() }
    }
}


fun solveDay2PartTwo(loadedData: String): Int {
    TODO()
}

fun main() {
    val loadedData = loadAsSingle("/inputs/2025/day-2.txt")
    println("Solution to Day 2, Part 1 is '${solveDay2PartOne(loadedData)}'")
    println("Solution to Day 2, Part 2 is '${solveDay2PartTwo(loadedData)}'")
}
