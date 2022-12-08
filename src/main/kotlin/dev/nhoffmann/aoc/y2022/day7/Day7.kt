package dev.nhoffmann.aoc.y2022.day7

import dev.nhoffmann.aoc.loadAsSingle

fun solveDay7PartOne(loadedData: String): Int {

    return Terminal(commands = Command.generateFromString(loadedData))
        .sizeOfDirectoriesUpTo100k()
}

fun solveDay7PartTwo(loadedData: String): Int {
    return Terminal(commands = Command.generateFromString(loadedData))
        .findDirectorySizeToDelete()
}

fun main() {
    val loadedData = loadAsSingle("/inputs/2022/day-7.txt")
    println("Solution to Day 7, Part 1 is '${solveDay7PartOne(loadedData)}'")
    println("Solution to Day 7, Part 2 is '${solveDay7PartTwo(loadedData)}'")
}
