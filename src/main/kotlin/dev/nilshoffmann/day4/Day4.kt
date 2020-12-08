package dev.nilshoffmann.day4

import dev.nilshoffmann.load

fun solveDay4PartOne(passportBatchLines: List<String>): Int {
    var passportBuilder = Passport.Builder()
    val passports = mutableListOf<Passport>()

    passportBatchLines.forEach { line ->
        if (line != "") {
            val passportBlock = """(\w{3}):(\S+)""".toRegex()
            passportBlock.findAll(line).forEach {
                val (block, value) = it.destructured
                passportBuilder.add(enumValueOf(block), value)
            }
        } else {
            passports += passportBuilder.build()
            passportBuilder = Passport.Builder()
        }
    }
    passports += passportBuilder.build()
    return passports.filter { it.isValid() }.count()
}

fun main() {
    val passportBatchLines = load("/inputs/day-4.txt")
    println("Solution to Day 4, Part 1 is '${solveDay4PartOne(passportBatchLines)}'")
}