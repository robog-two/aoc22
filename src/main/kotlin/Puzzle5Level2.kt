import Puzzle5Level1.extractBoard

object Puzzle5Level2 : PuzzleSolver {
    override fun solve(puzzle: String): String {
        val board = extractBoard(puzzle)

        val commands = puzzle.trim().split("\n\n").last().split("\n")
        commands.forEach {
            val command = it.split(" ")
                .mapIndexedNotNull { i, it -> it.takeIf { i % 2 == 1 }?.toInt() }
            val from = board[command[1] - 1].take(command[0])
            board[command[1] - 1] = board[command[1] - 1].subList(command[0], board[command[1] - 1].size)
            board[command[2] - 1].addAll(0, from)
        }

        return board.map { it.first().toString() }.reduce { acc, c -> acc + c }
    }
}