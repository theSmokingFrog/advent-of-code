package dev.nhoffmann.aoc.y2020.day5

class SeatID(private val encodedSeatID: String) {
    fun asInt(): Int {
        val rowId = idFromEncodedString(encodedSeatID.take(7), 0..127)
        val columnId = idFromEncodedString(encodedSeatID.takeLast(3), 0..7)

        return (rowId * 8) + columnId
    }

    private fun idFromEncodedString(encodedId: String, idRange: IntRange): Int {
        val centerId = idRange.elementAt(idRange.count() / 2)

        return when (encodedId.take(1)) {
            "F", "L" -> idFromEncodedString(encodedId.substring(1), idRange.first..centerId)
            "B", "R" -> idFromEncodedString(encodedId.substring(1), centerId..idRange.last)
            else -> idRange.first
        }
    }

}
