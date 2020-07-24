package testHiddenPairs

import org.scalatest.FunSuite
import resolutionAlgorithm.FullExploration.solve
import resolutionAlgorithm.HiddenPair.solveHiddenPair
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle
import utility._

class TestHiddenPair extends FunSuite {

  test("Hidden Pair") {
    //init
    val nameFile = "input/sudoku01.txt"
    val nameSolved = "outputSolved/sudoku01.txt"
    loadPuzzle(nameFile)

    display(puzzle)
    initList()
    for (i <- 0 to 8) {
      for (j <- 0 to 8)
        println("MatList riga " + i + " colonna" + j + " è " + matList(i)(j).toString)
    }
    printMatrix()
    solveHiddenPair()

    //HiddenPair.checkBlock(3)
    // println(HiddenPair.base3(8))
    for (i <- 0 to 8) {
      for (j <- 0 to 8)
        println("MatList DOPO riga " + i + " colonna" + j + " è " + matList(i)(j).toString)
    }
  }

  //todo TEST SIMILE DA FARE..

  test("Sudoku01") {
    val nameFile = "input/sudoku01.txt"

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    val sudokuInput = getPuzzle

    solve(0, 0)
    val sudokuSolved = getPuzzle

    assert(sudokuInput(2)(2) == sudokuSolved(2)(2))
    assert(sudokuInput(5)(2) == sudokuSolved(5)(2))

  }

}





