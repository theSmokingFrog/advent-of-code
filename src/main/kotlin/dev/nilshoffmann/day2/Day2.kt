package dev.nilshoffmann.day2

import dev.nilshoffmann.load

fun solvePartOne(pPasswords: List<Password>): Int {
    return pPasswords.filter { it.partOnePolicyValid() }.size
}

fun solvePartTwo(pPasswords: List<Password>): Int {
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
    val passwords = loadPasswords("/inputs/day-2.txt")
    println("Solution to Day 2, Part 1 is '${solvePartOne(passwords)}'")
    println("Solution to Day 2, Part 2 is '${solvePartTwo(passwords)}'")
}
