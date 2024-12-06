package dev.nhoffmann.aoc.y2024.day4

import dev.nhoffmann.aoc.load

fun solveDay4PartOne(wordGrid: List<String>, searchTerm: String): Int {
    return WordFinder(wordGrid).count(searchTerm)
}


fun solveDay4PartTwo(loadedData: List<String>): Int {
    return XMasFinder(loadedData).count()
}

fun main() {
    val loadedData = load("/inputs/2024/day-4.txt")
    println("Solution to Day 4, Part 1 is '${solveDay4PartOne(loadedData, "XMAS")}'")
    println("Solution to Day 4, Part 2 is '${solveDay4PartTwo(loadedData)}'")
}
