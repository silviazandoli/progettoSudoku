package testFull

import org.scalatest.FunSuite
import resolutionAlgorithm.HiddenPair
import resolutionAlgorithm.SudokuLoad.{display, loadPuzzle, nameFile, puzzle}
import resolutionAlgorithm.SudokuMatrix.matList
class TestHiddenPair extends FunSuite {

  test("pair") {
    //init
    loadPuzzle(nameFile, 0)
    println(puzzle.toString)

    println(matList)

    display()
    //setup
    val ml=HiddenPair.createMatlist(puzzle)
    println(ml)
    //verify
  }


}
