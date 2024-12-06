package dev.nhoffmann.aoc.y2024.day5

import com.google.common.collect.HashMultimap

class Rules(rules: List<String>) {
    private val hasToOccurBeforeByNumber = HashMultimap.create<Int, Int>()

    companion object {
        private val ruleStructure = Regex("(\\d+)\\|(\\d+)")
    }

    init {
        rules.forEach { rawRule ->
            val searchResult = ruleStructure.find(rawRule)
            require(searchResult != null) { "There is no rule structure in $rawRule" }
            val (x, y) = searchResult.destructured
            hasToOccurBeforeByNumber.put(x.toInt(), y.toInt())
        }
    }

    fun getHasToOccurBefore(key: Int): Set<Int> {
        return hasToOccurBeforeByNumber.get(key)
    }
}