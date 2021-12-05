package dev.nhoffmann.aoc.y2021.day5

data class Line(val from: Point, val to: Point) {
    companion object {
        private val LINE_REGEX = Regex("""^(\d+),(\d+) -> (\d+),(\d+)$""")

        fun from(ventDataLine: String): Line {
            val (x1, y1, x2, y2) = LINE_REGEX.find(ventDataLine)!!.destructured
            return Line(Point(x1.toInt(), y1.toInt()), Point(x2.toInt(), y2.toInt()))
        }
    }

    fun toPoints(): List<Point> {
        return when {
            isHorizontal() -> xRange().map { Point(it, from.yCoordinate) }
            isVertical() -> yRange().map { Point(from.xCoordinate, it) }
            else -> xRange().indices.map { Point(xRange()[it], yRange()[it]) }
        }
    }

    private fun range(fromCoordinate: Int, toCoordinate: Int): List<Int> {
        return if (fromCoordinate < toCoordinate) {
            (fromCoordinate..toCoordinate).toList()
        } else {
            (toCoordinate..fromCoordinate).toList().reversed()
        }
    }

    private fun xRange(): List<Int> = range(from.xCoordinate, to.xCoordinate)

    private fun yRange(): List<Int> = range(from.yCoordinate, to.yCoordinate)

    fun isHorizontal(): Boolean {
        return from.yCoordinate == to.yCoordinate
    }

    fun isVertical(): Boolean {
        return from.xCoordinate == to.xCoordinate
    }

    override fun toString(): String {
        return "$from -> $to"
    }
}
