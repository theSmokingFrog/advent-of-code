package dev.nhoffmann.aoc.y2022.day1

import dev.nhoffmann.aoc.load

private fun determineCalories(inventory: List<String>): List<Int> {
    val caloriesByElf = mutableListOf<Int>()
    var caloriesCount = 0;
    for (line in inventory) {
        if (line.isEmpty()) {
            caloriesByElf.add(caloriesCount)
            caloriesCount = 0;
        } else {
            caloriesCount += line.toInt()
        }
    }
    caloriesByElf.add(caloriesCount)

    return caloriesByElf
}

fun solveDay1PartOne(inventory: List<String>): Int {
    return determineCalories(inventory).max();
}

fun solveDay1PartTwo(inventory: List<String>): Int {
    return determineCalories(inventory).sortedDescending().subList(0, 3).sum()
}

fun main() {
    val loadedData = load("/inputs/2022/day-1.txt")
    println("Solution to Day 1, Part 1 is '${solveDay1PartOne(loadedData)}'")
    println("Solution to Day 1, Part 2 is '${solveDay1PartTwo(loadedData)}'")
}

