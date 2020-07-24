package grafic

import sudoku.SudokuLoad.loadPuzzle

object MainGraphic extends App {
  val nameSolved = "outputSolved/sudoku11.txt"
  loadPuzzle(nameSolved)

  val sudoku = new Sudoku()
  sudoku.create()
}
