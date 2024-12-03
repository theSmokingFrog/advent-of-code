package dev.nhoffmann.aoc.y2024.day3

import dev.nhoffmann.aoc.loadAsSingle

fun solveDay3PartOne(scrambledInstructions: String): Long {
    val multiplyInstructions = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)")
    val foundMultiplyInstructions = multiplyInstructions.findAll(scrambledInstructions)
    return calculate(foundMultiplyInstructions)
}

fun solveDay3PartTwo(scrambledInstructions: String): Long {
    val validInstructions = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\)")
    val filteredInstructions = filter(validInstructions.findAll(scrambledInstructions))
    return calculate(filteredInstructions)
}

private fun calculate(instructions: Sequence<MatchResult>) = instructions.sumOf {
    it.destructured.let { (l: String, r: String) ->
        l.toLong() * r.toLong()
    }
}

private fun filter(instructions: Sequence<MatchResult>): Sequence<MatchResult> {
    val result = mutableListOf<MatchResult>()
    var skip = false

    for (match in instructions) {
        when {
            match.value == "don't()" -> skip = true
            match.value == "do()" -> skip = false
            !skip -> result.add(match)
        }
    }

    return result.asSequence()
}

fun main() {
    val loadedData = loadAsSingle("/inputs/2024/day-3.txt")
    println("Solution to Day 3, Part 1 is '${solveDay3PartOne(loadedData)}'")
    println("Solution to Day 3, Part 2 is '${solveDay3PartTwo(loadedData)}'")
}
