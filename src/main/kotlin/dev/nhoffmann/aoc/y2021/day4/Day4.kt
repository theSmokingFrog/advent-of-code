package dev.nhoffmann.aoc.y2021.day4

import dev.nhoffmann.aoc.load

fun extractNumbersToBeDrawn(rawBingoData: List<String>) = rawBingoData.first().splitToSequence(",").map { it.toInt() }.toList()

fun extractBingoFields(rawBingoData: List<String>) = rawBingoData.subList(2, rawBingoData.size).chunked(6).map { BingoField(it) }

fun solveDay4PartOne(list: List<String>): Int {
    val numbersToBeDrawn = extractNumbersToBeDrawn(list)
    val bingoFields = extractBingoFields(list)

    val drawnNumbers: MutableList<Int> = mutableListOf()
    var currentIndex = 0
    while (bingoFields.none { it.isWon(drawnNumbers) }) {
        drawnNumbers.add(numbersToBeDrawn[currentIndex])
        currentIndex += 1
    }

    val lastDrawn = drawnNumbers.last()
    val bingoSum = bingoFields.first { it.isWon(drawnNumbers) }.unmarkedNumbers(drawnNumbers).sum()

    return lastDrawn * bingoSum
}

fun solveDay4PartTwo(list: List<String>): Int {
    val numbersToBeDrawn = extractNumbersToBeDrawn(list)
    val bingoFields = extractBingoFields(list)

    val drawnNumbers: MutableList<Int> = mutableListOf()
    var currentIndex = 0
    while (bingoFields.all { it.isWon(drawnNumbers) }.not()) {
        drawnNumbers.add(numbersToBeDrawn[currentIndex])
        currentIndex += 1
    }

    val lastDrawn = drawnNumbers.last()
    val bingoSum = bingoFields.first { it.wonWith == drawnNumbers.last() }.unmarkedNumbers(drawnNumbers).sum()
    return bingoSum * lastDrawn
}

fun main() {
    val loadedData = load("/inputs/2021/day-4.txt")
    println("Solution to Day 4, Part 1 is '${solveDay4PartOne(loadedData)}'")
    println("Solution to Day 4, Part 2 is '${solveDay4PartTwo(loadedData)}'")
}
