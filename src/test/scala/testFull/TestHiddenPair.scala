package testFull

import org.scalatest.FunSuite
import resolutionAlgorithm.HiddenPair
import resolutionAlgorithm.SudokuLoad.{display, loadPuzzle, nameFile, puzzle}

class TestHiddenPair extends FunSuite {

  test("pair") {
    //init
    loadPuzzle(nameFile, 0)
    println(puzzle.toString)



    display()
    //setup
    val ml=HiddenPair.createMatlist(puzzle)

    //println(ml)
    //verify
  }


}
