package dev.nhoffmann.aoc.y2020.day9

import dev.nhoffmann.aoc.loadLong

fun solvePartOne(numbers: List<Long>, preambleSize: Int): Long {
    return numbers.windowed(preambleSize + 1)
        .asSequence()
        .map { ExchangeMaskingAdditionSystem(it.last(), it.dropLast(1)) }
        .filter { it.verify() }
        .first()
        .numberToVerify
}

fun main() {
    val numbers = loadLong("/inputs/2020/day-9.txt")
    println("Solution to Day 8, Part 1 is '${solvePartOne(numbers, 25)}'")
    //println("Solution to Day 8, Part 2 is '${solveDay8PartTwo(lines)}'")
}
