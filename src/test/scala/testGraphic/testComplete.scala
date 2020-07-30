package testGraphic

import grafic.Sudoku.Sudoku
import org.scalatest.{BeforeAndAfter, FlatSpec}
import sudoku.MatListOperation.initList
import utility.getPuzzle
import sudoku.SudokuLoad.loadPuzzle
import grafic.{getPressed, masks, utentSolved}
import resolutionAlgorithm.FullExploration

class testComplete extends FlatSpec with BeforeAndAfter {

  val input = "input/"
  val outputSolved = "outputSolved/"

  "A solved game" should "have all true in mask" in {
    val fileSolved = outputSolved+"sudoku01.txt"
    loadPuzzle(fileSolved)
    initList()

    val sudokuSolver = FullExploration(getPuzzle)
    sudokuSolver.solve(0,0)

    val sudoku = Sudoku(sudokuSolver.returnPuzzle())
    sudoku.create()
    assert(utentSolved())

    /*
    la schermata si fà vedere all'utente per un secondo e mezzo
     */
    Thread.sleep(1500)
  }

  "A not solved game" should "have not all true in mask" in {
    val fileLoad = input+"sudoku01.txt"
    loadPuzzle(fileLoad)
    initList()

    val sudokuSolver = FullExploration(getPuzzle)
    sudokuSolver.solve(0,0)

    val sudoku = Sudoku(sudokuSolver.returnPuzzle())
    sudoku.create()
    assert(!utentSolved())

    /*
    la schermata si fà vedere all'utente per un secondo e mezzo
     */
    Thread.sleep(1500)
  }

  "A game" should "have not all true in mask" in {
    val fileLoad = input+"sudoku01.txt"
    loadPuzzle(fileLoad)
    initList()

    val sudokuSolver = FullExploration(getPuzzle)
    sudokuSolver.solve(0,0)

    val sudoku = Sudoku(sudokuSolver.returnPuzzle())
    sudoku.create()

    /*
    si dà tempo all'utente di 7 secondi
     */
    Thread.sleep(7000)

    val rowPressed = getPressed._1
    val colPressed = getPressed._2
    
    if (rowPressed >= 0 && colPressed >= 0) {
      assert(masks(rowPressed)(colPressed))
    }
  }
}
