package dev.nhoffmann.aoc.y2020.day7

import dev.nhoffmann.aoc.load

fun solveDay7PartOne(lines: List<String>, colorToContain: String): Int {
    val bags = Bag.createFromSentences(lines)
    return bags.values.count { it.canContain(colorToContain, bags) }
}

fun solveDay7PartTwo(lines: List<String>, colorToCountContained: String): Int {
    val bags = Bag.createFromSentences(lines)
    return bags[colorToCountContained]!!.countContainedBags(bags)
}

fun main() {
    val bagDefinitions = load("/2020/inputs/day-7.txt")
    println("Solution to Day 7, Part 1 is '${solveDay7PartOne(bagDefinitions, "shiny gold")}'")
    println("Solution to Day 7, Part 2 is '${solveDay7PartTwo(bagDefinitions, "shiny gold")}'")
}
