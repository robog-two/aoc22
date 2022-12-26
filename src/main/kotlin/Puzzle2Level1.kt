object Puzzle2Level1 : PuzzleSolver {
    val conditions = listOf( // 0 - loss, 1 - tie, 2 - win
        listOf( // loss
            "AZ",
            "BX",
            "CY"
        ),
        listOf( // tie
            "AX",
            "BY",
            "CZ"
        ),
        listOf( // win
            "AY",
            "BZ",
            "CX"
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
            return@mapNotNull getOutcomeScore(choices[0] + choices[1]) +
                getChoiceScore(choices[1].first())
        }.reduce { acc, i ->
            acc + i
        }.toString()
    }

    fun getOutcomeScore(game: String): Int {
        return conditions.indexOfFirst { it.contains(game) } * 3
    }

    fun getChoiceScore(choice: Char): Int {
        return values.indexOf(choice) + 1
    }
}