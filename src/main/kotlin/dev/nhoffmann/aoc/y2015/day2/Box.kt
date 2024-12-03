package dev.nhoffmann.aoc.y2015.day2

class Box(rawDimensions: String) {
    private val length: Int
    private val width: Int
    private val height: Int

    init {
        rawDimensions.split("x").also { (l, w, h) ->
            length = l.toInt();
            width = w.toInt();
            height = h.toInt()
        }
    }

    fun calcRequiredWrappingPaper(): Int {
        val sidesArea = listOf(length * width, width * height, height * length)
        return sidesArea.sumOf { it * 2 } + sidesArea.min()
    }

    fun calcRibbonLength(): Int {
        val bowLength = length * width * height;

        val sides = listOf(length, width, height).sorted()
        return sides[0] * 2 + sides[1] * 2 + bowLength
    }

    override fun toString(): String {
        return "Box(length=$length, width=$width, height=$height)"
    }


}
