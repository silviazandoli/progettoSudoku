package sudoku

import resolutionAlgorithm.FullExploration.solve
import util.TimeStampImpl

import SudokuLoad.{loadPuzzle}
import MatListOperation.{initList, strategyList1}

import utility.{puzzle, display, displayList}

object Game extends App {
  val nameFile = "input/sudoku05.txt"

  print("Puzzle: " + nameFile)
  loadPuzzle(nameFile)
  display("Schema iniziale", puzzle)

  initList() // costruzione liste
  displayList(0, 0)

  val timeStamp = TimeStampImpl(System.currentTimeMillis())
  strategyList1()
  timeStamp.calculateDiff(System.currentTimeMillis())

  display("Soluzione strategy list", puzzle)
  solve(0, 0)
  display("Soluzione", puzzle)
}
