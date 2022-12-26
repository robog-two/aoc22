object Puzzle4Level1 : PuzzleSolver {
    override fun solve(puzzle: String): String {
        return prepareGroupings(puzzle)
            .count {
                (it.first.contains(it.second.first) &&
                it.first.contains(it.second.last)) ||
                (it.second.contains(it.first.first) &&
                it.second.contains(it.first.last))
            }.toString()
    }

    fun prepareGroupings(puzzle: String): List<Pair<IntRange, IntRange>> {
        return puzzle.trim().split("\n", ",")
            .map { it.split("-").map { it.toInt() } }
            .chunked(2)
            .map { it.map {
                IntRange(it.first(), it.last())
            } }
            .map { Pair(it.first(), it.last()) }
    }
}