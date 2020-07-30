package testGraphic

import grafic.Sudoku.Sudoku
import org.scalatest.FlatSpec
import resolutionAlgorithm.FullExploration
import sudoku.MatListOperation.initList
import utility.{getPuzzle, displayNoTitle, dimSudoku}
import sudoku.SudokuLoad.loadPuzzle
import grafic.{masks, utentSolved}

class testComplete extends FlatSpec {

  "A complete puzzle" should "have all true in matrix game" in {
    loadPuzzle("tempInput/sudoku01.txt")
    initList()

    val sudokuSolver = FullExploration(getPuzzle)
    sudokuSolver.solve(0,0)

    val sudoku = Sudoku(sudokuSolver.returnPuzzle())
    sudoku.create()

    /*
    loadPuzzle(file.getAbsolutePath)
    initList()

    val sudokuSolver = FullExploration(getPuzzle)
    sudokuSolver.solve(0,0)

    val sudoku = Sudoku(sudokuSolver.returnPuzzle())
    sudoku.create()
     */

    //assert(utentSolved())
  }
}
