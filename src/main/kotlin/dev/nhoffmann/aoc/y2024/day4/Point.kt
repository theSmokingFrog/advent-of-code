package dev.nhoffmann.aoc.y2024.day4

data class Point(val xCoordinate: Int, val yCoordinate: Int) {
    override fun toString(): String {
        return "[X:$xCoordinate Y:$yCoordinate]"
    }

    operator fun minus(other: Point): Point {
        return Point(xCoordinate - other.xCoordinate, yCoordinate - other.yCoordinate)
    }
}
