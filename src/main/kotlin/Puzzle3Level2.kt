object Puzzle3Level2 : PuzzleSolver {
    override fun solve(puzzle: String): String {
        return puzzle.trimEnd().split("\n").chunked(3)
            .map { trio ->
            val charCode = trio.first().find {
                trio[1].contains(it) && trio[2].contains(it)
            }?.code ?: let {
                println(trio[1] + ", " + trio[2] + ", " + trio[3])
                throw RuntimeException("Missing duplicate.")
            }

            return@map if (charCode > 90) {
                charCode - 96
            } else {
                charCode - 38
            }
        }.reduce { acc, i -> acc + i }.toString()
    }
}