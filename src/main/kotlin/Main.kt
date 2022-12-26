import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    // Figure out what puzzle we're solving
    println("Select a day: ")
    val day = if (args.size == 2) {
        args[0].toInt()
    } else {
        readln().toInt()
    }
    println("OK")

    // shhh this is not repeated code, you see nothing
    println("Level of challenge (star 1 or 2):")
    val challenge = if (args.size == 2) {
        args[1].toInt()
    } else {
        readln().toInt()
    }
    println("OK")

    // Load the puzzle from the internet
    val puzzle = runBlocking { loadPuzzle(day) }

    // Find what class is solving it
    val solverClassName = "Puzzle${day}Level${challenge}"
    val solver: PuzzleSolver = PuzzleSolver::class.sealedSubclasses.find {
        it.simpleName == solverClassName
    }?.objectInstance ?: throw RuntimeException("Cannot solve this puzzle. Missing class: \"$solverClassName\"")

    println("Solution: ")
    print(solver.solve(puzzle))
}