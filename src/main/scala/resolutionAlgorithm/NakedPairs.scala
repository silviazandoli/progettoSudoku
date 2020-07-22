package resolutionAlgorithm

import sudoku.MatListOperation.matList
import sudoku.SudokuLoad.dimSudoku

object NakedPairs {

  val matList: Array[Array[List[Int]]] = Array.ofDim[List[Int]](dimSudoku, dimSudoku)
  val list: Array[List[Int]] = Array.ofDim[List[Int]](2)

  // TODO: SOLUZIONE 1 QUELLA INIZIALE
  /*def solve(row: Int, col: Int): Unit = {
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
  }*/

  // TODO : VARIANTE SUCCESSIVA
  def solve(row: Int, col: Int): Unit = {
    cycle()
    //controllo che sia di lunghezza 2
    if (matList(row)(col).size == 2) {
      list.appended(row,col)
      /*rimuovo da tutte le altre quei due elementi*/
      if(list.size == 2) {
        for (k <- 0 until dimSudoku) {
          for (number <- matList(row)(k)) {
            if (number == matList(row)(col)(0) || number == matList(row)(col)(1)) {
              /* rimuovere elemento dalla lista*/
              /* TODO: FARE UNA FUNZIONE APPOSITA PER ELIMINAZIONE*/
              matList(row)(k) = Nil
            }
          }
        }
        //eliminare elementi dalla lista
        //list = list.dropWhile(list.size == 0)
      }
    }
  }

  def cycle() = {
    for(i<-0 until dimSudoku) {
      for(j<-0 until dimSudoku) {
        solve(i,j)
        println(" matList nella posizione " + i + "," + j+ " è " + matList(i)(j))
      }
    }

  }
}
