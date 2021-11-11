package dev.nhoffmann.aoc.y2020.day2

import dev.nhoffmann.aoc.load

fun solveDayTwoPartOne(pPasswords: List<Password>): Int {
    return pPasswords.filter { it.partOnePolicyValid() }.size
}

fun solveDayTwoPartTwo(pPasswords: List<Password>): Int {
    return pPasswords.filter { it.partTwoPolicyValid() }.size
}

fun loadPasswords(pathInResource: String): List<Password> {
    val passwordLineRegex = """^(\d+)-(\d+) (\w)\W*(\w+)""".toRegex()
    return load(pathInResource).map {
        val (low, high, ch, pw) = passwordLineRegex.find(it)!!.destructured
        Password(low, high, ch, pw)
    }
}

fun main() {
    val passwords = loadPasswords("/2020/inputs/day-2.txt")
    println("Solution to Day 2, Part 1 is '${solveDayTwoPartOne(passwords)}'")
    println("Solution to Day 2, Part 2 is '${solveDayTwoPartTwo(passwords)}'")
}
