package testFull

import org.scalatest.FunSuite
import sudoku.SudokuLoad.loadPuzzle
import sudoku.MatListOperation.initList
import utility.getPuzzle
import resolutionAlgorithm.NakedPairs.cycle



class TestNakedPair extends FunSuite {

  test("Sudoku01") {
    val nameFile = "input/sudoku01.txt"
    val nameSolved = "outputSolved/sudoku01.txt"

    loadPuzzle(nameFile)
    initList()
    cycle()
    val sudokuInput = getPuzzle

    loadPuzzle(nameSolved)
    print(sudokuInput)
    val sudokuSolved = getPuzzle

    assert(sudokuInput(1)(1) != sudokuSolved(1)(1))
  }

}
