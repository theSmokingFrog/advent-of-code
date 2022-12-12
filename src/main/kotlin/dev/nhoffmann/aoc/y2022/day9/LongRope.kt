package dev.nhoffmann.aoc.y2022.day9

class LongRope : Rope {
    companion object {
        private val SAFE_ZONE = listOf(-1, 0, 1)
        private val VALID_MOVEMENTS = -1..1
    }

    private val knots = MutableList(10) { 0 to 0 }
    private var tailPositions = mutableSetOf(0 to 0)

    override fun move(motion: Motion) {
        (0 until motion.steps)
            .forEach { _ ->
                moveHead(motion.direction)
                (0 until knots.lastIndex).forEach { moveKnotsbyIndex(it) }
                tailPositions.add(knots.last())
            }
    }

    private fun moveKnotsbyIndex(knotsIndex: Int) {
        val knotOne = knots[knotsIndex]
        val knotTwo = knots[knotsIndex + 1]

        val xDistance = knotOne.first - knotTwo.first
        val yDistance = knotOne.second - knotTwo.second

        if (xDistance !in SAFE_ZONE || yDistance !in SAFE_ZONE) {
            knots[knotsIndex + 1] = (knotTwo.first + xDistance.coerceIn(VALID_MOVEMENTS)) to (knotTwo.second + yDistance.coerceIn(VALID_MOVEMENTS))
        }
    }

    private fun moveHead(direction: String) {
        knots[0] = when (direction) {
            "R" -> knots[0].first + 1 to knots[0].second
            "L" -> knots[0].first - 1 to knots[0].second
            "U" -> knots[0].first to knots[0].second + 1
            "D" -> knots[0].first to knots[0].second - 1
            else -> throw RuntimeException("Motion Unknown")
        }
    }

    override fun uniqueTailPositions(): Int {
        return tailPositions.size
    }

    override fun toString(): String {
        return "LongRope(knots=$knots)"
    }


}
