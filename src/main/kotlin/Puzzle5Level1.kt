object Puzzle5Level1 : PuzzleSolver {
    override fun solve(puzzle: String): String {
        val board = extractBoard(puzzle)

        val commands = puzzle.trim().split("\n\n").last().split("\n")
        commands.forEach {
            val command = it.split(" ")
                .mapIndexedNotNull { i, it -> it.takeIf { i % 2 == 1 }?.toInt()}
            for (i in 1..command[0]) {
                val from = board[command[1]-1][0]
                board[command[1]-1].removeAt(0)
                board[command[2]-1].add(0, from)
            }
        }

        return board.map { it.first().toString() }.reduce { acc, c -> acc + c }
    }

    fun extractBoard(puzzle: String): MutableList<MutableList<Char>> {
        val boardString = puzzle.split("\n\n").first().split("\n").mapNotNull { it.takeUnless { it.contains("1") } }
        val board = mutableListOf<MutableList<Char>>()
        val rows = (boardString.first().length + 1)/4
        for (i in 1..rows) {
            board.add(mutableListOf())
        }

        for (row in boardString) {
            for (col in 0..row.length) {
                if (col >= 1 && row[col - 1] == '[') {
                    board[(col + 2)/4].add(row[col])
                }
            }
        }

        return board
    }
}