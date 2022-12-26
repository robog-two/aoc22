import Puzzle5Level1.extractBoard
import Puzzle6Level1.hasDupe
import java.nio.file.Path

object Puzzle7Level1 : PuzzleSolver {
    override fun solve(puzzle: String): String {
        val consoleLines = puzzle.trim().split("\n")
        var currentPath = Path.of("/")
        var currentSize = 0
        val directorySizes = mutableListOf<Pair<Path, Int>>()
        for (line in consoleLines) {
            when {
                line.startsWith("$ cd ") -> {
                    if (currentSize > 0) {
                        directorySizes.add(Pair(currentPath, currentSize))
                        currentSize = 0
                    }
                    var moveTo = line.substring(5, line.length)
                    if (moveTo == "..") {
                        currentPath = currentPath.parent
                    } else {
                        currentPath = Path.of(currentPath.toAbsolutePath().toString(), moveTo)
                    }
                    println(currentPath)
                }
                line.startsWith("$ ls") -> {
                    currentSize = 0
                }
                else -> {
                    if (line.split(" ").first() != "dir") {
                        currentSize += line.split(" ").first().toInt()
                    }
                }
            }
        }

        return directorySizes.map { it.second }.sortedByDescending { it }.reduce { acc, pair ->
            if (pair < 100000) {
                acc + pair
            } else if (acc < 100000) {
                acc
            } else {
                0
            }
        }.toString()
    }
}