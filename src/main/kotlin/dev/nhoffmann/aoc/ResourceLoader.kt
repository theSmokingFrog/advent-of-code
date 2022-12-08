package dev.nhoffmann.aoc

import java.io.FileNotFoundException
import java.io.InputStream
import java.util.*

private fun String.asStreamResource(): InputStream {
    return Optional.ofNullable(Unit.javaClass.getResourceAsStream(this))
        .orElseThrow { FileNotFoundException("File for Resource at $this could not be found!") }
}

fun load(pathInResources: String): List<String> = pathInResources.asStreamResource().bufferedReader().readLines()

fun loadAsSingle(pathInResources: String): String = pathInResources.asStreamResource().bufferedReader().readText().trim()

fun loadInt(pathInResources: String): List<Int> = load(pathInResources).map { it.toInt() }

fun loadLong(pathInResources: String): List<Long> = load(pathInResources).map { it.toLong() }
