object Puzzle1Level1 : PuzzleSolver {
    override fun solve(puzzle: String): String {
        return countElfCalories(puzzle).maxOf { it }.toString()
    }

    fun countElfCalories(puzzle: String): List<Int> {
        return puzzle.split("\n\n").map {
            it.split("\n").mapNotNull {
                it.toIntOrNull()
            }.reduce { acc, calories ->
                acc + calories
            }.toInt()
        }
    }
}