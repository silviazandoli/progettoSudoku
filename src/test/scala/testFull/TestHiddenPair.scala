package testFull

import org.scalatest.FunSuite
import resolutionAlgorithm.HiddenPair
import resolutionAlgorithm.SudokuLoad.{display, loadPuzzle, puzzle}

class TestHiddenPair extends FunSuite {
  val nameFile = "input/sudoku01.txt"

  test("Hidden Pair") {
    //init
    loadPuzzle(nameFile, 0)
    println(puzzle.toString)



    display()
    //setup
    val possible=HiddenPair.possible(0,2,puzzle)
    val ml=HiddenPair.createMatlist(puzzle)


    println(ml)
    //verify
  }


}
