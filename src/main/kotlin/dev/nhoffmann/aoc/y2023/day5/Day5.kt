package dev.nhoffmann.aoc.y2023.day5

import dev.nhoffmann.aoc.loadAsSingle

fun solveDay5PartOne(rawAlmanac: String): Long {
    val almanac = IslandIslandAlmanac(rawAlmanac)
    val seedData = almanac.seedIds.map { SeedData.create(it, almanac) }

    return seedData.minOf { it.location }
}

fun solveDay5PartTwo(rawAlmanac: String): Long {
    val almanac = IslandIslandAlmanac(rawAlmanac)

    // This inadvertently dies with an OutOfMemoryError. And I have no idea on how to solve that.
    val seedIds = almanac.seedIds.chunked(2).map { it[0]..it[0] + it[1] }
    val flat = seedIds.map { it.chunked(25000) }.flatten()
    return flat.asSequence().map { it.map { n -> SeedData.create(n, almanac) } }.map { it.minOf { s -> s.location } }.toList().min()
}

fun main() {
    val loadedData = loadAsSingle("/inputs/2023/day-5.txt")
    println("Solution to Day 5, Part 1 is '${solveDay5PartOne(loadedData)}'")
    println("Solution to Day 5, Part 2 is '${solveDay5PartTwo(loadedData)}'")
}
