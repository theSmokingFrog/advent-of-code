package dev.nilshoffmann.day4

import dev.nilshoffmann.load

val PASSPORT_BATCH_BLOCK_REGEX = """(\w{3}):(\S+)""".toRegex()

fun readPassports(passportBatchLines: List<String>): List<Passport> {

    return passportBatchLines.joinToString("\n")
        .splitToSequence("\n\n")
        .map { PASSPORT_BATCH_BLOCK_REGEX.findAll(it) }
        .map { matches ->
            val passportBuilder = Passport.Builder()
            matches.forEach {
                val (block, value) = it.destructured
                passportBuilder.add(enumValueOf(block.toUpperCase()), value)
            }
            passportBuilder.build()
        }.toList()
}


fun solveDay4PartOne(passportBatchLines: List<String>): Int {
    return readPassports(passportBatchLines)
        .filter { it.necessaryFieldsPresent() }
        .count()
}

fun solveDay4PartTwo(passportBatchLines: List<String>): Int {
    return readPassports(passportBatchLines)
        .filter { it.fieldsValid() }
        .count()
}

fun main() {
    val passportBatchLines = load("/inputs/day-4.txt")
    println("Solution to Day 4, Part 1 is '${solveDay4PartOne(passportBatchLines)}'")
    println("Solution to Day 4, Part 2 is '${solveDay4PartTwo(passportBatchLines)}'")
}