package resolutionAlgorithm

import sudoku.SudokuLoad.{puzzle, dimSudoku, display}
import sudoku.MatListOperation.{matList, updateList}

object HiddenSingles {

  def hiddenSingles(row: Int, col: Int): Unit = {
    for {
      elem <- matList(row)(col)
    } yield {
      if (searchInRow(row, elem) || searchInColumn(col, elem) || searchInSquare(row, col, elem)) {
        updateList((row, col), elem)

        puzzle(row)(col) = elem
      }
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

    def closureFound(index: Int): Unit = flag match {
      case true =>
        if (matList(rowCol)(index) != null && matList(rowCol)(rowCol).contains(num)) {
          valFound = valFound + 1
        }
      case false =>
        if (matList(index)(rowCol) != null && matList(index)(rowCol).contains(num)) {
          valFound = valFound + 1
        }
    }

    for {
      j <-0 until dimSudoku
    } yield {
      closureFound(j)
    }

    valFound
  }

  /*
  a sinistra il numero di volte che compare,
  a destra la colonna in cui è stato trovato
   */
  def searchInRow(num: Int, row: Int): Boolean = {
    caseFound(numFound(row, num, flag = true))
  }

  def searchInColumn(num: Int, col: Int): Boolean = {
    caseFound(numFound(col, num, flag = false))
  }

  def searchInSquare(row: Int, col: Int, num: Int): Boolean = {
      val r = (row / 3) * 3
      val c = (col / 3) * 3

      var numFound = 0

      /*
      aggiornamento sotto - quadrato
       */
      for {
        i <- r until r + 3
        j <- c until c + 3
      } yield {
        if (matList(i)(j) != null && matList(i)(j).contains(num)) {
          numFound = numFound + 1
        }
      }

    caseFound(numFound)
  }
}
