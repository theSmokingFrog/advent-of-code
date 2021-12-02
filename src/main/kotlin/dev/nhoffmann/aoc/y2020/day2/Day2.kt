package dev.nhoffmann.aoc.y2020.day2

import dev.nhoffmann.aoc.load

fun solveDayTwoPartOne(pPasswords: List<Password>): Int {
    return pPasswords.count(Password::partOnePolicyValid)
}

fun solveDayTwoPartTwo(pPasswords: List<Password>): Int {
    return pPasswords.count(Password::partTwoPolicyValid)
}

fun parseRawPasswords(rawPasswords: List<String>): List<Password> {
    return rawPasswords.map(Password.Companion::of)
}

fun main() {
    val passwords = parseRawPasswords(load("/inputs/2020/day-2.txt"))
    println("Solution to Day 2, Part 1 is '${solveDayTwoPartOne(passwords)}'")
    println("Solution to Day 2, Part 2 is '${solveDayTwoPartTwo(passwords)}'")
}
