package resolutionAlgorithm

import utility.{dimSudoku, matList}


object NakedPairs {

  var coupleFound: (Int, Int) = (-1, -1)


  def findCouple(rowCol: Int, flag: Boolean): Unit = {
    if (flag) {
      val posRows = findCoupleInRow(rowCol) //ha una coppia di posizioni
      val first = posRows._1 //primo elemento di posRows
      val second = posRows._2 //secondo elemento di posRows
      if (first != -1) {
        updateRowList(rowCol, first, second, coupleFound)
      }

    } else {
      val posCol = findCoupleInColum(rowCol)
      val first = posCol._1
      val second = posCol._2

      if (first != -1) {
        updateColList(rowCol, first, second, coupleFound)
      }
    }
  }

  def findCoupleSubSquare(row: Int, col: Int): Unit = {
    var found = 0
    var first = (-1, -1)
    var second = (-1, -1)
    val r2 = (row / 3) * 3
    val c2 = (col / 3) * 3
    (1 to 8).foreach(i => {
      (2 to 9).foreach(j => {
        for {
          r <- r2 until r2 + 3
          c <- c2 until c2 + 3
          if matList(r)(c) != Nil && matList(r)(c).size == 2 && i != j && matList(r)(c).contains(i) && matList(r)(c).contains(j)
        } {
          found = found + 1

          if (found == 1) {
            //row = row2
            first = (r, c) // prima volta entra se trova una coppia e assegna quella k a first
            coupleFound = (i, j) //contiene i due numeri che sono uguali
          }
          if (found == 2) second = (r, c) // seconda coppia, assegna second
        }
      })
    })
    //first e second hanno le posizioni, couplefound ha i numeri
    if (first != -1) {
      updateBlockList(first, second, coupleFound)
    }

  }

  def findCoupleInRow(row: Int): (Int, Int) = {
    var found = 0
    var first = -1
    var second = -1
    (1 to 8).foreach(i => {
      (2 to 9).foreach(j => {
        for {
          k <- 0 until dimSudoku
          if matList(row)(k) != Nil && matList(row)(k).size == 2 && i != j && matList(row)(k).contains(i) && matList(row)(k).contains(j)
        } {
          println(matList(row)(k) + "found +1 "+ row + k)
          found = found + 1

          if (found == 1) {
            first = k // prima volta entra se trova una coppia e assegna quella k a first
            coupleFound = (i, j) //contiene i due numeri che sono uguali
          }
          if (found == 2) {
            second = k // seconda coppia, assegna second
          }
        }
      })
    })
    println(found)
    found match {
      case 2 || 4 => (first, second) //restituisce le posizioni
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
          if matList(k)(col) != Nil && matList(k)(col).size == 2 && i != j && matList(k)(col).contains(i) && matList(k)(col).contains(j)
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
      case 2 || 4 => (first, second)
      case _ => (-1, -1)
    }
  }

  def updateRowList(row: Int, first: Int, second: Int, coupleFound: (Int, Int)):Unit = {
    //first è la prima posizione di quel numero
    //second è la seconda k
    //coupleFound ??
    val n1 = coupleFound._1
    val n2 = coupleFound._2
    for {k <- 0 until dimSudoku} {
      if (k != first && k != second) {
        removeElementRow((row, first, second), n1)
        removeElementRow((row, first, second), n2)
      }
    }
  }

  def updateColList(col: Int, first: Int, second: Int, coupleFound: (Int, Int)):Unit = {
    val n1 = coupleFound._1
    val n2 = coupleFound._2
    for {k <- 0 until dimSudoku} {
      if (k != first && k != second) {
        removeElementCol((first, second, col), n1)
        removeElementCol((first, second, col), n2)
      }
    }
  }

  def removeElementRow(rowCol: (Int, Int, Int), elem: Int): Unit = {
    val row = rowCol._1
    val col1 = rowCol._2
    val col2 = rowCol._3
    for {
      i <- 0 until dimSudoku
    } yield {
      if (i != col1 && i != col2 && matList(row)(i) != null) matList(row)(i) = matList(row)(i).filter(e => e != elem)
    }
  }

  def removeElementCol(rowCol: (Int, Int, Int), elem: Int): Unit = {
    val row1 = rowCol._1
    val row2 = rowCol._2
    val col = rowCol._3
    for {
      i <- 0 until dimSudoku
    } yield {
      if (i != row1 && i != row2 && matList(i)(col) != null) matList(i)(col) = matList(i)(col).filter(e => e != elem)
    }
  }

  def updateBlockList(first: (Int, Int), second: (Int, Int), coupleFound: (Int, Int)): Unit = {

    val n1 = coupleFound._1 //primo numero
    val n2 = coupleFound._2 //secondo numero
    val r1 = first._1 //riga 1
    val r2 = second._1 //riga 1
    val c1 = first._2 //riga 1
    val c2 = second._2 //riga 1

    for {i <- r1 until r1 + 3
         j <- c1 until c1 + 3} {
      if (j != c1 && j != c2 && i != r1 && i != r2) {
        removeElementBlock(first, second, n1)
        removeElementBlock(first, second, n2)
      }
    }
  }

  def removeElementBlock(rowCol1: (Int, Int), rowCol2: (Int, Int), elem: Int): Unit = {
    val row1 = rowCol1._1
    val row2 = rowCol2._1
    val col1 = rowCol1._2
    val col2 = rowCol2._2
    for {
      i <- row1 until row1 + 3
      j <- col1 until col1 + 3
    } yield {
      if (i != row1 && i != row2 && j != col1 && j != col2)
        if (matList(i)(j) != null) matList(i)(j) = matList(i)(j).filter(e => e != elem)
    }
  }
}

