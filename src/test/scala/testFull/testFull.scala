package testFull

import org.scalatest.FunSuite
import resolutionAlgorithm.FullExploration
import sudoku.SudokuLoad.loadPuzzle
import utility.{getPuzzle, confrontPuzzle, displayNoTitle}

/**
 * Fatto da Pacini
 */
class testFull extends FunSuite {
  test("TestSudoku11") {
    val nameFile = "input/easy/sudoku11.txt"
    val nameSolved = "outputSolved/sudoku11.txt"

    loadPuzzle(nameFile)
    val solver = FullExploration(getPuzzle)
    solver.solve(0, 0)

    loadPuzzle(nameSolved)
    assert(confrontPuzzle(solver.returnPuzzle(), getPuzzle))
  }

  test("TestSudoku11-02") {
    val nameFile = "input/easy/sudoku05.txt"
    val nameSolved = "outputSolved/sudoku11.txt"

    loadPuzzle(nameFile)
    val solver = FullExploration(getPuzzle)
    solver.solve(0, 0)

    loadPuzzle(nameSolved)

    assert(!confrontPuzzle(solver.returnPuzzle(), getPuzzle))
  }

  test("TestSudokuX") {
    val nameFile = "input/easy/sudoku11.txt"
    val nameSolved = "tempSolved/sudoku11.txt"

    loadPuzzle(nameFile)
    val solver = FullExploration(getPuzzle)
    solver.solve(0, 0)

    loadPuzzle(nameSolved)
    assert(!confrontPuzzle(solver.returnPuzzle(), getPuzzle))
  }
}
