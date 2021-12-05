package dev.nhoffmann.aoc.y2021.day5

import dev.nhoffmann.aoc.load

private fun List<String>.toLines() = map { Line.from(it) }

private fun List<Line>.noDiagonalLines() = filter { it.isHorizontal() || it.isVertical() }

private fun List<Line>.toPoints() = map { it.toPoints() }.flatten()

private fun List<Point>.countIntersections() = groupingBy { it.toString() }.eachCount().count { it.value >= 2 }

fun solveDayFivePartOne(thermalVentData: List<String>): Int {
    return thermalVentData.toLines()
        .noDiagonalLines()
        .toPoints()
        .countIntersections()
}

fun solveDayFivePartTwo(thermalVentData: List<String>): Int {
    return thermalVentData.toLines()
        .toPoints()
        .countIntersections()
}

fun main() {
    val loadedData = load("/inputs/2021/day-5.txt")
    println("Solution to Day X, Part 1 is '${solveDayFivePartOne(loadedData)}'")
    println("Solution to Day X, Part 2 is '${solveDayFivePartTwo(loadedData)}'")
}
