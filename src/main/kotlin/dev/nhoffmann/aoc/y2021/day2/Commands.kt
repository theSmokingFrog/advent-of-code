package dev.nhoffmann.aoc.y2021.day2

private val COMMAND_VALUES_REGEX = Regex("""(\w+) (\d+)""")

fun commandsFromStrings(plainCommands: List<String>): List<Command> {
    return plainCommands.asSequence()
        .map { COMMAND_VALUES_REGEX.find(it) }
        .map {
            val (direction, size) = it!!.destructured
            Command(Direction.fromString(direction), size.toInt())
        }
        .toList()
}
