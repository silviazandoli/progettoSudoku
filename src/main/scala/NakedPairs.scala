import SudokuMatrix.matList
import SudokuLoad.dimSudoku

import scala.annotation.tailrec
object NakedPairs {

  def solve(row: Int, col: Int): Unit = {
    for (i <- 0 until dimSudoku) { //per ogni riga
      for (j <- 0 until dimSudoku) { // per ogni colonna
        //controllo che sia di lunghezza
        if (matList(i)(j).size == 2 && matList(i)(j) == matList(row)(col) && i != row && j != col) {
          /*rimuovo da tutte le altre quei due elementi*/
          for(k <- 0 until dimSudoku){
            // TODO: Cancellare gli elementi che sono presenti ed uguali in matList di Row/Col e quelli
            // di i/j da tutta la riga/colonna.
          }
        }
      }
      //for del blocco 3x3
      for (k <- 0 until dimSudoku) {
        for (z <- 0 until dimSudoku) {
          print("blocco")
        }
      }
    }
  }
}
  /*def solve(row: Int, col: Int): Boolean = {
    var result: java.lang.Boolean = false
    var k: Int = 0
    while (k < 9 && !result) {
      if (naked_pair_unit(puzzle(k) || naked_pair_unit(puzzle(k)) ||
        naked_pair_unit(box(k))) {
        result = true
      }
      { k += 1; k - 1 }
    }
    return result;
  }
  def naked_pair_unit(C: Int[9][2]): Unit ={

  }*/

