package dev.nhoffmann.aoc.y2021.day7

import dev.nhoffmann.aoc.load

private fun List<String>.splitToInt() = first().trim().split(',').map { it.toInt() }.toList()
private fun Double.forcePositive(): Double = if (this < 0) this * -1 else this
private fun Int.forcePositive(): Int = if (this < 0) this * -1 else this
fun calculateFuelCostGauss(crabPositions: List<Int>, positionToTest: Int): Int = crabPositions.sumOf { it gaussSum positionToTest }

private infix fun Int.gaussSum(to: Int): Int {
    val diff = (this - to).forcePositive()
    return (diff * (diff + 1)) / 2
}

private fun List<Int>.median(): Double {
    val sortedNumbers = sorted()
    return when {
        sortedNumbers.size % 2 != 0 -> sortedNumbers[sortedNumbers.size / 2].toDouble()
        else -> (sortedNumbers[(sortedNumbers.size - 1) / 2] + sortedNumbers[sortedNumbers.size / 2]).toDouble() / 2.0
    }
}


fun solveDaySevenPartOne(loadedData: List<String>): Int {
    val crabPositions = loadedData.splitToInt()
    val targetPosition = crabPositions.median()

    return crabPositions.map { it - targetPosition }.sumOf { it.forcePositive() }.toInt()
}

fun solveDaySevenPartTwo(loadedData: List<String>): Int {
    val crabPositions = loadedData.splitToInt().sorted()
    val rangeOfPositions = crabPositions.first()..crabPositions.last()

    val associateWith = rangeOfPositions.associateWith { calculateFuelCostGauss(crabPositions, it) }
    return associateWith.values.minOrNull()!!
}

fun main() {
    val loadedData = load("/inputs/2021/day-7.txt")
    println("Solution to Day 7, Part 1 is '${solveDaySevenPartOne(loadedData)}'")
    println("Solution to Day 7, Part 2 is '${solveDaySevenPartTwo(loadedData)}'")
}
