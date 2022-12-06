package dev.nhoffmann.aoc.y2022.day6

class Signal(raw: String) {
    val value: String

    init {
        value = raw.trim()
    }

    override fun toString(): String {
        return "Signal(value='$value')"
    }

    fun findMarkerStartPosition(markerSize: Int): Int {
        return value.windowedSequence(markerSize, partialWindows = false) { it.toSet().size }
            .withIndex()
            .first { it.value == markerSize }
            .index + markerSize
    }

}
