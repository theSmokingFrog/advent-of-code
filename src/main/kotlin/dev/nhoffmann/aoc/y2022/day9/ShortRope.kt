package dev.nhoffmann.aoc.y2022.day9

class ShortRope : Rope {
    private var head = 0 to 0
    private var tail = 0 to 0
    private var tailPositions = mutableSetOf(0 to 0)

    override fun move(motion: Motion) {
        (0 until motion.steps)
            .forEach { _ ->
                val oldHead = head.copy()
                moveHead(motion.direction)
                letTailFollow(oldHead)
            }
    }

    private fun moveHead(direction: String) {
        head = when (direction) {
            "R" -> head.first + 1 to head.second
            "L" -> head.first - 1 to head.second
            "U" -> head.first to head.second + 1
            "D" -> head.first to head.second - 1
            else -> throw RuntimeException("Motion Unknown")
        }
    }

    private fun letTailFollow(oldHead: Pair<Int, Int>) {
        val safeZone = listOf(-1, 0, 1)

        val xDistance = head.first - tail.first
        val yDistance = head.second - tail.second

        if (xDistance !in safeZone || yDistance !in safeZone) {
            tail = oldHead
        }
        tailPositions.add(tail)
    }

    override fun uniqueTailPositions(): Int {
        return tailPositions.size
    }
}
