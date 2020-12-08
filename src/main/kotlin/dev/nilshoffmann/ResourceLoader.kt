package dev.nilshoffmann

fun load(pathInResources: String): List<String> = Unit.javaClass.getResourceAsStream(pathInResources).bufferedReader().use { reader -> reader.readLines() }

fun loadNumbers(pathInResources: String): List<Int> = load(pathInResources).map { Integer.parseInt(it) }