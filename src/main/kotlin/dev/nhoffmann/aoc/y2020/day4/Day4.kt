package dev.nhoffmann.aoc.y2020.day4

import dev.nhoffmann.aoc.load

val PASSPORT_BATCH_BLOCK_REGEX = """(\w{3}):(\S+)""".toRegex()

fun readPassports(passportBatchLines: List<String>): List<Passport> {
    return passportBatchLines.joinToString("\n")
        .splitToSequence("\n\n")
        .map { PASSPORT_BATCH_BLOCK_REGEX.findAll(it) }
        .map { passportFromMatches(it) }.toList()
}

fun passportFromMatches(matches: Sequence<MatchResult>): Passport {
    val passportBuilder = Passport.Builder()
    matches.forEach {
        val (block, value) = it.destructured
        passportBuilder.add(enumValueOf(block.uppercase()), value)
    }
    return passportBuilder.build()
}


fun solveDay4PartOne(passportBatchLines: List<String>): Int {
    return readPassports(passportBatchLines).count { it.necessaryFieldsPresent() }
}

fun solveDay4PartTwo(passportBatchLines: List<String>): Int {
    return readPassports(passportBatchLines).count { it.fieldsValid() }
}

fun main() {
    val passportBatchLines = load("/inputs/2020/day-4.txt")
    println("Solution to Day 4, Part 1 is '${solveDay4PartOne(passportBatchLines)}'")
    println("Solution to Day 4, Part 2 is '${solveDay4PartTwo(passportBatchLines)}'")
}
