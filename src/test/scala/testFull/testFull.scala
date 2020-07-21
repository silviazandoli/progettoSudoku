package testFull

import org.scalatest.FunSuite
import resolutionAlgorithm.FullExploration.solve
import resolutionAlgorithm.SudokuLoad.{getPuzzle, loadPuzzle, display, puzzle}

class testFull extends FunSuite {
  test("TestSudoku11") {
    val nameFile = "input/sudoku11.txt"
    val nameSolved = "outputSolved/sudoku11.txt"

    loadPuzzle(nameFile)
    solve(0, 0)
    val solvedFull = getPuzzle

    loadPuzzle(nameSolved)
    val solved = getPuzzle

    assert(solvedFull sameElements solved)
  }

  test("TestSudoku11-02") {
    val nameFile = "input/sudoku05.txt"
    val nameSolved = "outputSolved/sudoku11.txt"

    loadPuzzle(nameFile)
    solve(0, 0)
    val solvedFull = getPuzzle

    display(solvedFull)

    loadPuzzle(nameSolved)
    val solved = getPuzzle

    display(solved)

    assert(!(solvedFull sameElements solved))
  }
}
