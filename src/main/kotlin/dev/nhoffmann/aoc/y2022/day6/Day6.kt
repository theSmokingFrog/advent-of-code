package dev.nhoffmann.aoc.y2022.day6

import dev.nhoffmann.aoc.loadAsSingle

fun solveDay6PartOne(raw: String): Int {
    return Signal(raw).findMarkerStartPosition(markerSize = 4)
}

fun solveDay6PartTwo(raw: String): Int {
    return Signal(raw).findMarkerStartPosition(markerSize = 14)
}

fun main() {
    val loadedData = loadAsSingle("/inputs/2022/day-6.txt")
    println("Solution to Day 6, Part 1 is '${solveDay6PartOne(loadedData)}'")
    println("Solution to Day 6, Part 2 is '${solveDay6PartTwo(loadedData)}'")
}
