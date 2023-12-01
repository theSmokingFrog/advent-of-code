package dev.nhoffmann.aoc.y2021.day10

import io.github.oshai.kotlinlogging.KotlinLogging
import java.util.*

class Line(private val data: String) {
    companion object {
        private val log = KotlinLogging.logger {}

        private val chunkPairings = mapOf(
            '(' to ')',
            '[' to ']',
            '{' to '}',
            '<' to '>'
        )
    }

    fun findCorruptCharacter(): Char? {
        val chunkInfo = Stack<Char>()
        var invalidChunkBorderChar: Char? = null
        for (it in data) {
            if (it in chunkPairings.keys) {
                chunkInfo.push(it)
            } else if (chunkPairings[chunkInfo.peek()]!! != it) {
                invalidChunkBorderChar = it
                break
            } else {
                chunkInfo.pop()
            }
        }
        return invalidChunkBorderChar
    }

    fun createAutocompleteSequence(): String? {
        val chunkInfo = Stack<Char>()

        try {
            for (it in data) {
                if (it in chunkPairings.keys) {
                    chunkInfo.push(it)
                } else if (chunkPairings[chunkInfo.peek()]!! != it) {
                    throw RuntimeException("This Line is corrupt")
                } else {
                    chunkInfo.pop()
                }
            }
        } catch (ex: RuntimeException) {
            return null
        }

        return chunkInfo.reversed().map { chunkPairings[it] }.joinToString(separator = "")
    }

    override fun toString(): String {
        return "Line(data='$data')"
    }


}
