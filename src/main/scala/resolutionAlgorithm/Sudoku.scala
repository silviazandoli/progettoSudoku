package resolutionAlgorithm

import resolutionAlgorithm.FullExploration.solve
import resolutionAlgorithm.SudokuLoad.{display, displayList, loadPuzzle}
import resolutionAlgorithm.SudokuMatrix.{initList, strategyList1}
import util.TimeStampImpl

object Sudoku extends App {
  val nameFile = "input/sudoku03.txt"

  print("Puzzle: " + nameFile)
  loadPuzzle(nameFile)
  display("Schema iniziale")

  initList() // costruzione liste
  displayList(0, 0)

  val timeStamp = TimeStampImpl(System.currentTimeMillis())
  strategyList1()
  timeStamp.calculateDiff(System.currentTimeMillis())

  display("Soluzione strategy list")
  solve(0, 0)
  display("Soluzione")
}
