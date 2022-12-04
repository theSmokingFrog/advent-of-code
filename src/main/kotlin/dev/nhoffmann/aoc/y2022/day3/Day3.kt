package dev.nhoffmann.aoc.y2022.day3

import dev.nhoffmann.aoc.load

fun solveDay3PartOne(loadedData: List<String>): Int {
    return loadedData.asSequence()
        .map { Rucksack(it) }
        .map { it.findWronglyPackedItem() }
        .sumOf { it.toPriority() }
}

fun solveDay3PartTwo(loadedData: List<String>): Int {
    return loadedData.asSequence()
        .map { Rucksack(it) }
        .chunked(3)
        .map { it.first().findCommonItem(it.subList(1, it.size)) }
        .sumOf { it.toPriority() }
}

fun main() {
    val loadedData = load("/inputs/2022/day-3.txt")
    println("Solution to Day 3, Part 1 is '${solveDay3PartOne(loadedData)}'")
    println("Solution to Day 3, Part 2 is '${solveDay3PartTwo(loadedData)}'")
}
