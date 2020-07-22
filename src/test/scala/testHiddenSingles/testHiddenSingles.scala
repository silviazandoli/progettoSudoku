package testHiddenSingles

import org.scalatest.FunSuite
import sudoku.SudokuLoad.loadPuzzle
import sudoku.MatListOperation.initList
import utility.getPuzzle

import resolutionAlgorithm.HiddenSingles.hiddenSingles

class testHiddenSingles extends FunSuite {
  val nameFile = "input/sudoku01.txt"
  val nameSolved = "outputSolved/sudoku01.txt"

  test("") {
    loadPuzzle(nameFile)
    initList()
    hiddenSingles(1, 1)
    val sudokuInput = getPuzzle

    loadPuzzle(nameSolved)
    val sudokuSolved = getPuzzle

    assert(sudokuInput(1)(1) == sudokuSolved(1)(1))
  }
}
