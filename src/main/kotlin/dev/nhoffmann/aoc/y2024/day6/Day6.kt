package dev.nhoffmann.aoc.y2024.day6

import dev.nhoffmann.aoc.load

fun solveDay6PartOne(board: List<String>): Int {
    val obstacles = mutableSetOf<Obstacle>()
    var guard: Guard? = null

    for ((rowIndex, row) in board.withIndex()) {
        for ((colIndex, col) in row.withIndex()) {
            when (col) {
                '#' -> obstacles += Obstacle(Point(colIndex, rowIndex))
                '^' -> guard = Guard(Point(colIndex, rowIndex), Point(board.lastIndex, row.lastIndex))
            }
        }
    }

    require(guard != null) { "Cannot find Guard in Board" }

    while (guard.isInsideGameBoard()) {
        guard.takeTurn(obstacles)
    }

    return guard.visitedLocationsCount()
}

fun solveDay6PartTwo(loadedData: List<String>): Int {
    TODO()
}

fun main() {
    val loadedData = load("/inputs/2024/day-6.txt")
    println("Solution to Day 6, Part 1 is '${solveDay6PartOne(loadedData)}'")
    println("Solution to Day 6, Part 2 is '${solveDay6PartTwo(loadedData)}'")
}
