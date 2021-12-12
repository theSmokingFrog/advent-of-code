package dev.nhoffmann.aoc.y2021.day9

private fun List<String>.byCoordinates(lookupRow: Int, lookupCol: Int): Char? {
    return try {
        this[lookupRow][lookupCol]
    } catch (e: Exception) {
        null
    }
}

class HeightMap(rawHeightMap: List<String>) {
    private var risks: List<Risk> = listOf<Risk>().toMutableList()

    init {
        for (row in rawHeightMap.indices) {
            for (col in rawHeightMap[row].indices) {
                val currentNum = rawHeightMap[row][col]
                val top = rawHeightMap.byCoordinates(row - 1, col)
                val bottom = rawHeightMap.byCoordinates(row + 1, col)
                val right = rawHeightMap.byCoordinates(row, col + 1)
                val left = rawHeightMap.byCoordinates(row, col - 1)
                risks = risks + Risk(currentNum, top, bottom, right, left)
            }
        }
    }

    fun lowPoints(): List<Risk> {
        return risks.filter { it.isLowPoint() }
    }
}
