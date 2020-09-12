package testProlog

import java.io.FileInputStream

import alice.tuprolog.{Prolog, Theory}
import org.scalatest.FunSuite

class sudokuPrologTest1 extends FunSuite {

  /* file sudokuProlog and engine with tests made by Zandoli and Pacini*/
  
  val engine = new Prolog
  val fileSudoku = "prolog/SudokuProlog.pl"

  engine.addTheory(new Theory(new FileInputStream(fileSudoku)))

  test("TestSudoku00") {
    val info = engine.solve("sudoku(1, 9, 6, 4, 7, 8, 3, 2, 5," +
      "\n        3, 8, 5, 2, 6, 1, 7, 4, 9," +
      "\n        4, 2, 7, 5, 3, _, 8, 1, 6," +
      "\n        8, 3, 2, 6, 5, 4, 1, 9, 7," +
      "\n        6, _, 9, _, 2, 7, 5, 3, 4," +
      "\n        7, 5, 4, 9, 1, 3, 6, 8, 2," +
      "\n        2, 7, 8, 1, 4, 6, 9, 5, 3," +
      "\n        9, _, 3, 7, 8, 5, 2, 6, 1," +
      "\n        5, 6, 1, 3, 9, 2, 4, 7, _).")

    val solution = "" + info.getSolution

    assert(solution == "sudoku(1,9,6,4,7,8,3,2,5," +
      "3,8,5,2,6,1,7,4,9," +
      "4,2,7,5,3,9,8,1,6," +
      "8,3,2,6,5,4,1,9,7," +
      "6,1,9,8,2,7,5,3,4," +
      "7,5,4,9,1,3,6,8,2," +
      "2,7,8,1,4,6,9,5,3," +
      "9,4,3,7,8,5,2,6,1," +
      "5,6,1,3,9,2,4,7,8)")
  }

  test("TestSudoku01") {
    val info = engine.solve("sudoku(_, 9, 6, 4, 7, 8, 3, 2, 5," +
      "\n        3, 8, 5, 2, 6, 1, 7, 4, 9," +
      "\n        4, 2, 7, 5, 3, 9, 8, 1, 6," +
      "\n        8, 3, 2, 6, 5, 4, 1, 9, 7," +
      "\n        6, 1, 9, _, 2, 7, 5, 3, 4," +
      "\n        7, 5, 4, 9, 1, 3, 6, 8, 2," +
      "\n        2, 7, 8, 1, 4, 6, 9, 5, 3," +
      "\n        9, 4, 3, 7, 8, 5, 2, 6, 1," +
      "\n        5, 6, 1, 3, 9, 2, 4, 7, 8).")

    val solution = "" + info.getSolution

    assert(solution == "sudoku(1,9,6,4,7,8,3,2,5," +
      "3,8,5,2,6,1,7,4,9," +
      "4,2,7,5,3,9,8,1,6," +
      "8,3,2,6,5,4,1,9,7," +
      "6,1,9,8,2,7,5,3,4," +
      "7,5,4,9,1,3,6,8,2," +
      "2,7,8,1,4,6,9,5,3," +
      "9,4,3,7,8,5,2,6,1," +
      "5,6,1,3,9,2,4,7,8)")
  }
}
