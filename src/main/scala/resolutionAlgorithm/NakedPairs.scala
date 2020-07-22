package resolutionAlgorithm
import utility.{dimSudoku, matList, puzzle}

import scala.Boolean
import scala.collection.mutable.ListBuffer

object NakedPairs {

  //val list: Array[List[Int]] = Array.ofDim[List[Int]](2)
  var list = new ListBuffer[Int]()

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
    //controllo che sia di lunghezza 2
    if (matList(row)(col).size == 2) {
      val number1: Int = matList(row)(col)(0)
      val number2: Int = matList(row)(col)(1)
      list += number1
      list += number2
      /*rimuovo da tutte le altre quei due elementi*/
      if (list.size == 4 && checkList(list)) {
        for (k <- 0 until dimSudoku) {
          if ((number1 == matList(row)(k)(0) || number2 == matList(row)(k)(1) ||
            number1 == matList(row)(k)(1) || number2 == matList(row)(k)(0)) && (k != col))
          /* rimuovere elemento dalla lista*/
          /* TODO: FARE UNA FUNZIONE APPOSITA PER ELIMINAZIONE*/
          matList(row)(k) = Nil
        }
      }
      //eliminare elementi dalla lista
      list = list.filter(_ > 0)
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
  def checkList(list: ListBuffer[Int]): Boolean ={
    if((list.head==list(2)|| list(0)==list(3))&&(list(1) == list(2) || list(1)==list(3))) {
      true
    } else {
      false
    }
  }
}
