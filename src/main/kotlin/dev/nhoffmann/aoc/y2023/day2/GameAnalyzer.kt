package dev.nhoffmann.aoc.y2023.day2

class GameAnalyzer(private val gameRecords: List<GameRecord>) {
    fun countImpossibleGames(thresholds: Thresholds): Int {
        return gameRecords
            .filter { it.isPossible(thresholds) }
            .sumOf { it.id }
    }

    fun aggregatePower(): Int {
        return gameRecords.sumOf { it.getPower() }
    }
}
