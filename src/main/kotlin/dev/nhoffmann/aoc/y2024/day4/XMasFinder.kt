package dev.nhoffmann.aoc.y2024.day4

class XMasFinder(private val grid: List<String>) {
    private val validXPairings = listOf('S' to 'M', 'M' to 'S')

    fun count(): Int {
        val foundLetters = findMiddleLetters()

        return foundLetters.map {
            try {
                verifyUpLeftToDownRight(it) && verifyUpRightToDownLeft(it)
            } catch (e: IndexOutOfBoundsException) {
                false
            }
        }.count { it }
    }

    private fun findMiddleLetters(): List<Point> {
        val foundMiddleLetters = mutableListOf<Point>()

        for ((rowIndex, row) in grid.withIndex()) {
            for ((colIndex, col) in row.withIndex()) {
                if (col == 'A') foundMiddleLetters += Point(colIndex, rowIndex)
            }
        }
        return foundMiddleLetters
    }

    private fun verifyPoints(upperChar: Char, lowerChar: Char): Boolean {
        return validXPairings.any { (upperChar to lowerChar) == it }
    }

    private fun verifyUpLeftToDownRight(p: Point): Boolean {
        val upperLeft = grid[p.yCoordinate - 1][p.xCoordinate - 1]
        val lowerRight = grid[p.yCoordinate + 1][p.xCoordinate + 1]

        return verifyPoints(upperLeft, lowerRight)

    }

    private fun verifyUpRightToDownLeft(p: Point): Boolean {
        val upperRight = grid[p.yCoordinate - 1][p.xCoordinate + 1]
        val lowerLeft = grid[p.yCoordinate + 1][p.xCoordinate - 1]

        return verifyPoints(upperRight, lowerLeft);
    }
}