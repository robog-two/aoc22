object Puzzle3Level1 : PuzzleSolver {
    override fun solve(puzzle: String): String {
        return puzzle.trimEnd().split("\n").map { rucksack ->
            val compartments = listOf(
                // first half
                rucksack.substring(0, (rucksack.length/2)),
                // second half
                rucksack.substring(
                    (rucksack.length/2),
                    rucksack.length
                )
            )

            val charCode = compartments.first().find {
                compartments.last().contains(it)
            }?.code ?: let {
                println(compartments.first() + ", " + compartments.last())
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