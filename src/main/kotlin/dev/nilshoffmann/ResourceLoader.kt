package dev.nilshoffmann

fun load(pathInResources: String): List<String> = Unit.javaClass.getResourceAsStream(pathInResources).bufferedReader().use { reader -> reader.readLines() }