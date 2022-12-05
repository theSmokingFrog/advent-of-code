package dev.nhoffmann.aoc.y2022.day5

data class Instruction private constructor(val crateAmount: Int, val sourceStack: Int, val targetStack: Int) {
    companion object Factory {
        private val INSTRUCTION_REGEX = Regex("""move (\d+) from (\d+) to (\d+)""");
        fun createFrom(rawInstructions: String): List<Instruction> {
            return INSTRUCTION_REGEX.findAll(rawInstructions)
                .map { it.destructured }
                .map {
                    Instruction(
                        crateAmount = it.component1().toInt(),
                        sourceStack = it.component2().toInt(),
                        targetStack = it.component3().toInt()
                    )
                }
                .toList()
        }
    }

    override fun toString(): String {
        return "Instruction(Move '$crateAmount' Crates from Stack '$sourceStack' to Stack '$targetStack‘)"
    }
}
