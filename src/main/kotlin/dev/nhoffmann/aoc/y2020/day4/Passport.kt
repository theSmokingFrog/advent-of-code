package dev.nhoffmann.aoc.y2020.day4

import java.util.*

class Passport(private val valuesByBlock: EnumMap<PassportBlock, String>) {

    fun necessaryFieldsPresent(): Boolean {
        return listOf(
            valuesByBlock[PassportBlock.BYR] != null,
            valuesByBlock[PassportBlock.IYR] != null,
            valuesByBlock[PassportBlock.EYR] != null,
            valuesByBlock[PassportBlock.HGT] != null,
            valuesByBlock[PassportBlock.HCL] != null,
            valuesByBlock[PassportBlock.ECL] != null,
            valuesByBlock[PassportBlock.PID] != null
        ).all { it }
    }

    fun fieldsValid(): Boolean {
        return necessaryFieldsPresent() &&
                valuesByBlock.entries.map { it.key.validate(it.value) }.all { it }
    }

    class Builder {
        private val valuesByBlock = EnumMap<PassportBlock, String>(PassportBlock::class.java)

        fun add(block: PassportBlock, value: String) {
            valuesByBlock[block] = value
        }

        fun build() = Passport(valuesByBlock)
    }
}
