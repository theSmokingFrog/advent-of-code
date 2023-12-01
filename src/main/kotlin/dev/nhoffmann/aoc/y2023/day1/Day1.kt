package dev.nhoffmann.aoc.y2023.day1

import dev.nhoffmann.aoc.load

fun solveDay1PartOne(loadedData: List<String>): Int {
    val calibrationValues = CalibrationValues()
    return loadedData.sumOf { calibrationValues.analyzeDigitsOnly(it) }
}

fun solveDay1PartTwo(loadedData: List<String>): Int {
    val calibrationValues = CalibrationValues()
    return loadedData.sumOf { calibrationValues.analyze(it) }
}

fun main() {
    val loadedData = load("/inputs/2023/day-1.txt")
    println("Solution to Day 1, Part 1 is '${solveDay1PartOne(loadedData)}'")
    println("Solution to Day 1, Part 2 is '${solveDay1PartTwo(loadedData)}'")
}
