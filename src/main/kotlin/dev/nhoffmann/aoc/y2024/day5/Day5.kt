package dev.nhoffmann.aoc.y2024.day5

import dev.nhoffmann.aoc.load
import java.util.*

fun solveDay5PartOne(loadedData: List<String>): Int {
    val data = PrinterData(loadedData)
    return data.updates.filter { findCorrectUpdates(it, data.rules) }.sumOf { it[it.size / 2] }
}

fun solveDay5PartTwo(loadedData: List<String>): Int {
    val data = PrinterData(loadedData)

    return data.updates
        .filter { !findCorrectUpdates(it, data.rules) }
        .map { fixIncorrectUpdate(it, data.rules) }
        .sumOf { it[it.size / 2] }
}

private fun findCorrectUpdates(update: List<Int>, rules: Rules): Boolean {
    val reversedUpdate = update.reversed()

    for ((index, number) in reversedUpdate.withIndex()) {
        val hasToOccurBefore = rules.getHasToOccurBefore(number)
        val allBefore = reversedUpdate.subList(index + 1, reversedUpdate.size)

        if (allBefore.any { it in hasToOccurBefore }) {
            return false
        }
    }
    return true
}

private fun fixIncorrectUpdate(update: List<Int>, rules: Rules): List<Int> {
    val updateToFix = LinkedList(update)

    val reversedUpdate = update.reversed()

    for ((index, number) in reversedUpdate.withIndex()) {
        val hasToOccurBefore = rules.getHasToOccurBefore(number)
        val allBefore = reversedUpdate.subList(index + 1, reversedUpdate.size)

        allBefore.intersect(hasToOccurBefore).forEach {
            updateToFix.remove(number)
            updateToFix.add(updateToFix.indexOf(it), number)
        }
    }
    return if (findCorrectUpdates(updateToFix, rules)) {
        updateToFix
    } else {
        fixIncorrectUpdate(updateToFix, rules)
    }
}


fun main() {
    val loadedData = load("/inputs/2024/day-5.txt")
    println("Solution to Day 5, Part 1 is '${solveDay5PartOne(loadedData)}'")
    println("Solution to Day 5, Part 2 is '${solveDay5PartTwo(loadedData)}'")
}
