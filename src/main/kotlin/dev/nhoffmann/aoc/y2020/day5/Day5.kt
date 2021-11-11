package dev.nhoffmann.aoc.y2020.day5

import dev.nhoffmann.aoc.load

fun solveDay5PartOne(encodedSeatIds: List<String>): Int {
    val highestSeatId = encodedSeatIds.map { SeatID(it) }
        .map { it.asInt() }
        .maxOrNull()

    return highestSeatId ?: -1
}

fun solveDay5PartTwo(encodedSeatIds: List<String>): Int {
    val sortedSeatIds = encodedSeatIds.map { SeatID(it) }
        .map { it.asInt() }
        .sorted()

    return sortedSeatIds.filterIndexed { index, i ->
        if (sortedSeatIds.lastIndex != index) {
            i + 1 != sortedSeatIds[index + 1]
        } else {
            false
        }
    }.first().plus(1)
}

fun main() {
    val encodedSeatIds = load("/2020/inputs/day-5.txt")
    println("Solution to Day 5, Part 1 is '${solveDay5PartOne(encodedSeatIds)}'")
    println("Solution to Day 5, Part 2 is '${solveDay5PartTwo(encodedSeatIds)}'")
}
