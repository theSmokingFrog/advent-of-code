package dev.nhoffmann.aoc.y2023.day5

import dev.nhoffmann.aoc.y2023.day5.IslandIslandAlmanac.MappingType.*

data class SeedData private constructor(
    val id: Long,
    val soil: Long,
    val fertilizer: Long,
    val water: Long,
    val light: Long,
    val temperature: Long,
    val humidity: Long,
    val location: Long,
) {
    companion object Factory {
        fun create(id: Long, almanac: IslandIslandAlmanac): SeedData {
            val soil = almanac.fetchMapping(SEED_TO_SOIL, id)
            val fertilizer = almanac.fetchMapping(SOIL_TO_FERTILIZER, soil)
            val water = almanac.fetchMapping(FERTILIZER_TO_WATER, fertilizer)
            val light = almanac.fetchMapping(WATER_TO_LIGHT, water)
            val temperature = almanac.fetchMapping(LIGHT_TO_TEMPERATURE, light)
            val humidity = almanac.fetchMapping(TEMPERATURE_TO_HUMIDITY, temperature)
            val location = almanac.fetchMapping(HUMIDITY_TO_LOCATION, humidity)

            return SeedData(id, soil, fertilizer, water, light, temperature, humidity, location)
        }
    }
}
