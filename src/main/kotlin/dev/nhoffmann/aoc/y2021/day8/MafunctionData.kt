package dev.nhoffmann.aoc.y2021.day8

private fun <K, V> Map<K, V>.firstKeyByValue(lookupValue: V): K = entries.first { it.value == lookupValue }.key

private infix fun String.disjointWith(other: String): String = filter { it !in other }

private fun String.sorted(): String = toCharArray().sorted().joinToString("")

private fun String.containsAll(other: String): Boolean = other.all { it in this }

private fun Map<String, SevenSegmentValue>.unknownValues(): Map<String, SevenSegmentValue> = filterValues { it == SevenSegmentValue.UNKNOWN }

private fun <K, V> Map<K, V>.firstKey() = entries.first().key

class MalfunctionData(originalData: String) {
    private val fourDigitDisplay: List<String>
    private val signals: List<String>
    private val mappedSignals: Map<String, SevenSegmentValue>

    init {
        val splitValue = originalData.split('|')
        signals = splitValue.first().trim().split(" ")
        mappedSignals = mapSignals()
        fourDigitDisplay = splitValue.last().trim().split(" ").map { it.sorted() }
    }

    private fun mapSignals(): Map<String, SevenSegmentValue> {
        val signalToSegmentValue = signals.associate { it.sorted() to SevenSegmentValue.findUniqueByActiveLines(it) }.toMutableMap()
        mapSix(signalToSegmentValue)
        mapNine(signalToSegmentValue)
        mapFive(signalToSegmentValue)
        mapZero(signalToSegmentValue)
        mapTwo(signalToSegmentValue)
        mapThree(signalToSegmentValue)

        return signalToSegmentValue
    }

    private fun mapByDisjoint(input: MutableMap<String, SevenSegmentValue>, firstSegment: SevenSegmentValue, secondSegment: SevenSegmentValue, resultValue: SevenSegmentValue) {
        val eight = input.firstKeyByValue(firstSegment)
        val seven = input.firstKeyByValue(secondSegment)
        val disjointed = eight disjointWith seven
        val sixKey = input.unknownValues().filterKeys { it.containsAll(disjointed) }.firstKey()
        input[sixKey] = resultValue
    }

    private fun mapSix(signalToSegmentValue: MutableMap<String, SevenSegmentValue>) {
        mapByDisjoint(signalToSegmentValue, SevenSegmentValue.EIGHT, SevenSegmentValue.SEVEN, SevenSegmentValue.SIX)
    }

    private fun mapNine(signalToSegmentValue: MutableMap<String, SevenSegmentValue>) {
        val nineKey = signalToSegmentValue.unknownValues()
            .filterKeys { it.containsAll(signalToSegmentValue.firstKeyByValue(SevenSegmentValue.ONE)) }
            .filterKeys { it.containsAll(signalToSegmentValue.firstKeyByValue(SevenSegmentValue.FOUR)) }
            .entries.first().key
        signalToSegmentValue[nineKey] = SevenSegmentValue.NINE
    }

    private fun mapFive(signalToSegmentValue: MutableMap<String, SevenSegmentValue>) {
        mapByDisjoint(signalToSegmentValue, SevenSegmentValue.NINE, SevenSegmentValue.SEVEN, SevenSegmentValue.FIVE)
    }

    private fun mapZero(signalToSegmentValue: MutableMap<String, SevenSegmentValue>) {
        val zeroKey = signalToSegmentValue.unknownValues().filterKeys { it.length == SevenSegmentValue.ZERO.defaultSignalPattern.length }.firstKey()
        signalToSegmentValue[zeroKey] = SevenSegmentValue.ZERO
    }

    private fun mapTwo(signalToSegmentValue: MutableMap<String, SevenSegmentValue>) {
        mapByDisjoint(signalToSegmentValue, SevenSegmentValue.EIGHT, SevenSegmentValue.FIVE, SevenSegmentValue.TWO)
    }

    private fun mapThree(signalToSegmentValue: MutableMap<String, SevenSegmentValue>) {
        val threeKey = signalToSegmentValue.unknownValues().firstKey()
        signalToSegmentValue[threeKey] = SevenSegmentValue.THREE
    }

    fun fixedNumericValue(): Int {
        val rawValue = fourDigitDisplay.map { mappedSignals[it]!!.numericValue }.joinToString("")
        return rawValue.toInt()
    }

    override fun toString(): String {
        return "$signals | $fourDigitDisplay"
    }


}
