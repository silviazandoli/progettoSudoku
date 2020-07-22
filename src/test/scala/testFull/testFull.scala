package testFull

import org.scalatest.FunSuite
import resolutionAlgorithm.FullExploration.solve
import sudoku.SudokuLoad.{getPuzzle, loadPuzzle, dimSudoku}

class testFull extends FunSuite {

  def confrontPuzzle(puzzle1: Array[Array[Int]], puzzle2: Array[Array[Int]]): Boolean = {
    if (puzzle1.length != puzzle2.length) return false

    for {
      i <- 0 until dimSudoku
      j <- 0 until dimSudoku
    } {
      if (puzzle1(i)(j) != puzzle2(i)(j)) return false
    }
    true
  }

  test("TestSudoku11") {
    val nameFile = "input/sudoku11.txt"
    val nameSolved = "outputSolved/sudoku11.txt"

    loadPuzzle(nameFile)
    solve(0, 0)
    val solvedFull = getPuzzle

    loadPuzzle(nameSolved)
    val solved = getPuzzle

    assert(confrontPuzzle(solvedFull, solved))
  }

  test("TestSudoku11-02") {
    val nameFile = "input/sudoku05.txt"
    val nameSolved = "outputSolved/sudoku11.txt"

    loadPuzzle(nameFile)
    solve(0, 0)
    val solvedFull = getPuzzle

    loadPuzzle(nameSolved)
    val solved = getPuzzle

    assert(!confrontPuzzle(solvedFull, solved))
  }
}
