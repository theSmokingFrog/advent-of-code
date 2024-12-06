package dev.nhoffmann.aoc.y2024.day6

class Guard(private var currentLocation: Point, private val maxSize: Point) {
    private val visitedLocations = mutableSetOf(currentLocation)
    private var facingDirection = Direction.UP

    fun takeTurn(obstacles: Set<Obstacle>) {
        if (facingObstacle(obstacles)) {
            turnRight()
        } else {
            move()
        }
    }

    private fun facingObstacle(obstacles: Set<Obstacle>): Boolean {
        val nextField = nextField()
        return obstacles.any { it.location == nextField }
    }

    private fun turnRight() {
        val entries = Direction.entries
        facingDirection = entries[(entries.indexOf(facingDirection) + 1) % entries.size]
    }

    private fun move() {
        currentLocation = nextField()
        if (isInsideGameBoard()) {
            visitedLocations.add(currentLocation)
        }
    }

    private fun nextField(): Point {
        return when (facingDirection) {
            Direction.UP -> Point(currentLocation.x, currentLocation.y - 1)
            Direction.RIGHT -> Point(currentLocation.x + 1, currentLocation.y)
            Direction.DOWN -> Point(currentLocation.x, currentLocation.y + 1)
            Direction.LEFT -> Point(currentLocation.x - 1, currentLocation.y)
        }
    }

    fun visitedLocationsCount(): Int {
        return visitedLocations.size
    }

    fun isInsideGameBoard(): Boolean {
        return currentLocation.x in 0..maxSize.x && currentLocation.y in 0..maxSize.y
    }
}