package sudoku

import SudokuLoad.loadPuzzle
import MatListOperation.initList
import resolutionAlgorithm.FullExploration
import utility.{display, displayList, getPuzzle, puzzle}

object Game extends App {
  val nameFile = "input/sudoku05.txt"

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
