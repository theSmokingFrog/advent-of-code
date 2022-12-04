package dev.nhoffmann.aoc.y2022.day3

class Item(private val definition: Char) {
    fun toPriority(): Int {
        return if (definition.isUpperCase()) {
            definition.code - 38
        } else {
            definition.code - 96
        }
    }

    override fun toString(): String {
        return "Item(definition=$definition)"
    }


}
