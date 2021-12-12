package dev.nhoffmann.aoc.y2021.day9

import dev.nhoffmann.aoc.load

fun solveDay9PartOne(rawHeightMap: List<String>): Int {
    return HeightMap(rawHeightMap).lowPoints().sumOf { it.value() }
}

fun solveDay9PartTwo(loadedData: List<String>): Int {
    return -1
}

fun main() {
    val loadedData = load("/inputs/2021/day-9.txt")
    println("Solution to Day 9, Part 1 is '${solveDay9PartOne(loadedData)}'")
    println("Solution to Day 9, Part 2 is '${solveDay9PartTwo(loadedData)}'")
}
