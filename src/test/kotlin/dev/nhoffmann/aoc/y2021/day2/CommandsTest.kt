package dev.nhoffmann.aoc.y2021.day2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CommandsTest {

    @Test
    fun commandsFromStringsTest() {
        val plainCommands = listOf("forward 5", "down 7", "up 4")
        val resultCommands = commandsFromStrings(plainCommands)

        val forwardCommand = Command(Direction.FORWARD, 5)
        val downCommand = Command(Direction.DOWN, 7)
        val upCommand = Command(Direction.UP, 4)

        Assertions.assertThat(resultCommands)
            .isNotEmpty
            .containsExactly(forwardCommand, downCommand, upCommand)
    }
}
