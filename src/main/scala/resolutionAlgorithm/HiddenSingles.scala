package resolutionAlgorithm

import resolutionAlgorithm.SudokuLoad.{puzzle, dimSudoku}
import resolutionAlgorithm.SudokuMatrix.{matList, updateList}

object HiddenSingles {

  def method(row: Int, col: Int) = {
    for (i <- 1 to dimSudoku) {
      val colFound = searchInRow(i, row)
      if (colFound != -1) {
        updateList((row, colFound), i)
      } else {
        val rowFound = searchInColumn(i, col)
        if (rowFound != -1) {
          updateList((rowFound, col), i)
        } else {
          val coupleRowCol = searchInSubSquare(row, col, i)
          if (coupleRowCol._1 > 0) updateList((rowFound, col), i)
        }
      }
    }
  }

  /*
  a sinistra il numero di volte che compare,
  a destra la colonna in cui è stato trovato
   */
  def searchInRow(num: Int, row: Int): Int = {
    var col = -1
    var numFound = 0

    for {
      j <-0 until dimSudoku
    } yield {
      if (puzzle(row)(j) == num) return row
      if (matList(row)(j).contains(num)) {
        numFound = numFound + 1
        col = j
      }
    }

    if (numFound >= 2) col = -1

    col
  }

  def searchInColumn(num: Int, col: Int): Int = {
    var row = -1
    var numFound = 0

    for {
      j <-0 until dimSudoku
    } yield {
      if (puzzle(j)(col) == num) return row
      if (matList(j)(col).contains(num)) {
        numFound = numFound + 1
        row = j
      }
    }

    if (numFound >= 2) row = -1

    row
  }

  def searchInSubSquare(row: Int, col: Int, num: Int): (Int, Int) = {
      val r = (row / 3) * 3
      val c = (col / 3) * 3

      var numFound = 0

      var riga = -1
      var colonna = -1

      /*
      aggiornamento sotto - quadrato
       */
      for {
        i <- r until r + 3
        j <- c until c + 3
      } yield {
        if (puzzle(i)(j) == num) return (-1, -1)
        if (matList(i)(j).contains(num)) {
          numFound = numFound + 1

          riga = i
          colonna = j
        }

        if (numFound > 1) return (-1, -1)
      }
    (riga, colonna)
  }
}
