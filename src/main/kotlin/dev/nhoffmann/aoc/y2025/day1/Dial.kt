package dev.nhoffmann.aoc.y2025.day1

class Dial(var current: Int, val size: Int) {
    var zeroClicks = 0

    fun toRight(value: Int) {
        val rawValue = current + value
        if (rawValue >= size) {
            zeroClicks += (rawValue / size)
        }

        current = rawValue % size
    }

    fun toLeft(value: Int) {
        val leftRotated = current - value
        current = if (leftRotated < 0) {
            zeroClicks += (leftRotated / size) + 1
            (100 + leftRotated) % size
        } else {
            leftRotated
        }
    }
}