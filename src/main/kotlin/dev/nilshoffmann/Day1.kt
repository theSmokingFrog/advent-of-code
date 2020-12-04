package dev.nilshoffmann

/**
 * After saving Christmas five years in a row, you've decided to take a vacation at a
 * nice resort on a tropical island. Surely, Christmas will go on without you.
 *
 * The tropical island has its own currency and is entirely cash-only. The gold coins
 * used there have a little picture of a starfish; the locals just call them stars.
 * None of the currency exchanges seem to have heard of them, but somehow, you'll need
 * to find fifty of these coins by the time you arrive so you can pay the deposit on your room.
 *
 * To save your vacation, you need to get all fifty stars by December 25th.
 *
 * Collect stars by solving puzzles. Two puzzles will be made available on each day
 * in the Advent calendar; the second puzzle is unlocked when you complete the first.
 * Each puzzle grants one star. Good luck!
 */
class Day1 {
    private fun readInputData(): List<Int> {
        javaClass.getResourceAsStream("/inputs/input-day-1.txt").bufferedReader().use { reader ->
            println(">> Reading Inputs")
            val listOfNumbers = reader.readLines().map { Integer.parseInt(it) }
            println(">> Found ${listOfNumbers.size} numbers...")
            return listOfNumbers
        }
    }


    /**
     * Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle input);
     * apparently, something isn't quite adding up.
     *
     * Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.
     *
     * For example, suppose your expense report contained the following:
     *
     * 1721
     * 979
     * 366
     * 299
     * 675
     * 1456
     * In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
     *
     * Of course, your expense report is much larger. Find the two entries that sum to 2020; what do you get if you multiply them together?
     */
    fun solveQuizOne() {
        println("Solving Day 1, Quiz 1...")
        val listOfNumbers = readInputData()
        println(">> Creating cartesian product of input data...")
        val cartesianProduct = listOfNumbers.map { num -> listOfNumbers.map { num to it } }.flatten()
        println(">> Created ${cartesianProduct.size} combinations; Filtering for Pairs summing up to '2020'...")
        val eq2020 = cartesianProduct.filter { pair -> pair.first + pair.second == 2020 }
        println(">> Found ${eq2020.size} pairs; Printing Results:")
        eq2020.forEach { println("$it => ${it.first * it.second}") }
        println("###################################################")
    }

    /**
     * The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had
     * left over from a past vacation. They offer you a second one if you can find three numbers in your expense
     * report that meet the same criteria.
     *
     * Using the above example again, the three entries that sum to 2020 are 979, 366, and 675.
     * Multiplying them together produces the answer, 241861950.
     *
     * In your expense report, what is the product of the three entries that sum to 2020?
     */
    fun solveQuizTwo() {
        println("Solving Day 1, Quiz 2...")
        val listOfNumbers = readInputData()
        println("Creating Cartesian Product two times...")
        val cartesianProduct = listOfNumbers
            .flatMap { num -> listOfNumbers.map { num to it } }
            .flatMap { pair -> listOfNumbers.map { Triple(pair.first, pair.second, it) } }
        println(">> Created ${cartesianProduct.size} combinations; Filtering for triples summing up to '2020'...")
        val eq2020 = cartesianProduct.filter { triple -> triple.first + triple.second + triple.third == 2020 }
        println(">> Found ${eq2020.size} pairs; Printing Results:")
        eq2020.forEach { println("$it => ${it.first * it.second * it.third}") }
        println("###################################################")
    }
}

fun main() {
    val day1 = Day1()
    day1.solveQuizOne()
    day1.solveQuizTwo()
}

