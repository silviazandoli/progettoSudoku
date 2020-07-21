package testFull

import org.scalatest.FunSuite
import resolutionAlgorithm.FullExploration.solve
import resolutionAlgorithm.SudokuLoad.{dimSudoku, getPuzzle, loadPuzzle}

class testFull extends FunSuite {
  test("TestSudoku11") {
    val nameFile = "input/sudoku11.txt"
    val nameSolved = "outputSolved/sudoku11.txt"

    loadPuzzle(nameFile)
    solve(0, 0)
    val solvedFull = getPuzzle.clone()

    loadPuzzle(nameSolved)
    val solved = getPuzzle

    assert(solvedFull sameElements solved)
  }

  test("TestSudoku11-02") {
    val nameFile = "input/sudoku01.txt"
    val nameSolved = "outputSolved/sudoku11.txt"

    loadPuzzle(nameFile)
    solve(0, 0)
    val solvedFull = getPuzzle.clone()

    loadPuzzle(nameSolved)
    val solved = getPuzzle

    assert(!(solvedFull sameElements solved))
  }
}
