package testHiddenSingles

import org.scalatest.FunSuite
import resolutionAlgorithm.FullExploration
import resolutionAlgorithm.HiddenSingles.{hiddenSingles, totalHiddenSingles}
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle
import utility.{getPuzzle, display, displayNoTitle}

class testHiddenSingles extends FunSuite {

  test("Sudoku01") {
    val nameFile = "input/easy/sudoku01.txt"
    val nameSolved = "outputSolved/sudoku01.txt"

    loadPuzzle(nameFile)
    initList()
    hiddenSingles(6, 2)
    val sudokuInput = getPuzzle

    loadPuzzle(nameSolved)
    val sudokuSolved = getPuzzle
    assert(sudokuInput(6)(2) == sudokuSolved(6)(2))
  }

  test("Sudoku06") {
    val nameFile = "input/easy/sudoku06.txt"

    loadPuzzle(nameFile)
    initList()
    hiddenSingles(0, 0)
    val sudokuInput = getPuzzle

    val solver = FullExploration(getPuzzle)
    solver.solve(0, 0)
    assert(sudokuInput(0)(0) == solver.returnPuzzle()(0)(0))
  }

  test("Sudoku05") {
    val nameFile = "input/easy/sudoku05.txt"

    loadPuzzle(nameFile)
    initList()
    totalHiddenSingles()
    val sudokuInput = getPuzzle

    display(sudokuInput)("input")

    val solver = FullExploration(getPuzzle)
    solver.solve(0, 0)
    val sudokuSolved = solver.returnPuzzle()

    display(sudokuSolved)("output")

    assert(sudokuInput(0)(1) == sudokuSolved(0)(1))
    assert(sudokuInput(2)(4) == sudokuSolved(2)(4))
  }
}
