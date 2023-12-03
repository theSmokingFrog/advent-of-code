package dev.nhoffmann.aoc.y2023.day2

import dev.nhoffmann.aoc.load

fun solveDay2PartOne(loadedData: List<String>): Int {
    val gameAnalyzer = GameAnalyzer(
        gameRecords = loadedData.map { GameRecord(it) }
    )

    return gameAnalyzer.countImpossibleGames(
        Thresholds(
            redCubes = 12,
            greenCubes = 13,
            blueCubes = 14
        )
    );
}

fun solveDay2PartTwo(loadedData: List<String>): Int {
    val gameAnalyzer = GameAnalyzer(
        gameRecords = loadedData.map { GameRecord(it) }
    )

    return gameAnalyzer.aggregatePower();
}

fun main() {
    val loadedData = load("/inputs/2023/day-2.txt")
    println("Solution to Day 2, Part 1 is '${solveDay2PartOne(loadedData)}'")
    println("Solution to Day 2, Part 2 is '${solveDay2PartTwo(loadedData)}'")
}
