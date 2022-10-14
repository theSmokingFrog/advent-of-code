package dev.nhoffmann.aoc.y2021.day6

import dev.nhoffmann.aoc.load

private fun List<String>.fishies() = map { it.split(',') }.flatten().map { Lanternfish(it.toInt()) }

private fun growFishiesForDaysInefficient(lanternFishData: List<String>, days: Int): Long {
    val fishies = lanternFishData.fishies().toMutableList()

    for (i in 0 until days) {
        val newFishies = fishies.mapNotNull { it.simulateGrowthInefficient() }
        fishies += newFishies
    }

    return fishies.size.toLong()
}

private fun secondAttempt(lanternFishData: List<String>, days: Int): Long {
    val fishies = lanternFishData.fishies()

    for (i in 0 until days) {
        fishies.forEach { it.growChildren() }
    }

    return fishies.sumOf { it.deepCount() } + fishies.size
}

fun solveDaySixPartOne(lanternFishData: List<String>): Long {
    return secondAttempt(lanternFishData, 80)
}

fun solveDaySixPartTwo(lanternFishData: List<String>): Long {
    return growFishiesForDaysInefficient(lanternFishData, 256)
}

fun main() {
    val lanternFishData = load("/inputs/2021/day-6.txt")
    println("Solution to Day 6, Part 1 is '${solveDaySixPartOne(lanternFishData)}'")
    println("Solution to Day 6, Part 2 is '${solveDaySixPartTwo(lanternFishData)}'")
}
