package dev.nhoffmann.aoc.y2022.day9

import dev.nhoffmann.aoc.load

fun solveForRope(rawMotions: List<String>, rope: Rope): Int {
    rawMotions
        .map { Motion.of(it) }
        .forEach { rope.move(it) }

    return rope.uniqueTailPositions()
}

fun solveDay9PartOne(rawMotions: List<String>): Int = solveForRope(rawMotions, ShortRope())

fun solveDay9PartTwo(rawMotions: List<String>): Int = solveForRope(rawMotions, LongRope())

fun main() {
    val loadedData = load("/inputs/2022/day-9.txt")
    println("Solution to Day 9, Part 1 is '${solveDay9PartOne(loadedData)}'")
    println("Solution to Day 9, Part 2 is '${solveDay9PartTwo(loadedData)}'")
}
