import FullExploration.{display, loadPuzzle}

import SudokuMatrix._

object Sudoku extends App {
  val dimSudoku = 9
  val puzzle: Array[Array[Int]] = Array.ofDim[Int](dimSudoku, dimSudoku)
  val nameFile = "input/sudoku11.txt"

  loadPuzzle(nameFile, 0)
  display()

  initList()
  strategyList()

  /*
  val coppiaMin = minList()
  println(coppiaMin)
  println(matList(coppiaMin._1) (coppiaMin._2))
   */

  //solve(0, 0)

  display()
}
