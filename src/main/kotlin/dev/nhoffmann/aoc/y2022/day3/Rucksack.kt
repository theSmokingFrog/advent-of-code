package dev.nhoffmann.aoc.y2022.day3

class Rucksack(val contents: String) {
    private val firstCompartment: CharArray = contents.toCharArray(0, (contents.length / 2))
    private val secondCompartment: CharArray = contents.toCharArray((contents.length / 2))

    fun findWronglyPackedItem(): Item {
        return Item(firstCompartment.toSet().intersect(secondCompartment.toSet()).first())
    }

    fun findCommonItem(rucksacks: List<Rucksack>): Item {
        var commonContents = this.contents.toSet()

        for (rucksack in rucksacks) {
            commonContents = commonContents.intersect(rucksack.contents.toSet())
        }

        return Item(commonContents.first())

    }

    override fun toString(): String {
        return "Rucksack(firstCompartment=${firstCompartment.contentToString()}, secondCompartment=${secondCompartment.contentToString()})"
    }


}
