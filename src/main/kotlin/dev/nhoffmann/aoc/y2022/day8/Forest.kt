package dev.nhoffmann.aoc.y2022.day8

class Forest(mapOfTrees: List<String>) {
    private val trees: List<Tree>
    private val maxHeight: Int
    private val maxWidth: Int

    init {
        maxHeight = mapOfTrees.lastIndex
        maxWidth = mapOfTrees.first().lastIndex
        trees = mapOfTrees.mapIndexed { y, line -> line.mapIndexed { x, height -> Tree(x, y, height.digitToInt()) } }.flatten()
    }

    private val isTreeInOuterRing: (Tree) -> Boolean = { it.x == 0 || it.x == maxWidth || it.y == 0 || it.y == maxHeight }
    val smallerThanCurrent: (Tree, Tree) -> Boolean = { t1, t2 -> t1.height < t2.height }

    private fun Tree.getTreesOnSameYLevel() = trees.filter { it.y == this.y }

    private fun Tree.getTreesOnSameXLevel() = trees.filter { it.x == this.x }

    fun findTreesVisibleFromEdge(): Int {
        return trees.map { current ->
            if (isTreeInOuterRing(current)) {
                true
            } else {
                checkVisibilityFromEdge(current)
            }
        }.count { it }
    }

    private fun checkVisibilityFromEdge(current: Tree): Boolean {
        val treesOnSameXLevel = current.getTreesOnSameXLevel()
        val visibleOnX = treesOnSameXLevel.filter { it.y < current.y }.all { smallerThanCurrent(it, current) } || treesOnSameXLevel.filter { it.y > current.y }
            .all { smallerThanCurrent(it, current) }

        val treesOnSameYLevel = current.getTreesOnSameYLevel()
        val visibleOnY = treesOnSameYLevel.filter { it.x < current.x }.all { smallerThanCurrent(it, current) } || treesOnSameYLevel.filter { it.x > current.x }
            .all { smallerThanCurrent(it, current) }

        return visibleOnX || visibleOnY
    }


    fun findBestScenicScore(): Int {
        // Look at the monster I created... holy smokes, maybe refactor that hellhole some time in the future...
        return trees.maxOf { current ->
            val (toTop, toBottom) = current.getTreesOnSameXLevel().let { xTrees ->
                xTrees.filter { it.y < current.y }.sortedByDescending { it.y }.takeWhile { it.height < current.height }.let {
                    when {
                        it.isEmpty() -> 0
                        it.last().y == 0 -> it.size
                        else -> it.size + 1
                    }
                } to xTrees.filter { it.y > current.y }.sortedBy { it.y }.takeWhile { it.height < current.height }.let {
                    when {
                        it.isEmpty() -> 0
                        it.last().y == maxHeight -> it.size
                        else -> it.size + 1
                    }
                }
            }

            val (toLeft, toRight) = current.getTreesOnSameYLevel().let { yTrees ->
                yTrees.filter { it.x < current.x }.sortedByDescending { it.x }.takeWhile { it.height < current.height }.let {
                    when {
                        it.isEmpty() -> 0
                        it.last().x == 0 -> it.size
                        else -> it.size + 1
                    }
                } to yTrees.filter { it.x > current.x }.sortedBy { it.x }.takeWhile { it.height < current.height }.let {
                    when {
                        it.isEmpty() -> 0
                        it.last().x == maxWidth -> it.size
                        else -> it.size + 1
                    }
                }
            }

            toTop * toBottom * toLeft * toRight
        }
    }
}
