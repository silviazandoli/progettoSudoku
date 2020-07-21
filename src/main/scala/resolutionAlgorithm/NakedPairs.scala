package resolutionAlgorithm

import resolutionAlgorithm.SudokuMatrix.matList
import SudokuLoad.dimSudoku

object NakedPairs {


  def solve(row: Int, col: Int): Unit = {
    for (i <- 0 until dimSudoku) { //per ogni riga
      for (j <- 0 until dimSudoku) { // per ogni colonna
        //controllo che sia di lunghezza 2
        if (i != row && j != col && matList(i)(j).size == 2 && matList(i)(j) == matList(row)(col)) {
          /*rimuovo da tutte le altre quei due elementi*/
          for(k <- 0 until dimSudoku){
            for(number <- matList(i)(k)){
              if (number == matList(i)(j).head || number == matList(i)(j)(1)){
                /* rimuovere elemento dalla lista*/ /* TODO: FARE UNA FUNZIONE APPOSITA*/
                matList(i)(k) = Nil
              }
            }
          }
        }
      }
      /*//for del blocco 3x3
      for (k <- 0 until dimSudoku) {
        for (z <- 0 until dimSudoku) {
          print("blocco")
        }
      }*/
    }
  }
  /*def createMatlist(puzzle: Array[Array[Int]]) = {
    for(i<-0 until dimSudoku) {
      for(j<-0 until dimSudoku) {
        matList(i)(j)=solve(i,j,puzzle)
        println(" matList nella posizione " + i + "," + j+ " è " + matList(i)(j))
      }
    }

  }*/
}
