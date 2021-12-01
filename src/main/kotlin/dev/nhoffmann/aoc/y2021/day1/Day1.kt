package dev.nhoffmann.aoc.y2021.day1

import dev.nhoffmann.aoc.loadInt

fun solveDayOnePartOne(depthMeasures: List<Int>): Int {
    return depthMeasures
        .windowed(2)
        .count { it[1] > it[0] }
}

fun solveDayOnePartTwo(depthMeasures: List<Int>): Int {
    return depthMeasures
        .windowed(3)
        .map { it.sum() }
        .windowed(2)
        .count { it[1] > it[0] }
}

fun main() {
    val numbers = loadInt("/inputs/2021/day-1.txt")
    println("Solution to Day 1, Part 1 is '${solveDayOnePartOne(numbers)}'")
    println("Solution to Day 1, Part 2 is '${solveDayOnePartTwo(numbers)}'")
}
