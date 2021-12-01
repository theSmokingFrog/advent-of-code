package dev.nhoffmann.aoc

fun load(pathInResources: String): List<String> = Unit.javaClass.getResourceAsStream(pathInResources).bufferedReader().use { reader -> reader.readLines() }

fun loadInt(pathInResources: String): List<Int> = load(pathInResources).map { it.toInt() }

fun loadLong(pathInResources: String): List<Long> = load(pathInResources).map { it.toLong() }
