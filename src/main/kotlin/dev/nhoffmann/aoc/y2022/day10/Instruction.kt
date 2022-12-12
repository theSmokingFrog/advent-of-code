package dev.nhoffmann.aoc.y2022.day10

data class Instruction private constructor(val representation: String, val value: Int?) {
    companion object Factory {
        private val regex = Regex("""^(\w{4})( -?\d+)?""")

        fun of(string: String): Instruction {
            return regex.matchEntire(string)!!.destructured.let {
                Instruction(it.component1(), it.component2().trim().toIntOrNull())
            }
        }
    }
}
