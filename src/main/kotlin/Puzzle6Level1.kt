import Puzzle5Level1.extractBoard

object Puzzle6Level1 : PuzzleSolver {
    override fun solve(puzzle: String): String {
        for (i in 4 until puzzle.length) {
            val window = puzzle.substring(i-4, i)
            if (!hasDupe(window)) return i.toString()
        }
        return ""
    }

    fun hasDupe(window: String): Boolean {
        window.toList()
            .sortedByDescending { it.code }
            .reduce { acc, c ->
                if (acc == c) return true
                return@reduce c
            }
        return false
    }
}