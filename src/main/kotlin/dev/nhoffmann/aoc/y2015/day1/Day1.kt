package dev.nhoffmann.aoc.y2015.day1

import dev.nhoffmann.aoc.loadAsSingle

fun solveDay1PartOne(loadedData: String): Long {
    return loadedData.sumOf {
        when (it) {
            '(' -> 1L
            ')' -> -1L
            else -> 0L
        }
    }
}

fun solveDay1PartTwo(loadedData: String): Long {
    var result = 0L;
    for ((index, char) in loadedData.withIndex()) {
        when (char) {
            '(' -> result += 1L
            ')' -> result += -1L
        }
        if (result <= -1) {
            return index + 1L;
        }
    }
    throw RuntimeException("The Basement was never entered!")
}

fun main() {
    val loadedData = loadAsSingle("/inputs/2015/day-1.txt")
    println("Solution to Day 1, Part 1 is '${solveDay1PartOne(loadedData)}'")
    println("Solution to Day 1, Part 2 is '${solveDay1PartTwo(loadedData)}'")
}
