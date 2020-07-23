package resolutionAlgorithm

import utility.{puzzle, dimSudoku, matList}
import sudoku.MatListOperation.updateList

object HiddenSingles {

  def totalHiddenSingles(): Unit =
    for (i <- 0 until dimSudoku; j <- 0 until dimSudoku; if matList(i)(j) != Nil) hiddenSingles(i, j)

  def hiddenSingles(row: Int, col: Int): Unit = {
    for (elem <- matList(row)(col)
         if searchInRow(row, elem) || searchInColumn(col, elem) || searchInSquare(row, col, elem)) {
      updateList((row, col), elem)
      puzzle(row)(col) = elem
    }
  }

  def caseFound(numFound : Int): Boolean = {
    numFound match {
      case 1 => true
      case _ => false
    }
  }

  def numFound(rowCol: Int, num: Int, flag: Boolean): Int = {
    var valFound = 0

    def closureFound(index: Int): Unit = if (flag) {
      if (matList(rowCol)(index) != Nil && matList(rowCol)(rowCol).contains(num)) {
        valFound = valFound + 1
      }
    } else {
      if (matList(index)(rowCol) != Nil && matList(index)(rowCol).contains(num)) {
        valFound = valFound + 1
      }
    }

    (0 until dimSudoku).foreach(j => closureFound(j))

    valFound
  }

  /*
  a sinistra il numero di volte che compare,
  a destra la colonna in cui è stato trovato
   */
  def searchInRow(row: Int, num: Int): Boolean = {
    caseFound(numFound(row, num, flag = true))
  }

  def searchInColumn(col: Int, num: Int): Boolean = {
    caseFound(numFound(col, num, flag = false))
  }

  def searchInSquare(row: Int, col: Int, num: Int): Boolean = {
      val r = (row / 3) * 3
      val c = (col / 3) * 3

      var numFound = 0

      /*
      aggiornamento sotto - quadrato
       */
    for (i <- r until r + 3; j <- c until c + 3; if matList(i)(j) != Nil && matList(i)(j).contains(num)) numFound = numFound + 1

    caseFound(numFound)
  }
}
