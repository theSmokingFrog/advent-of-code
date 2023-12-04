package dev.nhoffmann.aoc.y2023.day4

import dev.nhoffmann.aoc.load

fun solveDay4PartOne(loadedData: List<String>): Int {
    return loadedData.map { ScratchCard(it) }.sumOf { it.getPoints() }
}

fun solveDay4PartTwo(loadedData: List<String>): Int {
    return ScratchCardWinningsAnalyzer(loadedData.map { ScratchCard(it) }).determineFinalAmountOfCards()
}

fun main() {
    val loadedData = load("/inputs/2023/day-4.txt")
    println("Solution to Day 4, Part 1 is '${solveDay4PartOne(loadedData)}'")
    println("Solution to Day 4, Part 2 is '${solveDay4PartTwo(loadedData)}'")
}
