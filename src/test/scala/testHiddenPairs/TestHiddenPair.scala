package testHiddenPairs

import org.scalatest.FunSuite
import resolutionAlgorithm.HiddenPair
import sudoku.MatListOperation
import sudoku.SudokuLoad.loadPuzzle
import utility.{display, puzzle,matList}

class TestHiddenPair extends FunSuite {

  test("Hidden Pair") {
    //init
    val nameFile = "input/sudoku01.txt"
    val nameSolved = "outputSolved/sudoku01.txt"
    loadPuzzle(nameFile)

    display(puzzle)
    MatListOperation.initList()
    HiddenPair.solveHiddenPair()
    HiddenPair.checkBlock(3)
    println(HiddenPair.base3(8))
    /*Risolvere in maniera del genere*/
   /* initList()
    hiddenSingles(1, 1)
    val sudokuInput = getPuzzle

    loadPuzzle(nameSolved)
    val sudokuSolved = getPuzzle

    assert(sudokuInput(1)(1) == sudokuSolved(1)(1))*/

  }
   //todo TEST SIMILE DA FARE
  /*
    test("Sudoku05") {
    val nameFile = "input/sudoku05.txt"

    loadPuzzle(nameFile)
    initList()
    totalHiddenSingles()
    val sudokuInput = getPuzzle

    solve(0,0)
    val sudokuSolved = getPuzzle

    assert(sudokuInput(2)(2) == sudokuSolved(2)(2))
    assert(sudokuInput(5)(2) == sudokuSolved(5)(2))
  }
   */
test("test block"){
  println(matList.toList)

}



}
