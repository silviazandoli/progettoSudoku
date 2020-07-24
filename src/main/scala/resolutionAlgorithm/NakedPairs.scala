package resolutionAlgorithm
import utility.{dimSudoku, matList, puzzle}
import sudoku.MatListOperation.updateList

import scala.collection.mutable.ListBuffer

object NakedPairs {

  var list: Array[List[Int]] = Array.ofDim[List[Int]](dimSudoku)
  var index: Int = 0
  var number1: Int = 0
  var number2: Int = 0

  case class PossiblePair(cell1: Int, cell2: Int, intersection: Set[Set[Int]])

  //var list = new ListBuffer[Int]()

  // TODO : VARIANTE SUCCESSIVA

  def nakedPair(row:Int, col: Int): Unit ={
    val rows = (0 until dimSudoku).toList.map(checkRow)
    rows.zipWithIndex.foreach(t => {
      val row = t._2
      t._1.foreach(p => {
        val newValues = p.intersection.head.toList
        matList(row)(p.cell1) = newValues
        matList(row)(p.cell2) = newValues
      })
    })
    print(rows)
    val cols = (0 until dimSudoku).toList.map(checkColumn)
    cols.zipWithIndex.foreach(t => {
      val col = t._2
      t._1.foreach(p => {
        val newValues = p.intersection.head.toList
        matList(p.cell1)(col) = newValues

        matList(p.cell2)(col) = newValues
      })
    })
    print(cols)
  }

  def checkRow(row: Int) = {

    //it gets the squares of the matList which have more than one element
    val ml = matList(row).toList.zipWithIndex.filter(_._1.size == 2)
    // val pippo:Nothing=ml
    check(ml)

  }

  def check(ml: List[(List[Int], Int)]): List[PossiblePair] = {

    // val pippo:Nothing=ml
    //possiblePairs contains all the possibles pairs with their coordinates
    val possiblePairs = ml.map(couples).toSet.subsets(2).toList.map(e => {
      val val1 = e.head
      val val2 = e.tail.head
      val intersection = val1._1.toSet.intersect(val2._1.toSet)
      PossiblePair(val1._2, val2._2, intersection)

    }).filter(_.intersection.nonEmpty)

    val flattenPairs = possiblePairs.flatMap(p => {
      p.intersection.map(pair => {
        PossiblePair(p.cell1, p.cell2, Set(pair))
      })
    })
    //it finds the hidden pairs
    val nakedPairs = flattenPairs.filter(p => {
      val cell1 = p.cell1
      val cell2 = p.cell2
      val exclusion = ml.filter(_._2 != cell1).filter(_._2 != cell2).flatMap(e => e._1.toSet).toSet
      //we have to compare inside intersection elem per elem. We get the first
      val c1 = exclusion.contains(p.intersection.head.head)
      //we have to compare inside intersection elem per elem. We get the second. tail contains more element so we get the head
      val c2 = exclusion.contains(p.intersection.head.tail.head)

      !c1 && !c2


    })
    nakedPairs
  }

  def couples(l: (List[Int], Int)): (List[Set[Int]], Int) = {
    val l1 = l._1.toSet.subsets(2).toList

    //memorizzo gli indici che mi sono arrivati su l
    //I store the indexes that got to me on l
    val l2 = l._2
    (l1, l2)
  }

  def checkColumn(col: Int) = {

    //it gets the squares of the matList which have more than one element
    val ml = matList.map(_ (col)).zipWithIndex.filter(_._1.size ==2 ).toList
    //  println(ml.toList)
    check(ml)

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
