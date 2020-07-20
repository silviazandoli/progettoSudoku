package resolutionAlgorithm

import resolutionAlgorithm.SudokuMatrix.matList
import SudokuLoad.dimSudoku

object NakedPairs {

  def solve(row: Int, col: Int): Unit = {
    for (i <- 0 until dimSudoku) { //per ogni riga
      for (j <- 0 until dimSudoku) { // per ogni colonna
        //controllo che sia di lunghezza
        if (i != row && j != col && matList(i)(j).size == 2 && matList(i)(j) == matList(row)(col)) {
          /*rimuovo da tutte le altre quei due elementi*/
          for(k <- 0 until dimSudoku){
            /* TODO: Cancellare gli elementi che sono presenti ed uguali in matList di Row/Col e quelli di i/j da tutta la riga/colonna */
            /*
            if (matList(i)(k).find(matList(i)(j)(0)) || (matList(i)(k).find(matList(i)(j)(1)))){
              matList(i)(k)()
            }
             */
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
