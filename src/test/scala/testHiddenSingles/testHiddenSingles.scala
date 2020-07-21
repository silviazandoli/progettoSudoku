package testHiddenSingles

import org.scalatest.FunSuite
import resolutionAlgorithm.HiddenSingles
import resolutionAlgorithm.SudokuLoad.loadPuzzle

class testHiddenSingles extends FunSuite {
  val nameFile = "input/sudoku11.txt"
  val nameSolved = "outputSolved/sudoku11.txt"

  test("") {
    loadPuzzle(nameFile)
    //HiddenSingles.method()

  }
}
