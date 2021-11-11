package dev.nhoffmann.aoc.y2020.day7

class Bag(private val color: String, definition: String) {
    companion object {
        fun createFromSentences(lines: List<String>): Map<String, Bag> {
            val colorAndDefinitionGroups = """^(.+) bags contain(.+)$""".toRegex()
            return lines.associate {
                val (color, definition) = colorAndDefinitionGroups.find(it)!!.destructured
                color to Bag(color, definition)
            }
        }
    }

    private var containableCountByColor: Map<String, Int> = if (definition.contains("no other")) {
        emptyMap()
    } else {
        val singleDefinition = """(\d)(.*)bags?\.?""".toRegex()
        definition
            .split(",")
            .map { it.trim() }
            .associate {
                val (count, color) = singleDefinition.find(it)!!.destructured
                color.trim() to Integer.parseInt(count)
            }
    }

    fun canContain(color: String, allBags: Map<String, Bag>): Boolean {
        return when {
            containableCountByColor.isEmpty() -> false
            containableCountByColor.containsKey(color) -> true
            else -> containableCountByColor.keys.map { allBags[it] }.any { it!!.canContain(color, allBags) }
        }
    }

    fun countContainedBags(allBags: Map<String, Bag>): Int {
        return containableCountByColor.entries.sumOf { it.value + it.value * allBags[it.key]!!.countContainedBags(allBags) }
    }

    override fun toString(): String {
        return "$color -> [$containableCountByColor]"
    }

}
