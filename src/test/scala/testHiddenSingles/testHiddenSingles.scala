package testHiddenSingles

import org.scalatest.FunSuite
import resolutionAlgorithm.{FullExploration, HiddenSingles}
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle
import utility.getPuzzle

class testHiddenSingles extends FunSuite {

  test("Sudoku01") {
    val nameFile = "input/sudoku01.txt"
    val nameSolved = "outputSolved/sudoku01.txt"

    loadPuzzle(nameFile)
    initList()

    HiddenSingles().hiddenSingles(1, 1)
    val sudokuInput = getPuzzle

    loadPuzzle(nameSolved)
    val sudokuSolved = getPuzzle

    assert(sudokuInput(1)(1) == sudokuSolved(1)(1))
  }

  test("Sudoku06") {
    val nameFile = "input/sudoku06.txt"

    loadPuzzle(nameFile)
    initList()
    HiddenSingles().hiddenSingles(7, 0)
    val sudokuInput = getPuzzle

    val solver = FullExploration(getPuzzle)
    solver.solve(0, 0)

    assert(sudokuInput(7)(0) == solver.returnPuzzle()(7)(0))
  }

  test("Sudoku05") {
    val nameFile = "input/sudoku05.txt"

    loadPuzzle(nameFile)
    initList()
    HiddenSingles().totalHiddenSingles()
    val sudokuInput = getPuzzle

    val solver = FullExploration(getPuzzle)
    solver.solve(0, 0)
    val sudokuSolved = solver.returnPuzzle()

    assert(sudokuInput(2)(2) == sudokuSolved(2)(2))
    assert(sudokuInput(5)(2) == sudokuSolved(5)(2))
  }
}
