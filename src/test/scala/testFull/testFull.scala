package testFull

import org.scalatest.FunSuite
import resolutionAlgorithm.FullExploration.solve
import resolutionAlgorithm.SudokuLoad.{display, loadPuzzle, nameFile}

class testFull extends FunSuite {
  
  val nameSolved = "outputSolved/sudoku11.txt"

  test("TestSudoku11") {
    loadPuzzle(nameFile, 0)
    solve(0, 0)
    val solvedFull = display("Soluzione")

    loadPuzzle(nameSolved, 0)
    val solved = display("Soluzione")

    assert(solvedFull == solved)
  }
}
