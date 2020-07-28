package testFull

import org.scalatest.FunSuite
import sudoku.SudokuLoad.loadPuzzle
import sudoku.MatListOperation.initList
import utility.getPuzzle
import resolutionAlgorithm.NakedPairs._
import utility._



class TestNakedPair extends FunSuite {
  test("Sudoku test per matlist Row") {

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
    val nameFile = "input/sudokuTest2.txt"
    val nameSolved = "outputSolved/sudoku02.txt"
    loadPuzzle(nameFile)

    display(puzzle)
    initList()
    for (i <- 6 to 8) {
      for(j <- 0 to 3)
        println("MatList riga " + i + " colonna" + j + " è " + matList(i)(j).toString)
    }
    val initMat = utility.matList(7)(2)
    val sudokuInput = getPuzzle
    findCoupleSubSquare(6,0)
    val sudokuSolved = getPuzzle

    //assert(sudokuInput(0)(4) == sudokuSolved(0)(4))
    //assert(sudokuInput(5)(2) == sudokuSolved(5)(2))

    for (i <- 6 to 8) {
      for(j <- 0 to 3)
        println("MatList DOPO riga " + i + " colonna" + j + " è " + matList(i)(j).toString)
    }
    val finishMat = utility.matList(7)(2)

    println("matList iniziale " + initMat)
    println("matList finale "+ finishMat)
    assert(initMat != finishMat)
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
