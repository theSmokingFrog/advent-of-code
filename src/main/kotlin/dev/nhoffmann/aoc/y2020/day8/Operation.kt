package dev.nhoffmann.aoc.y2020.day8

enum class Operation(private val identifier: String) {
    ACCUMULATE("acc"),
    JUMP("jmp"),
    NO_OP("nop");

    companion object {
        fun ofIdentifier(identifier: String): Operation {
            return values().first { it.identifier == identifier }
        }
    }

    override fun toString(): String {
        return identifier
    }
}
