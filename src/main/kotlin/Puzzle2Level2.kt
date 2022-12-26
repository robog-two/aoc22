object Puzzle2Level2 : PuzzleSolver {
    val conditions = listOf( // 0 - loss, 1 - tie, 2 - win
        listOf( // rock
            "AY",
            "BX",
            "CZ"
        ),
        listOf( // paper
            "BY",
            "AZ",
            "CX"
        ),
        listOf( // scissors
            "CY",
            "AX",
            "BZ"
        )
    )

    val values = listOf( //
        'X',
        'Y',
        'Z'
    )

    override fun solve(puzzle: String): String {
        return puzzle.split("\n").mapNotNull {
            if (it == "") return@mapNotNull null
            val choices = it.split(" ")
            return@mapNotNull getChoiceScore(choices[0] + choices[1]) +
                    getOutcomeScore(choices[1].first())
        }.reduce { acc, i ->
            acc + i
        }.toString()
    }

    private fun getChoiceScore(game: String): Int {
        return conditions.indexOfFirst { it.contains(game) } + 1
    }

    private fun getOutcomeScore(choice: Char): Int {
        return values.indexOf(choice) * 3
    }
}