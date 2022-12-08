package dev.nhoffmann.aoc.y2022.day7

class FileTree(val name: String, val parent: FileTree? = null) {
    val directories = mutableListOf<FileTree>()
    val files = mutableListOf<File>()

    private fun localSize(): Int = this.files.sumOf { it.size }

    fun absoluteSize(): Int {
        return directories.sumOf { it.absoluteSize() } + localSize()
    }

    fun sizes(): List<Int> {
        return directories.map { it.sizes() }
            .flatten()
            .toMutableList()
            .also { it.add(absoluteSize()) }
    }

    override fun toString(): String {
        return "FileTree(name='$name')"
    }


}
