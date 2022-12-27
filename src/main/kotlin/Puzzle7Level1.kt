import Puzzle5Level1.extractBoard
import Puzzle6Level1.hasDupe
import java.nio.file.Path

object Puzzle7Level1 : PuzzleSolver {
    override fun solve(puzzle: String): String {
        val directorySizes = getDirectorySizes(puzzle)

        return directorySizes.values.sorted().reduce { acc, i -> if (i <= 100000) acc + i else acc }.toString()
    }

    fun getDirectorySizes(puzzle: String): MutableMap<String, Int> {
        val consoleLines = puzzle.trim().split("\n")
        var currentPath = Path.of("/")
        var currentSize = 0
        val directorySizes = mutableMapOf<String, Int>()
        var keepSearching = true
        // This is the definition of insanity.
        // TODO: refactor to not be insane.
        for (i in 1..100000) {
            keepSearching = false
            currentPath = Path.of("/")
            currentSize = 0
            var maxRecurse = 0
            for (line in consoleLines) {
                when {
                    line.startsWith("$ cd ") -> {
                        if (currentSize > 0) {
                            directorySizes[currentPath.toAbsolutePath().toString()] = currentSize
                            currentSize = 0
                        }
                        var moveTo = line.substring(5, line.length)
                        if (moveTo == "..") {
                            currentPath = currentPath.parent
                        } else {
                            currentPath = Path.of(currentPath.toAbsolutePath().toString(), moveTo)
                        }
                    }

                    line.startsWith("$ ls") -> {
                        currentSize = 0
                    }

                    else -> {
                        if (line.split(" ").first() != "dir") {
                            currentSize += line.split(" ").first().toInt()
                        } else {
                            currentSize += directorySizes.getOrElse(Path.of(currentPath.toAbsolutePath().toString(), line.split(" ").last()).toAbsolutePath().toString()) {
                                keepSearching = true
                                0
                            }
                        }
                    }
                }
            }
            if (currentSize > 0) {
                directorySizes[currentPath.toAbsolutePath().toString()] = currentSize
                currentSize = 0
            }
        }

        return directorySizes
    }
}