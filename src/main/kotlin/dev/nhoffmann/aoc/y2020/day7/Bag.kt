package dev.nhoffmann.aoc.y2020.day7

class Bag(private val color: String, definition: String) {
    companion object {
        fun createFromSentences(lines: List<String>): Map<String, Bag> {
            val colorAndDefinitionGroups = """^(.+) bags contain(.+)$""".toRegex()
            return lines.map {
                val (color, definition) = colorAndDefinitionGroups.find(it)!!.destructured
                color to Bag(color, definition)
            }.toMap()
        }
    }

    private var containableCountByColor: Map<String, Int> = if (definition.contains("no other")) {
        emptyMap()
    } else {
        val singleDefinition = """(\d)(.*)bags?\.?""".toRegex()
        definition
            .split(",")
            .map { it.trim() }
            .map {
                val (count, color) = singleDefinition.find(it)!!.destructured
                color.trim() to Integer.parseInt(count)
            }.toMap()
    }

    fun canContain(color: String, allBags: Map<String, Bag>): Boolean {
        return when {
            containableCountByColor.isEmpty() -> false
            containableCountByColor.containsKey(color) -> true
            else -> containableCountByColor.keys.map { allBags[it] }.any { it!!.canContain(color, allBags) }
        }
    }

    fun countContainedBags(allBags: Map<String, Bag>): Int {
        return containableCountByColor.entries.map { it.value + it.value * allBags[it.key]!!.countContainedBags(allBags) }.sum()
    }

    override fun toString(): String {
        return "$color -> [$containableCountByColor]"
    }

}
