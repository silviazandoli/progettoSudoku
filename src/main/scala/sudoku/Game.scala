package sudoku

import resolutionAlgorithm.FullExploration.solve
import util.TimeStampImpl

object Game extends App {
  val nameFile = "input/sudoku01.txt"

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
