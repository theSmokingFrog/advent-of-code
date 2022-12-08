package dev.nhoffmann.aoc.y2022.day7

class Command(raw: String) {
    val type = raw.substring(0..2).trim()
    val data = raw.substring(3).trim()
    override fun toString(): String {
        return "Command(type='$type', data='$data')"
    }

    companion object Factory {
        fun generateFromString(data: String): List<Command> {
            return data.split("$")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
                .map { Command(it) }
        }
    }
}
