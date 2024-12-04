package dev.nhoffmann.aoc.y2024.day4

class Directions(searchTerm: String) {
    private val directions: List<Point> = listOf(
        Point(0, -(searchTerm.length - 1)), // UP
        Point(searchTerm.length - 1, -(searchTerm.length - 1)), // UP_RIGHT
        Point(searchTerm.length - 1, 0),  // RIGHT
        Point(searchTerm.length - 1, searchTerm.length - 1),  // DOWN_RIGHT
        Point(0, searchTerm.length - 1),  // DOWN
        Point(-(searchTerm.length - 1), searchTerm.length - 1), // DOWN_LEFT
        Point(-(searchTerm.length - 1), 0), // LEFT
        Point(-(searchTerm.length - 1), -(searchTerm.length - 1)) // UP_LEFT
    );

    fun contains(element: Point): Boolean {
        return directions.contains(element)
    }
}
