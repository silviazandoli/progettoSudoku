import FullExploration.solve
import SudokuMatrix._
import SudokuLoad.{display, loadPuzzle, nameFile, displayList}

object Sudoku extends App {
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