package resolutionAlgorithm

import utility.{dimSudoku, matList}
import sudoku.MatListOperation.updateList


object NakedPairsVariant {

  var coupleFound = (-1, -1)

  def findCouple(rowCol: Int, flag: Boolean): Unit = if (flag) {
    val posRows = findCoupleInRow(rowCol) //ha una coppia di posizioni
    val first = posRows._1 //primo elemento di posRows
    val second = posRows._2 //secondo elemento di posRows

    if (first != -1) {updateRowList(rowCol, first, second, coupleFound)}

  } else {
    val posCol = findCoupleInColum(rowCol)
    val first = posCol._1
    val second = posCol._2

    if (first != -1) {updateColList(rowCol,first, second, coupleFound)}
  }

  def findCoupleSubSquare(row1: Int, row2: Int) = {

  }

  def findCoupleInRow(row: Int): (Int, Int) = {
    var found = 0
    var fist = -1
    var second = -1
    (1 to 8).foreach(i => {
      (2 to 9).foreach(j => {
        for {
          k <- 0 until dimSudoku
          if matList(row)(k) != Nil && i!=j && matList(row)(k).contains(i) && matList(row)(k).contains(j)
        } {
          found = found + 1

          if (found == 1) {
            fist = k             // prima volta entra se trova una coppia e assegna quella k a first
            coupleFound = (i, j) //contiene i due numeri che sono uguali
          }
          if (found == 2) second = k // seconda coppia, assegna second
        }
      })
    })
    println("first: "+ fist + " second: "+second)
    println("coupleFound" + coupleFound)
    found match {
      case 2 => (fist, second) //restituisce le posizioni
      case _ => (-1, -1)
    }
  }

  def findCoupleInColum(col: Int): (Int, Int) = {
    var found = 0
    var fist = -1
    var second = -1

    (1 to 8).foreach(i => {
      (2 to 9).foreach(j => {
        for {
          k <- 0 until dimSudoku
          if matList(k)(col) != Nil && matList(k)(col).contains(i) && matList(k)(col).contains(j)
        } {
          found = found + 1

          if (found == 1) {
            fist = k
            coupleFound = (i, j)
          }
          if (found == 2) second = k
        }
      })
    })
    found match {
      case 2 => (fist, second)
      case _ => (-1, -1)
    }
  }

  def updateRowList(row: Int ,first: Int, second: Int, coupleFound: (Int, Int)) = {
    //first è la prima posizione di quel numero
    //second è la seconda k
    //coupleFound ??
    val n1 = coupleFound._1
    println("elemento 1: "+n1)
    val n2 = coupleFound._2
    println("elemento 2: "+n2)
    for {k <- 0 until (dimSudoku)} {
      if (k != first && k != second) {
        println("elimino elemento 1: "+n1 + "da " +row + " - "+ k)
        updateList((row, k), n1)
        updateList((row, k), n2)
      }
    }
  }

  def updateColList(col: Int, first: Int, second: Int, coupleFound: (Int, Int)) = {
    val n1 = coupleFound._1
    println("elemento 1: "+n1)
    val n2 = coupleFound._2
    println("elemento 2: "+n2)
    for {k <- 0 until (dimSudoku)} {
      if (k != first && k != second) {
        println("elimino elemento 1: "+n1 + "da " +k + " - "+ col)
        updateList((k, col), n1)
        updateList((k, col), n2)
      }
    }
  }
}
