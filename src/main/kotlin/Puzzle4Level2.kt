import Puzzle4Level1.prepareGroupings

object Puzzle4Level2 : PuzzleSolver {
    override fun solve(puzzle: String): String {
        return prepareGroupings(puzzle)
            .count {
                it.first.contains(it.second.first) ||
                it.first.contains(it.second.last) ||
                it.second.contains(it.first.first) ||
                it.second.contains(it.first.last)
            }.toString()
    }
}