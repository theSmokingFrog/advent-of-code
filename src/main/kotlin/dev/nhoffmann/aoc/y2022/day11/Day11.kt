package dev.nhoffmann.aoc.y2022.day11

import dev.nhoffmann.aoc.loadAsSingle

private fun String.asMonkeys(): List<Monkey> = split("\n\n").map { monkeyFromDefinition(it) }.sortedBy { it.id }

fun solveDay11PartOne(loadedData: String): Long {
    return MonkeysKeepAway(monkeys = loadedData.asMonkeys(), rounds = 20)
        .play()
        .monkeyBusiness()
}

fun solveDay11PartTwo(loadedData: String): Long {
    return MonkeysKeepAway(monkeys = loadedData.asMonkeys(), rounds = 10000)
        .playSerious()
        .monkeyBusiness()
}

fun main() {
    val loadedData = loadAsSingle("/inputs/2022/day-11.txt")
    println("Solution to Day 11, Part 1 is '${solveDay11PartOne(loadedData)}'")
    println("Solution to Day 11, Part 2 is '${solveDay11PartTwo(loadedData)}'")
}
