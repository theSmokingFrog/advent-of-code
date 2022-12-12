package dev.nhoffmann.aoc.y2022.day10

import dev.nhoffmann.aoc.load

fun solveDay10PartOne(loadedData: List<String>): Int {
    return Device(loadedData.map { Instruction.of(it) }).summarizeSignalChecks()
}

fun solveDay10PartTwo(loadedData: List<String>): String {
    return Device(loadedData.map { Instruction.of(it) }, -1).generateScreen()
}

fun main() {
    val loadedData = load("/inputs/2022/day-10.txt")
    println("Solution to Day 10, Part 1 is '${solveDay10PartOne(loadedData)}'")
    println("Solution to Day 10, Part 2 is '\n${solveDay10PartTwo(loadedData)}'")
}
