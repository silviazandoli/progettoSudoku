package resolutionAlgorithm

import utility.{dimSudoku, matList}


object NakedPairs {

  var coupleFound: (Int, Int) = (-1, -1)

  def findCouple(rowCol: Int, flag: Boolean): Unit =  if (flag) {
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

  def findCoupleSubSquare(row: Int) = {
    var found = 0
    var fist = -1
    var second = -1
    var finish = 0
    var start = 0
    row match {
      case 0 | 1 | 2 =>
        start = 0
        finish = 3
      case 3 | 4 | 5 =>
        start = 3
        finish = 6
      case 6 | 7 | 8 =>
        start = 6
        finish = 9
    }
    (1 to 8).foreach(i => {
      (2 to 9).foreach(j => {
        for{
          k<-start until (finish)
          n<- start until (finish)
          if matList (k)(n) != Nil && matList (k)(n).size == 2 && i != j && matList (k)(n).contains (i) && matList (k)(n).contains (j)
        } {
          println(" "+ k + " " +i)
          found = found + 1

          if (found == 1) {
            fist = k // prima volta entra se trova una coppia e assegna quella k a first
            coupleFound = (i, j) //contiene i due numeri che sono uguali
          }
          if (found == 2) second = k // seconda coppia, assegna second
        }
      })
    })
    found match {
      case 2 => (fist, second) //restituisce le posizioni
      case _ => (-1, -1)
    }
  }

  def findCoupleInRow(row: Int): (Int, Int) = {
    var found = 0
    var fist = -1
    var second = -1
    (1 to 8).foreach(i => {
      (2 to 9).foreach(j => {
        for {
          k <- 0 until dimSudoku
          if matList(row)(k) != Nil && matList(row)(k).size == 2 && i!=j && matList(row)(k).contains(i) && matList(row)(k).contains(j)
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
          if matList(k)(col) != Nil && matList(k)(col).size == 2 && i!=j && matList(k)(col).contains(i) && matList(k)(col).contains(j)
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
    val n2 = coupleFound._2
    for {k <- 0 until (dimSudoku)} {
      if (k != first && k != second) {
        removeElementRow((row,first,second),n1)
        removeElementRow((row,first,second), n2)
      }
    }
  }

  def updateColList(col: Int, first: Int, second: Int, coupleFound: (Int, Int)) = {
    val n1 = coupleFound._1
    val n2 = coupleFound._2
    for {k <- 0 until (dimSudoku)} {
      if (k != first && k != second) {
        removeElementCol((first,second, col), n1)
        removeElementCol((first,second, col), n2)
      }
    }
  }
  def removeElementRow(rowCol: (Int, Int,Int), elem: Int): Unit = {
    val row = rowCol._1
    val col1 = rowCol._2
    val col2 = rowCol._3
    for {
      i <- 0 until dimSudoku
    } yield {
      if (i != col1 && i!= col2 && matList(row)(i) != null) matList(row)(i) = matList(row)(i).filter(e => e != elem)
    }
  }
  def removeElementCol(rowCol: (Int, Int,Int), elem: Int): Unit = {
    val row1 = rowCol._1
    val row2 = rowCol._2
    val col = rowCol._3
    for {
      i <- 0 until dimSudoku
    } yield {
      if (i != row1 && i!= row2 && matList(i)(col) != null) matList(i)(col) = matList(i)(col).filter(e => e != elem)
    }
  }
}
