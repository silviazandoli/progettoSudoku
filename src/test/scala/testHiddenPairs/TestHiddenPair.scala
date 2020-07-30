package testHiddenPairs

import org.scalatest.FunSuite
import resolutionAlgorithm.FullExploration
import resolutionAlgorithm.HiddenPair.solveHiddenPair
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle
import utility._

class TestHiddenPair extends FunSuite {

  test("Hidden Pair Sudoku02") {
    //init
    val nameFile = "input/sudoku02.txt"
    val nameSolved = "outputSolved/sudoku02.txt"
    loadPuzzle(nameFile)

    displayNoTitle(puzzle)
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
    val nameFile = "input/sudoku01_temp.txt"

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    val sudokuInput = getPuzzle

    val solver = FullExploration(getPuzzle)
    solver.solve(0, 0)


    assert(sudokuInput(2)(2) == solver.returnPuzzle()(2)(2))
    assert(sudokuInput(5)(2) == solver.returnPuzzle()(5)(2))

  }
  test("Sudoku05") {
    val nameFile = "input/sudoku05.txt"

    loadPuzzle(nameFile)
    initList()
    val solverWithout = FullExploration(getPuzzle)
    solverWithout.solve(0, 0)

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    val solverWith = FullExploration(getPuzzle)
    solverWith.solve(0, 0)
    assert(solverWithout.returnPuzzle()(2)(2) == solverWith.returnPuzzle()(2)(2))
    assert(solverWithout.returnPuzzle()(5)(2) == solverWith.returnPuzzle()(5)(2))
  }

  test("Sudoku06") {
    val nameFile = "input/sudoku06.txt"

    loadPuzzle(nameFile)
    initList()
    val solverWithout = FullExploration(getPuzzle)
    solverWithout.solve(0, 0)

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    val solverWith = FullExploration(getPuzzle)
    solverWith.solve(0, 0)
    assert(solverWithout.returnPuzzle()(2)(2) == solverWith.returnPuzzle()(2)(2))
    assert(solverWithout.returnPuzzle()(5)(2) == solverWith.returnPuzzle()(5)(2))
  }

  test("Sudoku11") {
    val nameFile = "input/sudoku11.txt"

    loadPuzzle(nameFile)
    initList()
    val solverWithout = FullExploration(getPuzzle)
    solverWithout.solve(0, 0)

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    val solverWith = FullExploration(getPuzzle)
    solverWith.solve(0, 0)
    assert(solverWithout.returnPuzzle()(2)(2) == solverWith.returnPuzzle()(2)(2))
    assert(solverWithout.returnPuzzle()(5)(2) == solverWith.returnPuzzle()(5)(2))
  }

  test("Sudoku22") {
    val nameFile = "input/sudoku22.txt"

    loadPuzzle(nameFile)
    initList()
    val solverWithout = FullExploration(getPuzzle)
    solverWithout.solve(0, 0)

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    val solverWith = FullExploration(getPuzzle)
    solverWith.solve(0, 0)
    assert(solverWithout.returnPuzzle()(2)(2) == solverWith.returnPuzzle()(2)(2))
    assert(solverWithout.returnPuzzle()(5)(2) == solverWith.returnPuzzle()(5)(2))
  }

  test("Sudoku04") {
    val nameFile = "input/sudoku04.txt"

    loadPuzzle(nameFile)
    initList()
    val solverWithout = FullExploration(getPuzzle)
    solverWithout.solve(0, 0)

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    val solverWith = FullExploration(getPuzzle)
    solverWith.solve(0, 0)
    assert(solverWithout.returnPuzzle()(2)(2) == solverWith.returnPuzzle()(2)(2))
    assert(solverWithout.returnPuzzle()(5)(2) == solverWith.returnPuzzle()(5)(2))
  }

  test("Sudoku03") {
    val nameFile = "input/sudoku03.txt"
    loadPuzzle(nameFile)
    initList()
    val solverWithout = FullExploration(getPuzzle)
    solverWithout.solve(0, 0)

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    val solverWith = FullExploration(getPuzzle)
    solverWith.solve(0, 0)
    assert(solverWithout.returnPuzzle()(2)(2) == solverWith.returnPuzzle()(2)(2))
    assert(solverWithout.returnPuzzle()(5)(2) == solverWith.returnPuzzle()(5)(2))
  }

  test("Sudoku23") {
    val nameFile = "input/sudoku23.txt"

    loadPuzzle(nameFile)
    initList()
    val solverWithout = FullExploration(getPuzzle)
    solverWithout.solve(0, 0)

    loadPuzzle(nameFile)
    initList()
    solveHiddenPair()
    val solverWith = FullExploration(getPuzzle)
    solverWith.solve(0, 0)
    assert(solverWithout.returnPuzzle()(2)(2) == solverWith.returnPuzzle()(2)(2))
    assert(solverWithout.returnPuzzle()(5)(2) == solverWith.returnPuzzle()(5)(2))
  }



}



