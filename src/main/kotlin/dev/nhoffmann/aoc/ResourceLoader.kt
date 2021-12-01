package dev.nhoffmann.aoc

import java.io.FileNotFoundException
import java.util.*

fun load(pathInResources: String): List<String> {
    val resourceAsStream = Optional.ofNullable(Unit.javaClass.getResourceAsStream(pathInResources))
        .orElseThrow { FileNotFoundException("File for Resource at $pathInResources could not be found!") }

    return resourceAsStream.bufferedReader().readLines()
}

fun loadInt(pathInResources: String): List<Int> = load(pathInResources).map { it.toInt() }

fun loadLong(pathInResources: String): List<Long> = load(pathInResources).map { it.toLong() }
