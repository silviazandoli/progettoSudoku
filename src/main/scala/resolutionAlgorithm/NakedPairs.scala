package resolutionAlgorithm
import utility.{dimSudoku, matList, puzzle}
import sudoku.MatListOperation.updateList

import scala.collection.mutable.ListBuffer

object NakedPairs {

  var list: Array[List[Int]] = Array.ofDim[List[Int]](dimSudoku)
  var index: Int = 0
  var number1: Int = 0
  var number2: Int = 0

  //var list = new ListBuffer[Int]()

  // TODO : VARIANTE SUCCESSIVA

  def nakedPair(row:Int, col: Int): Unit ={
    val rows = (0 until dimSudoku).toList.map(checkRow)
    print(rows)
    val cols = (0 until dimSudoku).toList.map(checkColumn)
    print(cols)
  }

  def checkRow(row: Int) = {

    //it gets the squares of the matList which have more than one element
    val ml = matList(row).toList.zipWithIndex.filter(_._1.size > 1)
    // val pippo:Nothing=ml

  }

  def checkColumn(col: Int) = {

    //it gets the squares of the matList which have more than one element
    val ml = matList.map(_ (col)).zipWithIndex.filter(_._1.size > 1).toList
    //  println(ml.toList)

  }






  /*def solve(row: Int, col: Int): Unit = {
    //controllo che sia di lunghezza 2
    if (matList(row)(col).size == 2) {

      //list(index).head +=(row)
      //list(index)(1) += col

      index += 1;
      println("lista:::::::::::::::" + list)
      println("-------------------------------------row: " + row + " col: "+ col)
      /*rimuovo da tutte le altre quei due elementi*/
      if (list.size > 2 && checkList(list)) {
        println("-------------dentro")
        for (k <- 0 until dimSudoku) {
          if (k != col)
            if (number1 == matList(row)(k).head || number1 == matList(row)(k)(1))
              updateList((row, col), number1)
            if (number2 == matList(row)(k).head || number2 == matList(row)(k)(1))
              updateList((row, col), number2)
        }
      }

    }
    index = 0
  }

  def cycle() = {
    for(i<-0 until dimSudoku-1) {
      for(j<-i+1 until dimSudoku) {
        solve(i,j)
        println(" matList nella posizione " + i + "," + j+ " è " + matList(i)(j))
      }
    }

  }
  def checkList(list: Array[List[Int]]): Boolean ={
    var flag = false
    for (m <- list.indices)
      for(n <- m+1 until(list.size-1)){
        var n1,n2,n3,n4 : Int = 0
        n1 = list(m).head
        n2 = list(m)(1)
        n3 = list(n).head
        n4 = list(n)(1)
        if (matList(n1)(n2) == matList(n3)(n4)) {
          flag = true
          //eliminare elementi dalla lista
          //list = removeList(list)
          number1 = matList(n1)(n2).head
          number2 = matList(n3)(n4)(1)
        }
      }
    flag
  }
  def removeList(list: Array[List[Int]]) {
    for (i <- list.indices)
      list(i).filter(_ > 0)
  }*/
}
