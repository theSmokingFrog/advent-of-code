package dev.nhoffmann.aoc.y2021.day2

import dev.nhoffmann.aoc.load

fun solveDayTwoPartOne(commands: List<Command>): Int {
    var horizontalPosition = 0
    var depth = 0

    commands.forEach {
        when (it.direction) {
            Direction.FORWARD -> horizontalPosition += it.size
            Direction.UP -> depth -= it.size
            Direction.DOWN -> depth += it.size
        }
    }

    return horizontalPosition * depth
}

fun solveDayTwoPartTwo(commands: List<Command>): Int {
    var aim = 0
    var horizontalPosition = 0
    var depth = 0

    commands.forEach {
        when (it.direction) {
            Direction.FORWARD -> {
                horizontalPosition += it.size
                depth += aim * it.size
            }
            Direction.UP -> aim -= it.size
            Direction.DOWN -> aim += it.size
        }
    }

    return horizontalPosition * depth
}

fun main() {
    val commands = commandsFromStrings(load("/inputs/2021/day-2.txt"))
    println("Solution to Day 2, Part 1 is '${solveDayTwoPartOne(commands)}'")
    println("Solution to Day 2, Part 2 is '${solveDayTwoPartTwo(commands)}'")
}
