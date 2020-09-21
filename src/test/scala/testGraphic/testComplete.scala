package testGraphic

import grafic.Sudoku.Sudoku
import org.scalatest.{BeforeAndAfter, FlatSpec}
import sudoku.MatListOperation.initList
import utility.getPuzzle
import sudoku.SudokuLoad.loadPuzzle
import grafic.{graficSet, graficGet, utentSolved, masks}
import resolutionAlgorithm.FullExploration

/**
 * Made by Pacini
 */
class testComplete extends FlatSpec with BeforeAndAfter {

  val input = "input/easy/"
  val outputSolved = "outputSolved/"

  object InitTest {

    /**
     * Load a file for sudoku, solve it and display the game,
     * (this can be uncompleted)
     * @param file to load
     */
    def initTest(file: String) {
      loadPuzzle(file)
      initList()

      val sudokuSolver = FullExploration(getPuzzle)
      sudokuSolver.solve(0, 0)

      graficSet[Array[Array[Int]]](sudokuSolver.returnPuzzle())

      val sudoku = Sudoku()
      sudoku.create()
    }
  }

  after {
    /* the screen can be see to the user for one
    and half second */
    Thread.sleep(500)
  }
  
  "A solved game" should "have all true in mask" in {
    InitTest.initTest(outputSolved+"sudoku01.txt")
    assert(utentSolved())
  }

  "A not solved game" should "have not all true in mask" in {
    InitTest.initTest(input+"sudoku01.txt")
    assert(!utentSolved())
  }

  "A game" should "have not all true in mask" in {
    InitTest.initTest(input+"sudoku01.txt")
    Thread.sleep(6500)
    val rowCol = graficGet[(Int, Int)]
    val rowPressed = rowCol._1
    val colPressed = rowCol._2
    if (rowPressed >= 0 && colPressed >= 0) {
      assert(masks(rowPressed)(colPressed))
    }
  }
}
