object Puzzle1Level2 : PuzzleSolver {
    override fun solve(puzzle: String): String {
        return Puzzle1Level1.countElfCalories(puzzle)
            .sortedDescending()
            .take(3)
            .sum().toString()
    }
}