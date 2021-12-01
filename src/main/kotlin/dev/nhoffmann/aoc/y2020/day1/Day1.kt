package dev.nhoffmann.aoc.y2020.day1

import dev.nhoffmann.aoc.load

fun solveDayOnePartOne(numbers: List<Int>): Int {
    val matchingPair = numbers.withIndex()
        .flatMap { num -> numbers.subList(num.index, numbers.lastIndex).map { num.value to it } }
        .first { it.first + it.second == 2020 }

    return matchingPair.first * matchingPair.second
}

fun solveDayOnePartTwo(numbers: List<Int>): Int {
    val matchingTriple = numbers.withIndex()
        .flatMap { num -> numbers.subList(num.index, numbers.lastIndex).map { num.value to it } }
        .flatMap { pair -> numbers.map { Triple(pair.first, pair.second, it) } }
        .first { it.first + it.second + it.third == 2020 }

    return matchingTriple.first * matchingTriple.second * matchingTriple.third
}

fun main() {
    val numbers = load("/inputs/2020/day-1.txt").map { Integer.parseInt(it) }
    println("Solution to Day 1, Part 1 is '${solveDayOnePartOne(numbers)}'")
    println("Solution to Day 1, Part 2 is '${solveDayOnePartTwo(numbers)}'")
}

