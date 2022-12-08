package dev.nhoffmann.aoc.y2022.day8

import dev.nhoffmann.aoc.load

fun solveDay8PartOne(loadedData: List<String>): Int {
    return Forest(loadedData).findTreesVisibleFromEdge()
}

fun solveDay8PartTwo(loadedData: List<String>): Int {
    return Forest(loadedData).findBestScenicScore()
}

fun main() {
    val loadedData = load("/inputs/2022/day-8.txt")
    println("Solution to Day 8, Part 1 is '${solveDay8PartOne(loadedData)}'")
    println("Solution to Day 8, Part 2 is '${solveDay8PartTwo(loadedData)}'")
}
