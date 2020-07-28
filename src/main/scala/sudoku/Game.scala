package sudoku

import SudokuLoad.loadPuzzle
import MatListOperation.initList
import resolutionAlgorithm.FullExploration
import utility.{display, displayList, getPuzzle, puzzle}

object Game extends App {
  val nameFile = "input/sudoku05.txt"

  print("Puzzle: " + nameFile)
  loadPuzzle(nameFile)
  display("Schema iniziale", puzzle)

  initList() // costruzione liste
  displayList(0, 0)

  display("Soluzione strategy list", puzzle)
  val solver = FullExploration(getPuzzle)
  solver.solve(0, 0)
  display("Soluzione", solver.returnPuzzle())
}
