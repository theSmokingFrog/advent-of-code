package dev.nhoffmann.aoc.y2021.day3

import dev.nhoffmann.aoc.load

private fun String.isCharacterDominant(charToCheck: Char): Boolean = count { it == charToCheck } > length.toDouble() / 2

private fun String.toIntFromBinary(): Int = toInt(2)

private fun List<String>.transpose(): List<String> {
    val numberLength = this[0].length
    val transposedNumbers = List(numberLength) { CharArray(size) }
    indices.forEach { rowIdx ->
        for (colIdx in 0 until numberLength) {
            transposedNumbers[colIdx][rowIdx] = this[rowIdx][colIdx]
        }
    }
    return transposedNumbers.map { String(it) }
}

private fun calculateBinaryNumberByDominance(binaryNumbers: List<String>, dominantString: String, uncommonString: String): Int {
    return binaryNumbers.transpose()
        .map { if (it.isCharacterDominant('0')) dominantString else uncommonString }
        .reduce { acc, str -> acc + str }
        .toIntFromBinary()
}

private fun determineOxygenRating(binaryNumbers: List<String>, column: Int = 0): String {
    val char = if (binaryNumbers.transpose()[column].isCharacterDominant('0')) '0' else '1'
    val filteredNumbers = binaryNumbers.filter { it[column] == char }
    return if (filteredNumbers.size == 1) filteredNumbers[0] else determineOxygenRating(filteredNumbers, column + 1)
}

private fun determineCO2ScrubberRating(binaryNumbers: List<String>, column: Int = 0): String {
    val char = if (binaryNumbers.transpose()[column].isCharacterDominant('0')) '1' else '0'
    val filteredNumbers = binaryNumbers.filter { it[column] == char }
    return if (filteredNumbers.size == 1) filteredNumbers[0] else determineCO2ScrubberRating(filteredNumbers, column + 1)
}

fun solveDayThreePartOne(binaryNumbers: List<String>): Int {
    val gammaRate = calculateBinaryNumberByDominance(binaryNumbers, "0", "1")
    val epsilonRate = calculateBinaryNumberByDominance(binaryNumbers, "1", "0")
    return gammaRate * epsilonRate
}


fun solveDayThreePartTwo(binaryNumbers: List<String>): Int {
    val oxygenRating = determineOxygenRating(binaryNumbers)
    val cO2ScrubberRating = determineCO2ScrubberRating(binaryNumbers)

    return oxygenRating.toIntFromBinary() * cO2ScrubberRating.toIntFromBinary()
}

fun main() {
    val loadedData = load("/inputs/2021/day-3.txt")
    println("Solution to Day 3, Part 1 is '${solveDayThreePartOne(loadedData)}'")
    println("Solution to Day 3, Part 2 is '${solveDayThreePartTwo(loadedData)}'")
}
