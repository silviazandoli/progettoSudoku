package resolutionAlgorithm

import resolutionAlgorithm.FullExploration.solve
import resolutionAlgorithm.SudokuLoad.{display, displayList, loadPuzzle}
import resolutionAlgorithm.SudokuMatrix.{initList, strategyList1}
import util.TimeStampImpl

object Sudoku extends App {
  val nameFile = "input/sudoku01.txt"

  print("Puzzle: " + nameFile)
  loadPuzzle(nameFile, 0)
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
