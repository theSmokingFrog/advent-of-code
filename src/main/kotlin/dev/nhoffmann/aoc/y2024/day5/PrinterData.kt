package dev.nhoffmann.aoc.y2024.day5

class PrinterData(rawData: List<String>) {
    private val emptyLineIndex = rawData.indexOf("")
    val rules = Rules(rawData.slice(0..<emptyLineIndex))
    val updates = rawData
        .slice(emptyLineIndex + 1..<rawData.size)
        .map { update -> update.split(",").map { it.toInt() } }
}
