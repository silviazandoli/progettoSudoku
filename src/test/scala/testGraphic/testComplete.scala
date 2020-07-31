package testGraphic

import grafic.Sudoku.Sudoku
import org.scalatest.{BeforeAndAfter, FlatSpec}
import sudoku.MatListOperation.initList
import utility.getPuzzle
import sudoku.SudokuLoad.loadPuzzle
import grafic.{getPressed, masks, setPuzzleResolt, utentSolved}
import resolutionAlgorithm.FullExploration

class testComplete extends FlatSpec with BeforeAndAfter {

  val input = "input/"
  val outputSolved = "outputSolved/"

  object InitTest {
    def initTest(file: String) {
      loadPuzzle(file)
      initList()

      val sudokuSolver = FullExploration(getPuzzle)
      sudokuSolver.solve(0, 0)

      setPuzzleResolt(sudokuSolver.returnPuzzle())

      val sudoku = Sudoku()
      sudoku.create()
    }
  }

  after {
    /*
    la schermata si fà vedere all'utente per un secondo e mezzo
     */
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

    val rowPressed = getPressed._1
    val colPressed = getPressed._2
    if (rowPressed >= 0 && colPressed >= 0) {
      assert(masks(rowPressed)(colPressed))
    }
  }
}