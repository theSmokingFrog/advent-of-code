package dev.nhoffmann.aoc.y2024.day1

import dev.nhoffmann.aoc.load

private fun createLeftAndRightList(loadedData: List<String>) = loadedData.map { line ->
    val split = line.split("   ")
    split.first().toInt() to split.last().toInt()
}.unzip()

fun solveDay1PartOne(loadedData: List<String>): Int {
    val (leftList, rightList) = createLeftAndRightList(loadedData)

    return leftList.sorted()
        .zip(rightList.sorted()).sumOf { (left, right) ->
            if (left > right) {
                left - right
            } else {
                right - left
            }
        }
}


fun solveDay1PartTwo(loadedData: List<String>): Int {
    val (leftList, rightList) = createLeftAndRightList(loadedData)

    return leftList.sumOf { rightList.count { entry -> entry == it } * it }
}

fun main() {
    val loadedData = load("/inputs/2024/day-1.txt")
    println("Solution to Day 1, Part 1 is '${solveDay1PartOne(loadedData)}'")
    println("Solution to Day 1, Part 2 is '${solveDay1PartTwo(loadedData)}'")
}
