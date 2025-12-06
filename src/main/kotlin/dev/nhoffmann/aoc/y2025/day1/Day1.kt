package dev.nhoffmann.aoc.y2025.day1

import dev.nhoffmann.aoc.load

fun solveDay1PartOne(loadedData: List<String>): Int {
    val entrance = SecretEntrance()
    entrance.unlockStandard(loadedData)
    return entrance.zerosInSequence
}


fun solveDay1PartTwo(loadedData: List<String>): Int {
    val entrance = SecretEntrance()
    entrance.unlockWithCLICK(loadedData)
    return entrance.dial.zeroClicks
}

fun main() {
    val loadedData = load("/inputs/2025/day-1.txt")
    println("Solution to Day 1, Part 1 is '${solveDay1PartOne(loadedData)}'")
    println("Solution to Day 1, Part 2 is '${solveDay1PartTwo(loadedData)}'")
}
