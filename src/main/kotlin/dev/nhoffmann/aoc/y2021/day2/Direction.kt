package dev.nhoffmann.aoc.y2021.day2

enum class Direction {
    FORWARD,
    UP,
    DOWN;

    companion object {
        fun fromString(stringValue: String): Direction = valueOf(stringValue.uppercase())
    }
}
