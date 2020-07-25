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
    val nameFile = "input/sudoku02.txt"
    val nameSolved = "outputSolved/sudoku02.txt"
    loadPuzzle(nameFile)

    display(puzzle)
    initList()
    for (i <- 0 to 8) {
      for (j <- 0 to 8)
        println("MatList riga " + i + " colonna" + j + " è " + matList(i)(j).toString)
    }
    //printMatrix()
    solveHiddenPair()

    //HiddenPair.checkBlock(3)
    // println(HiddenPair.base3(8))
    for (i <- 0 to 8) {
      for (j <- 0 to 8)
        println("MatList DOPO riga " + i + " colonna" + j + " è " + matList(i)(j).toString)
    }
  }

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
  test("Sudoku05") {
    val nameFile = "input/sudoku05.txt"

    loadPuzzle(nameFile)
    initList()
    solve(0, 0)
    val sudokuSolvedwithout = getPuzzle

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    solve(0, 0)
    val sudokuSolvedWith = getPuzzle
    assert(sudokuSolvedwithout(2)(2) == sudokuSolvedWith(2)(2))
    assert(sudokuSolvedWith(5)(2) == sudokuSolvedWith(5)(2))
  }

  test("Sudoku06") {
    val nameFile = "input/sudoku06.txt"

    loadPuzzle(nameFile)
    initList()
    solve(0, 0)
    val sudokuSolvedwithout = getPuzzle

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    solve(0, 0)
    val sudokuSolvedWith = getPuzzle
    assert(sudokuSolvedwithout(2)(2) == sudokuSolvedWith(2)(2))
    assert(sudokuSolvedWith(5)(2) == sudokuSolvedWith(5)(2))
  }

  test("Sudoku11") {
    val nameFile = "input/sudoku11.txt"

    loadPuzzle(nameFile)
    initList()
    solve(0, 0)
    val sudokuSolvedwithout = getPuzzle

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    solve(0, 0)
    val sudokuSolvedWith = getPuzzle
    assert(sudokuSolvedwithout(2)(2) == sudokuSolvedWith(2)(2))
    assert(sudokuSolvedWith(5)(2) == sudokuSolvedWith(5)(2))
  }

  test("Sudoku22") {
    val nameFile = "input/sudoku22.txt"

    loadPuzzle(nameFile)
    initList()
    solve(0, 0)
    val sudokuSolvedwithout = getPuzzle

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    solve(0, 0)
    val sudokuSolvedWith = getPuzzle
    assert(sudokuSolvedwithout(2)(2) == sudokuSolvedWith(2)(2))
    assert(sudokuSolvedWith(5)(2) == sudokuSolvedWith(5)(2))
  }

  test("Sudoku04") {
    val nameFile = "input/sudoku04.txt"

    loadPuzzle(nameFile)
    initList()
    solve(0, 0)
    val sudokuSolvedwithout = getPuzzle

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    solve(0, 0)
    val sudokuSolvedWith = getPuzzle
    assert(sudokuSolvedwithout(1)(2) == sudokuSolvedWith(1)(2))
    assert(sudokuSolvedWith(5)(3) == sudokuSolvedWith(5)(3))
  }

  test("Sudoku03") {
    val nameFile = "input/sudoku03.txt"

    loadPuzzle(nameFile)
    initList()
    solve(0, 0)
    val sudokuSolvedwithout = getPuzzle

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    solve(0, 0)
    val sudokuSolvedWith = getPuzzle
    assert(sudokuSolvedwithout(1)(2) == sudokuSolvedWith(1)(2))
    assert(sudokuSolvedWith(5)(3) == sudokuSolvedWith(5)(3))
  }

  test("Sudoku23") {
    val nameFile = "input/sudoku23.txt"

    loadPuzzle(nameFile)
    initList()
    solve(0, 0)
    val sudokuSolvedwithout = getPuzzle

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    solve(0, 0)
    val sudokuSolvedWith = getPuzzle
    assert(sudokuSolvedwithout(1)(2) == sudokuSolvedWith(1)(2))
    assert(sudokuSolvedWith(5)(3) == sudokuSolvedWith(5)(3))
  }

  test("My creation of MatList"){

  }

}





