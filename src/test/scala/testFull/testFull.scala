package testFull

import org.scalatest.FunSuite
import resolutionAlgorithm.FullExploration
import sudoku.SudokuLoad.loadPuzzle
import utility.{getPuzzle, confrontPuzzle}

/**
 * Fatto da Pacini
 */
class testFull extends FunSuite {
  test("TestSudoku11") {
    val nameFile = "input/sudoku11.txt"
    val nameSolved = "outputSolved/sudoku11.txt"

    loadPuzzle(nameFile)
    val solver = FullExploration(getPuzzle)
    solver.solve(0, 0)

    loadPuzzle(nameSolved)

    assert(confrontPuzzle(solver.returnPuzzle(), getPuzzle))
  }

  test("TestSudoku11-02") {
    val nameFile = "input/sudoku05.txt"
    val nameSolved = "outputSolved/sudoku11.txt"

    loadPuzzle(nameFile)
    val solver = FullExploration(getPuzzle)
    solver.solve(0, 0)

    loadPuzzle(nameSolved)

    assert(!confrontPuzzle(solver.returnPuzzle(), getPuzzle))
  }
}
