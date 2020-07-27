package testFull

import org.scalatest.FunSuite
import resolutionAlgorithm.FullExploration.solve
import sudoku.SudokuLoad.loadPuzzle
import sudoku.MatListOperation.initList
import utility.getPuzzle
import resolutionAlgorithm.NakedPairs._
import utility._



class TestNakedPair extends FunSuite {
  test("Sudoku01") {

    val nameFile = "input/sudokuText.txt"
    loadPuzzle(nameFile)

    display(puzzle)
    initList()
    for (i <- 0 to 8) {
      println("MatList riga " + 0 + " colonna" + i + " è " + matList(0)(i).toString)
    }

    val initMat = utility.matList(0)(4)
    findCouple(0,true)
    for (i <- 0 to 8) {
      println("MatList DOPO riga " + 0 + " colonna" + i + " è " + matList(0)(i).toString)
    }

    val finishMat = utility.matList(0)(4)

    println("matList iniziale " + initMat)
    println("matList finale "+ finishMat)
    assert(initMat != finishMat)
  }

  /*test("Naked Pair Sudoku02") {
    //init
    val nameFile = "input/sudoku04.txt"
    val nameSolved = "outputSolved/sudoku02.txt"
    loadPuzzle(nameFile)

    display(puzzle)
    initList()
    for (i <- 0 to 8) {
      println("MatList riga " + i + " colonna" + 0 + " è " + matList(i)(2).toString)
    }
    val initMat = utility.matList(0)(8)
    //printMatrix()
    findCouple(1,false)

    for (i <- 0 to 8) {
      println("MatList DOPO riga " + i + " colonna" + 0 + " è " + matList(i)(2).toString)
    }
    val finishMat = utility.matList(0)(8)

    println("matList iniziale " + initMat)
    println("matList finale "+ finishMat)
    assert(initMat != finishMat)
  }*/
  test("Sudoku") {
    val nameFile = "input/sudoku01.txt"

    loadPuzzle(nameFile)
    initList()
    findCouple(0,true)
    val sudokuInput = getPuzzle

    solve(0, 0)
    val sudokuSolved = getPuzzle

    assert(sudokuInput(0)(4) == sudokuSolved(0)(4))
    assert(sudokuInput(5)(2) == sudokuSolved(5)(2))

  }
  /*
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
