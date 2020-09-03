package sudoku

/**
 * Made by Pacini
 */
object Game extends App {
  import SudokuLoad.loadPuzzle
  import MatListOperation.initList
  import resolutionAlgorithm.FullExploration
  import utility.{display, displayList, getPuzzle, puzzle}

  val nameFile = "input/easy/sudoku05.txt"

  print("Puzzle: " + nameFile)
  loadPuzzle(nameFile)
  display(puzzle)("Schema iniziale")

  initList() // costruzione liste
  displayList(0, 0)

  display(puzzle)("Soluzione strategy list")
  val solver = FullExploration(getPuzzle)
  solver.solve(0, 0)
  display(solver.returnPuzzle())("Soluzione")
}
