package dev.nhoffmann.aoc.y2023.day5

class IslandIslandAlmanac(rawAlmanac: String) {
    val seedIds: List<Long>
    private val mappingsByType: Map<MappingType, List<AlmanacMapping>>

    init {
        val sections = rawAlmanac.split("\n\n")
        seedIds = sections[0].split(":").last().trim().split(" ").map { it.toLong() }
        mappingsByType = sections
            .drop(1)
            .map { it.split("\n") }
            .associateBy({ it[0] }, { it.drop(1) })
            .mapKeys { MappingType.byId(it.key.split(" ")[0].trim()) }
            .mapValues { entry ->
                entry.value.map { innerValues ->
                    innerValues
                        .split(" ")
                        .map { it.toLong() }
                }
                    .map { AlmanacMapping(it[0], it[1], it[2]) }
            }
    }

    fun fetchMapping(type: MappingType, value: Long): Long {
        val chosenMappings = mappingsByType[type] ?: throw RuntimeException("Could not match Mappings")
        return chosenMappings.mapNotNull { it.get(value) }.let {
            if (it.isEmpty()) {
                value
            } else {
                it.first()
            }
        }
    }

    enum class MappingType(val id: String) {
        SEED_TO_SOIL("seed-to-soil"),
        SOIL_TO_FERTILIZER("soil-to-fertilizer"),
        FERTILIZER_TO_WATER("fertilizer-to-water"),
        WATER_TO_LIGHT("water-to-light"),
        LIGHT_TO_TEMPERATURE("light-to-temperature"),
        TEMPERATURE_TO_HUMIDITY("temperature-to-humidity"),
        HUMIDITY_TO_LOCATION("humidity-to-location");

        companion object {
            fun byId(id: String): MappingType {
                return entries.find { it.id == id } ?: throw RuntimeException("Could not find Mapping for '$id'")
            }
        }
    }
}
