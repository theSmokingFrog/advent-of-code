package dev.nhoffmann.aoc.y2022.day7

class Terminal(commands: List<Command>) {
    companion object {
        private const val FILE_SYSTEM_SIZE = 70_000_000
        private const val UPDATE_REQUIRED_SPACE = 30_000_000
    }

    private val root = FileTree("/")
    private var currentFileTree = root

    init {
        commands.forEach {
            when (it.type) {
                "cd" -> handleChangeDirectory(it.data)
                "ls" -> handleListFiles(it.data)
                else -> throw RuntimeException("Command cannot be handled")
            }
        }
    }

    private fun handleChangeDirectory(data: String) {
        currentFileTree = when (data) {
            "/" -> root
            ".." -> currentFileTree.parent ?: throw RuntimeException("No Parent available")
            else -> currentFileTree.directories.first { it.name == data }
        }
    }

    private fun handleListFiles(data: String) {
        data.lines().forEach { line ->
            line.split(" ")
                .let { (key, name) ->
                    when (key) {
                        "dir" -> currentFileTree.directories.add(FileTree(name, currentFileTree))
                        else -> currentFileTree.files.add(File(key.toInt(), name))
                    }
                }
        }
    }

    private fun directorySizes(): List<Int> {
        return root.sizes()
    }

    fun sizeOfDirectoriesUpTo100k(): Int {
        return directorySizes().filter { it <= 100000 }.sum()
    }

    fun findDirectorySizeToDelete(): Int {
        val currentFreeSpace = FILE_SYSTEM_SIZE - root.absoluteSize()

        return directorySizes().sorted().first { it + currentFreeSpace > UPDATE_REQUIRED_SPACE }
    }
}
