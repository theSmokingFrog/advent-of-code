package dev.nhoffmann.aoc.y2022.day2

import dev.nhoffmann.aoc.load

fun solveDay2PartOne(strategyGuide: List<String>): Int {
    return strategyGuide.asSequence().map { AssumedRound(it) }.sumOf { it.evaluate() }
}

fun solveDay2PartTwo(strategyGuide: List<String>): Int {
    return strategyGuide.asSequence().map { ClarifiedRound(it) }.sumOf { it.evaluate() }
}

fun main() {
    val loadedData = load("/inputs/2022/day-2.txt")
    println("Solution to Day 2, Part 1 is '${solveDay2PartOne(loadedData)}'")
    println("Solution to Day 2, Part 2 is '${solveDay2PartTwo(loadedData)}'")
}
