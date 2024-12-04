package dev.nhoffmann.aoc.y2015.day3

class Santa {
    private var xPos = 0;
    private var yPos = 0;
    private val visitedLocations = mutableListOf(0 to 0)

    fun move(instruction: Char) {
        when (instruction) {
            '>' -> xPos += 1
            '<' -> xPos -= 1
            '^' -> yPos += 1
            'v' -> yPos -= 1
            else -> throw RuntimeException("Unexpected Charater '$instruction' found!")
        }
        visitedLocations.add(xPos to yPos)
    }

    fun uniquelyVisitedLocations(): List<Pair<Int, Int>> {
        return visitedLocations.distinct()
    }
}
