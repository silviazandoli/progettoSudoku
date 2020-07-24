package testHiddenPairs

import org.scalatest.FunSuite
import resolutionAlgorithm.HiddenPair
import sudoku.MatListOperation
import sudoku.SudokuLoad.loadPuzzle
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
    HiddenPair.checkBlock(8)
  }
    //verify bisogna vedere che funzioni e che si riesca a risolvere l'algoritmo
    //test da fare
  //todo il test è da fare così. come nel caso hidden single
   /* test("Sudoku01") {
      val nameFile = "input/sudoku01.txt"
      val nameSolved = "outputSolved/sudoku01.txt"

      loadPuzzle(nameFile)
      initList()
      hiddenSingles(1, 1)
      val sudokuInput = getPuzzle

      loadPuzzle(nameSolved)
      val sudokuSolved = getPuzzle

      assert(sudokuInput(1)(1) == sudokuSolved(1)(1))

    //verify

  }*/


}
