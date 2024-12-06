package dev.nhoffmann.aoc.y2024.day6

data class Point(val x: Int, val y: Int) {
    override fun toString(): String {
        return "[X:$x Y:$y]"
    }

    operator fun minus(other: Point): Point {
        return Point(x - other.x, y - other.y)
    }
}
