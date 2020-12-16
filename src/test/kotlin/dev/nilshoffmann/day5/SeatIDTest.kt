package dev.nilshoffmann.day5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SeatIDTest {
    private val encodedSeatIdToIntValue: Map<SeatID, Int> = mapOf(
        SeatID("BFFFBBFRRR") to 567,
        SeatID("FFFBBBFRRR") to 119,
        SeatID("BBFFBBFRLL") to 820
    )

    @Test
    fun asInt() {
        encodedSeatIdToIntValue.forEach { (seatID, expectedIntValue) -> assertEquals(seatID.asInt(), expectedIntValue) }
    }
}