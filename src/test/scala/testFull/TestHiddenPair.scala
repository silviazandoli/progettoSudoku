package testFull

import org.scalatest.FunSuite
import sudoku.MatListOperation
import sudoku.SudokuLoad.loadPuzzle
import resolutionAlgorithm.HiddenPair
import utility.{display, puzzle}

class TestHiddenPair extends FunSuite {

  test("Hidden Pair") {
    //init
    val nameFile = "input/sudoku01.txt"
    val nameSolved = "outputSolved/sudoku01.txt"
      loadPuzzle(nameFile)

    display(puzzle)
    MatListOperation.initList()
  HiddenPair.solveHiddenPair()

    //verify
  }


}
