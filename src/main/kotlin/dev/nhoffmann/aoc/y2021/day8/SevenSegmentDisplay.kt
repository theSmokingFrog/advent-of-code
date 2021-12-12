package dev.nhoffmann.aoc.y2021.day8

class SevenSegmentDisplay(val config: SevenSegmentValue) {
    companion object {
        fun fromString(configuration: String): SevenSegmentDisplay {
            return SevenSegmentDisplay(SevenSegmentValue.findUniqueByActiveLines(configuration))
        }
    }

    fun value() = config.numericValue
    override fun toString(): String {
        return "SevenSegmentDisplay(config=$config)"
    }


}
