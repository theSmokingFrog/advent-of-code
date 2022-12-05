package dev.nhoffmann.aoc.y2022.day5

import dev.nhoffmann.aoc.loadAsSingle


fun solveDay5PartOne(loadedData: String): String {
    val split = loadedData.split("\n\n")

    val crane = Crane(
        crateStacks = CrateStacks.of(drawing = split.first()),
        rearrangementProcedure = Instruction.createFrom(rawInstructions = split.last())
    )
    crane.rearrangeCrates()

    return crane.crateStacks.getTopCrates()
}

fun solveDay5PartTwo(loadedData: String): Int {
    TODO()
}

fun main() {
    val loadedData = loadAsSingle("/inputs/2022/day-5.txt")
    println("Solution to Day 5, Part 1 is '${solveDay5PartOne(loadedData)}'")
    println("Solution to Day 5, Part 2 is '${solveDay5PartTwo(loadedData)}'")
}
