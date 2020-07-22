package testHiddenSingles

import org.scalatest.FunSuite
import sudoku.SudokuLoad.loadPuzzle
import sudoku.MatListOperation.initList
import utility.getPuzzle

import resolutionAlgorithm.FullExploration.solve
import resolutionAlgorithm.HiddenSingles.hiddenSingles

class testHiddenSingles extends FunSuite {

  test("Sudoku01") {
    val nameFile = "input/sudoku01.txt"
    val nameSolved = "outputSolved/sudoku01.txt"

    loadPuzzle(nameFile)
    initList()
    hiddenSingles(1, 1)
    val sudokuInput = getPuzzle

    loadPuzzle(nameSolved)
    val sudokuSolved = getPuzzle

    assert(sudokuInput(1)(1) == sudokuSolved(1)(1))
  }

  test("Sudoku06") {
    val nameFile = "input/sudoku06.txt"

    loadPuzzle(nameFile)
    initList()
    hiddenSingles(7, 0)
    val sudokuInput = getPuzzle

    solve(0,0)
    val sudokuSolved = getPuzzle

    assert(sudokuInput(7)(0) == sudokuSolved(7)(0))
  }
}
