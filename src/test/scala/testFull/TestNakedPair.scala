package testFull

import org.scalatest.FunSuite
import sudoku.SudokuLoad.loadPuzzle
import sudoku.MatListOperation.initList
import utility.getPuzzle
import resolutionAlgorithm.NakedPairs
import utility.{display, puzzle,matList}



class TestNakedPair extends FunSuite {

  /*test("Sudoku01") {
    val nameFile = "input/sudoku01.txt"
    //val nameSolved = "outputSolved/sudoku01.txt"

    loadPuzzle(nameFile)
    initList()
    val initMat = utility.matList(1)(7)
    cycle()
    val sudokuInput = getPuzzle

    //loadPuzzle(nameSolved)
    print(sudokuInput)
    //val sudokuSolved = getPuzzle
    val finishMat = utility.matList(1)(7)

    //assert(sudokuInput(1)(1) != sudokuSolved(1)(1))
    println("matList iniziale" + initMat)
    println("matList finale "+ finishMat)
    assert(initMat == finishMat)
  }*/

  test("Sudoku01") {
    val nameFile = "input/sudoku01.txt"
    loadPuzzle(nameFile)
    display(puzzle)
    initList()
    val sudokuInput = getPuzzle
    print(sudokuInput)
    NakedPairs.nakedPair(0,0)
  }

}
