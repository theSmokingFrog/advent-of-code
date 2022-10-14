package dev.nhoffmann.aoc.y2021.day10

import dev.nhoffmann.aoc.load

fun solveDay10PartOne(loadedData: List<String>): Long {
    return NavigationSubSystem(loadedData).scoreCorruptLines()
}

fun solveDay10PartTwo(loadedData: List<String>): Long {
    return NavigationSubSystem(loadedData).scoreIncompleteLines();
}

fun main() {
    val loadedData = load("/inputs/2021/day-10.txt")
    println("Solution to Day 10, Part 1 is '${solveDay10PartOne(loadedData)}'")
    println("Solution to Day 10, Part 2 is '${solveDay10PartTwo(loadedData)}'")
}
