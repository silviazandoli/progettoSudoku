package testFull

import org.scalatest.FunSuite
import sudoku.SudokuLoad.loadPuzzle
import resolutionAlgorithm.{HiddenPair, NakedPairs}
import utility.{display, puzzle}

class TestNakedPair extends FunSuite {

  val nameFile = "input/sudoku01.txt"
  test("Naked Pair") {
    //init
    loadPuzzle(nameFile)
    println(puzzle.toString)



    display(puzzle)
    //setup

    //val ml=HiddenPair.createMatlist(puzzle) -> TODO: caricare matList di valori, problema: restituisce Unit
    val resolve=NakedPairs.solve(0,2)
    //val ml=NakedPairs.createMatlist(puzzle)


    //println(ml)
    //verify
  }


}
