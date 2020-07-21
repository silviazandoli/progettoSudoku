package testFull

import org.scalatest.FunSuite
import resolutionAlgorithm.SudokuLoad.{display, loadPuzzle, puzzle}

class TestHiddenPair extends FunSuite {

  test("Hidden Pair") {
    //init
    val nameFile = "input/sudoku01.txt"
    val nameSolved = "outputSolved/sudoku01.txt"
      loadPuzzle(nameFile)

    display(puzzle)
        //todo
    //verify
  }


}
