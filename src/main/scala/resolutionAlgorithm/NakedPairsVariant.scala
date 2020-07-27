package resolutionAlgorithm

import utility.{dimSudoku, matList}

object NakedPairsVariant {

  var coupleFound: (Int, Int) = (-1, -1)

  def findCouple(rowCol: Int, flag: Boolean): Unit = if (flag) {
    val posRows = findCoupleInRow(rowCol)
    val first = posRows._1
    val second = posRows._2

    if (first != -1) {updateRowList(first, second, coupleFound)}

  } else {
    val posCol = findCoupleInColum(rowCol)
    val first = posCol._1
    val second = posCol._2

    if (first != -1) {updateColList(first, second, coupleFound)}
  }

  def findCoupleSubSquare(row1: Int, row2: Int): Unit = {

  }

  def findCoupleInRow(row: Int): (Int, Int) = {
    var found = 0
    var fist = -1
    var second = -1

    (1 to 8).foreach(i => {
      (2 to 9).foreach(j => {
        for {
          k <- 0 until dimSudoku
          if matList(row)(k) != Nil && matList(row)(k).contains(i) && matList(row)(k).contains(j)
        } {
          found = found + 1

          if (found == 1) {fist = k
            coupleFound = (i, j)}
          if (found == 2) second = k
        }
      })
    })
    found match {
      case 2 => (fist, second)
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

          if (found == 1) {fist = k
            coupleFound = (i, j)}
          if (found == 2) second = k
        }
      })
    })
    found match {
      case 2 => (fist, second)
      case _ => (-1, -1)
    }
  }

  def updateRowList(first: Int, second: Int, coupleFound: (Int, Int)): Unit = {

  }

  def updateColList(first: Int, second: Int, coupleFound: (Int, Int)): Unit = {

  }

}
