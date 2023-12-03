package dev.nhoffmann.aoc.y2023.day2

data class Thresholds(val redCubes: Int, val greenCubes: Int, val blueCubes: Int) {
    fun byString(string: String): Int {
        return when (string) {
            "red" -> redCubes
            "blue" -> blueCubes
            "green" -> greenCubes
            else -> throw RuntimeException("This must never occur.")
        }
    }
}
