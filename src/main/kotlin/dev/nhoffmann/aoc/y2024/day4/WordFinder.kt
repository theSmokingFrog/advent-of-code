package dev.nhoffmann.aoc.y2024.day4

import kotlin.math.abs

class WordFinder(private val grid: List<String>) {
    fun count(searchTerm: String): Int {
        val foundStartingLetters = mutableSetOf<Point>()
        val foundEndingLetters = mutableSetOf<Point>()

        // determine coordinates of start and end letters
        for ((rowIndex, row) in grid.withIndex()) {
            for ((colIndex, col) in row.withIndex()) {
                if (col == searchTerm.first()) foundStartingLetters += Point(colIndex, rowIndex)
                if (col == searchTerm.last()) foundEndingLetters += Point(colIndex, rowIndex)
            }
        }
        // lookup valid combinations of Length based on Directions
        val directions = Directions(searchTerm)
        val candidates = mutableSetOf<Pair<Point, Point>>()

        for (startingLetter in foundStartingLetters) {
            for (endingLetter in foundEndingLetters) {
                val differenceBetweenPoints = endingLetter - startingLetter
                if (directions.contains(differenceBetweenPoints)) {
                    candidates += startingLetter to endingLetter
                }
            }
        }

        // Count all Candidates that really provide a solution
        return candidates.map { (start, end) ->
            generateSteps(start, end)
                .zip(searchTerm.asIterable())
                .all { (point, char) -> grid[point.yCoordinate][point.xCoordinate] == char }
        }.count { it }
    }

    private fun generateSteps(start: Point, end: Point): List<Point> {
        val stepList = mutableListOf<Point>()
        var xStart = start.xCoordinate
        var yStart = start.yCoordinate
        val xEnd = end.xCoordinate
        val yEnd = end.yCoordinate

        val xDelta = if (xEnd - xStart != 0) (xEnd - xStart) / abs(xEnd - xStart) else 0
        val yDelta = if (yEnd - yStart != 0) (yEnd - yStart) / abs(yEnd - yStart) else 0

        stepList.add(Point(xStart, yStart))

        while (xStart != xEnd || yStart != yEnd) {
            if (xStart != xEnd) xStart += xDelta
            if (yStart != yEnd) yStart += yDelta
            stepList.add(Point(xStart, yStart))
        }

        return stepList
    }
}
