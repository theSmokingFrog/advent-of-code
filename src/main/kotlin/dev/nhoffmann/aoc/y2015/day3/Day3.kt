package dev.nhoffmann.aoc.y2015.day3

import dev.nhoffmann.aoc.loadAsSingle

fun solveDay3PartOne(loadedData: String): Int {
    val santa = Santa()

    loadedData.forEach { santa.move(it) }

    return santa.uniquelyVisitedLocations().size
}

fun solveDay3PartTwo(loadedData: String): Int {
    val santa = Santa()
    val roboSanta = Santa()

    loadedData.withIndex().forEach { (i, c) ->
        if (i % 2 == 0) {
            santa.move(c)
        } else {
            roboSanta.move(c)
        }
    }

    return (santa.uniquelyVisitedLocations() + roboSanta.uniquelyVisitedLocations()).distinct().size
}

fun main() {
    val loadedData = loadAsSingle("/inputs/2015/day-3.txt")
    println("Solution to Day 3, Part 1 is '${solveDay3PartOne(loadedData)}'")
    println("Solution to Day 3, Part 2 is '${solveDay3PartTwo(loadedData)}'")
}
