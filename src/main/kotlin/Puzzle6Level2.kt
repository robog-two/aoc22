import Puzzle5Level1.extractBoard
import Puzzle6Level1.hasDupe

object Puzzle6Level2 : PuzzleSolver {
    override fun solve(puzzle: String): String {
        for (i in 14 until puzzle.length) {
            val window = puzzle.substring(i-14, i)
            if (!hasDupe(window)) return i.toString()
        }
        return ""
    }
}