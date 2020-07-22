package sudoku

import resolutionAlgorithm.FullExploration.solve
import util.TimeStampImpl

import SudokuLoad.{loadPuzzle}
import MatListOperation.{initList}

import utility.{puzzle, display, displayList}

object Game extends App {
  val nameFile = "input/sudoku05.txt"

  print("Puzzle: " + nameFile)
  loadPuzzle(nameFile)
  display("Schema iniziale", puzzle)

  initList() // costruzione liste
  displayList(0, 0)

  /*
  val timeStamp = TimeStampImpl(System.currentTimeMillis())
  SudokuEngine.strategyList()
  timeStamp.calculateDiff(System.currentTimeMillis())
   */

  display("Soluzione strategy list", puzzle)
  solve(0, 0)
  display("Soluzione", puzzle)
}
