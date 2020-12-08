package dev.nilshoffmann.day4

import dev.nilshoffmann.load

fun readPassports(passportBatchLines: List<String>): List<Passport> {
    var passportBuilder = Passport.Builder()
    val passports = mutableListOf<Passport>()

    passportBatchLines.forEach { line ->
        if (line != "") {
            val passportBlock = """(\w{3}):(\S+)""".toRegex()
            passportBlock.findAll(line).forEach {
                val (block, value) = it.destructured
                passportBuilder.add(enumValueOf(block.toUpperCase()), value)
            }
        } else {
            passports += passportBuilder.build()
            passportBuilder = Passport.Builder()
        }
    }
    passports += passportBuilder.build()
    return passports
}


fun solveDay4PartOne(passportBatchLines: List<String>): Int {
    return readPassports(passportBatchLines)
        .filter { it.isValidPartOne() }
        .count()
}

fun solveDay4PartTwo(passportBatchLines: List<String>): Int {
    return readPassports(passportBatchLines)
        .filter { it.isValidPartTwo() }
        .count()
}

fun main() {
    val passportBatchLines = load("/inputs/day-4.txt")
    println("Solution to Day 4, Part 1 is '${solveDay4PartOne(passportBatchLines)}'")
    println("Solution to Day 4, Part 2 is '${solveDay4PartTwo(passportBatchLines)}'")
}