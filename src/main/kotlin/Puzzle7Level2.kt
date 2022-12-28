import Puzzle5Level1.extractBoard
import Puzzle6Level1.hasDupe
import Puzzle7Level1.getDirectorySizes
import java.nio.file.Path

object Puzzle7Level2 : PuzzleSolver {
    override fun solve(puzzle: String): String {
        val directorySizes = getDirectorySizes(puzzle)

        val spaceLeft = 70000000 - directorySizes["/"]!! // yum :P
        val spaceNeeded = 30000000 - spaceLeft

        return directorySizes.map { Pair(it.key, it.value) }.sortedByDescending { it.second }.last { it.second >= spaceNeeded }.second.toString()
    }
}