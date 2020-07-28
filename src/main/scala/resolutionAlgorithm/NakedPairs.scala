package resolutionAlgorithm

import utility.{dimSudoku, matList}


object NakedPairs {

  var coupleFound: (Int, Int) = (-1, -1)



  def findCouple(rowCol: Int, flag: Boolean): Unit = {
    if (flag) {
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

  def findCoupleSubSquare(row1: Int, row2: Int):Unit = {
    var found = 0
    var first = -1
    var second = -1
    var row = row1
    (1 to 8).foreach(i => {
      (2 to 9).foreach(j => {
        for {
          k <- 0 until dimSudoku/3
          if matList(row)(k) != Nil && matList(row)(k).size == 2 && i != j && matList(row)(k).contains(i) && matList(row)(k).contains(j)
        } {
          found = found + 1

          if (found == 1) {
            row = row2
            first = k // prima volta entra se trova una coppia e assegna quella k a first
            coupleFound = (i, j) //contiene i due numeri che sono uguali
          }
          if (found == 2) second = k // seconda coppia, assegna second
        }
      })
    })
    /*found match {
      case 2 => (fist, second) //restituisce le posizioni
      case _ => (-1, -1)
    }*/
    if (first != -1){updateBlockList(row1,row2, first, second, coupleFound)}

  }

  def findCoupleInRow(row: Int): (Int,Int)= {
    var found = 0
    var first = -1
    var second = -1
    (1 to 8).foreach(i => {
      (2 to 9).foreach(j => {
        for {
          k <- 0 until dimSudoku
          if matList(row)(k) != Nil && matList(row)(k).size == 2 && i!=j && matList(row)(k).contains(i) && matList(row)(k).contains(j)
        } {
          found = found + 1

          if (found == 1) {
            first = k             // prima volta entra se trova una coppia e assegna quella k a first
            coupleFound = (i, j) //contiene i due numeri che sono uguali
          }
          if (found == 2) second = k // seconda coppia, assegna second
          println(coupleFound)
        }
      })
    })
    found match {
      case 2 => (first, second) //restituisce le posizioni
      case _ => (-1, -1)
    }
  }

  def findCoupleInColum(col: Int): (Int, Int) = {
    var found = 0
    var first = -1
    var second = -1

    (1 to 8).foreach(i => {
      (2 to 9).foreach(j => {
        for {
          k <- 0 until dimSudoku
          if matList(k)(col) != Nil && matList(k)(col).size == 2 && i!=j && matList(k)(col).contains(i) && matList(k)(col).contains(j)
        } {
          found = found + 1

          if (found == 1) {
            first = k
            coupleFound = (i, j)
          }
          if (found == 2) second = k
        }
      })
    })
    found match {
      case 2 => (first, second)
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
    def updateBlockList(col: Int, first: Int, second: Int, coupleFound: (Int, Int)): Unit = {

      val n1 = coupleFound._1
      val n2 = coupleFound._2
      val r = (row / 3) * 3
      val c = (col / 3) * 3

    /*
    aggiornamento sotto - quadrato
     */
    for {
      i <- r until r + 3
      j <- c until c + 3
      if i != row && j != col
      if matList(i)(j) != Nil
    } yield {
      matList(i)(j) = matList(i)(j).filter(e => e != elem)
    }
}
