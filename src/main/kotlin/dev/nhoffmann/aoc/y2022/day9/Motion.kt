package dev.nhoffmann.aoc.y2022.day9

class Motion private constructor(val direction: String, val steps: Int) {
    companion object Factory {
        private val motionRegex = Regex("""^(\w) (\d+)$""")

        fun of(string: String): Motion {
            return motionRegex.matchEntire(string)!!.destructured.let { Motion(it.component1(), it.component2().toInt()) }
        }
    }

    override fun toString(): String {
        return "Motion(direction='$direction', value=$steps)"
    }


}
