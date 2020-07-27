package testFull

import org.scalatest.FunSuite
import resolutionAlgorithm.FullExploration.solve
import sudoku.SudokuLoad.loadPuzzle
import sudoku.MatListOperation.initList
import utility.getPuzzle
import resolutionAlgorithm.NakedPairsVariant._
import utility._



class TestNakedPair extends FunSuite {
  test("Sudoku01") {

    val nameFile = "input/sudokuText.txt"
    //val nameSolved = "outputSolved/sudoku01.txt"
    loadPuzzle(nameFile)

    display(puzzle)
    initList()
    //for (i <- 0 to 8) {
      for (j <- 0 to 8) {
        println("MatList riga " + 0 + " colonna" + j + " è " + matList(0)(j).toString)
      }
    //}

    val initMat = utility.matList(0)(4)
    //printMatrix()
    findCouple(0,true)
    //findCouple(1,false)
    //HiddenPair.checkBlock(3)
    // println(HiddenPair.base3(8))
    //for (i <- 0 to 8) {
      for (j <- 0 to 8){
        println("MatList DOPO riga " + 0 + " colonna" + j + " è " + matList(0)(j).toString)
     }
    //}

    val finishMat = utility.matList(0)(4)

    //assert(sudokuInput(1)(1) != sudokuSolved(1)(1))
    println("matList iniziale " + initMat)
    println("matList finale "+ finishMat)
    assert(initMat != finishMat)
  }

  /*test("Naked Pair Sudoku02") {
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
    val initMat = utility.matList(0)(8)
    //printMatrix()
    solveNakedPair()

    //HiddenPair.checkBlock(3)
    // println(HiddenPair.base3(8))
    for (i <- 0 to 8) {
      for (j <- 0 to 8)
        println("MatList DOPO riga " + i + " colonna" + j + " è " + matList(i)(j).toString)
    }
    val finishMat = utility.matList(0)(8)

    println("matList iniziale " + initMat)
    println("matList finale "+ finishMat)
    assert(initMat != finishMat)
  }
  test("Sudoku01") {
    val nameFile = "input/sudoku01.txt"

    loadPuzzle(nameFile)
    initList()
    solveNakedPair()
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
    solveNakedPair()
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
    solveNakedPair()
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
    solveNakedPair()
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
    solveNakedPair()
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
    solveNakedPair()
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
    solveNakedPair()
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
    solveNakedPair()
    solve(0, 0)
    val sudokuSolvedWith = getPuzzle
    assert(sudokuSolvedwithout(1)(2) == sudokuSolvedWith(1)(2))
    assert(sudokuSolvedWith(5)(3) == sudokuSolvedWith(5)(3))
  }

  test("Sudoku01") {
    val nameFile = "input/sudoku01.txt"
    loadPuzzle(nameFile)
    display(puzzle)
    initList()
    val sudokuInput = getPuzzle
    print(sudokuInput)
    //NakedPairs.nakedPair(0,0)
  }*/

}
