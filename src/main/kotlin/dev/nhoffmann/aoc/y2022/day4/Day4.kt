package dev.nhoffmann.aoc.y2022.day4

import dev.nhoffmann.aoc.load

fun solveDay4PartOne(cleaningPlan: List<String>): Int {
    return cleaningPlan
        .map { CleaningPlanLine(it) }
        .map { it.areAssignmentsFullyOverlapping() }
        .count { it }
}

fun solveDay4PartTwo(cleaningPlan: List<String>): Int {
    return cleaningPlan
        .map { CleaningPlanLine(it) }
        .map { it.overlapsAtAll() }
        .count { it }
}

fun main() {
    val loadedData = load("/inputs/2022/day-4.txt")
    println("Solution to Day 4, Part 1 is '${solveDay4PartOne(loadedData)}'")
    println("Solution to Day 4, Part 2 is '${solveDay4PartTwo(loadedData)}'")
}
