package testFull

import org.scalatest.FunSuite
import resolutionAlgorithm.FullExploration.solve
import sudoku.SudokuLoad.loadPuzzle
import sudoku.MatListOperation.initList
import utility.getPuzzle
import resolutionAlgorithm.NakedPairs._
import utility._



class TestNakedPair extends FunSuite {
  test("Sudoku test per matlist") {

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

  test("subSquare") {
    //init
    val nameFile = "input/sudoku04.txt"
    val nameSolved = "outputSolved/sudoku02.txt"
    loadPuzzle(nameFile)

    display(puzzle)
    initList()
    /*for (i <- 0 to 8) {
      println("MatList riga " + i + " colonna" + 0 + " è " + matList(i)(2).toString)
    }
    val initMat = utility.matList(0)(8)*/
    val sudokuInput = getPuzzle
    findCoupleSubSquare(0,2)
    val sudokuSolved = getPuzzle

    assert(sudokuInput(0)(4) == sudokuSolved(0)(4))
    assert(sudokuInput(5)(2) == sudokuSolved(5)(2))

    /*for (i <- 0 to 8) {
      println("MatList DOPO riga " + i + " colonna" + 0 + " è " + matList(i)(2).toString)
    }
    val finishMat = utility.matList(0)(8)*/

    /*println("matList iniziale " + initMat)
    println("matList finale "+ finishMat)
    assert(initMat != finishMat)*/
  }
  test("Sudoku") {
    val nameFile = "input/sudoku01.txt"

    loadPuzzle(nameFile)
    initList()
    val sudokuInput = getPuzzle
    findCouple(0,true)
    val sudokuSolved = getPuzzle

    assert(sudokuInput(0)(4) == sudokuSolved(0)(4))
    assert(sudokuInput(5)(2) == sudokuSolved(5)(2))

  }

  test("Sudoku Test Row") {
    val nameFile = "input/sudokuText.txt"
    loadPuzzle(nameFile)

    display(puzzle)
    initList()
    for (i <- 0 to 8) {
      println("MatList riga " + 2 + " colonna" + i + " è " + matList(2)(i).toString)
    }

    val initMat = utility.matList(2)(4)
    findCouple(2,true)
    for (i <- 0 to 8) {
      println("MatList DOPO riga " + 2 + " colonna" + i + " è " + matList(2)(i).toString)
    }

    val finishMat = utility.matList(2)(4)

    println("matList iniziale " + initMat)
    println("matList finale "+ finishMat)
    assert(initMat != finishMat)
  }
/*
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
