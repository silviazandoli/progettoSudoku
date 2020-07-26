package resolutionAlgorithm

import utility.{puzzle, dimSudoku, matList}
import sudoku.MatListOperation.updateList

object HiddenSingles {

  def totalHiddenSingles(): Unit = {
    (0 until dimSudoku).foreach(i => (0 until dimSudoku).foreach(j => {matList(i)(j) != Nil
      hiddenSingles(i, j)}))
  }

  def hiddenSingles(row: Int, col: Int): Unit = {
    matList(row)(col).filter(elem => searchInRow(row, elem) ||
      searchInColumn(col, elem) || searchInSquare(row, col, elem))
      .foreach(elem => {updateList((row, col), elem)
        puzzle(row)(col) = elem})
  }

  def caseFound(numFound : Int): Boolean = {
    numFound match {
      case 1 => true
      case _ => false
    }
  }

  def numFound(rowCol: Int, num: Int, flag: Boolean): Int = {
    var valFound = 0

    val closure: Int => Unit = (index: Int) => if (flag) {
      matList(rowCol)(index) != Nil && matList(rowCol)(index).contains(num)
        valFound = valFound + 1
    } else {
      matList(index)(rowCol) != Nil && matList(index)(rowCol).contains(num)
      valFound = valFound + 1
    }

    (0 until dimSudoku).foreach(j => closure(j))

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
    val ci = row / 3
    val cj = col / 3
    val squareCells = matList.grouped(3).toList(ci).flatMap { x => x.grouped(3).toList(cj) }

    caseFound(squareCells.filterNot(list => list == Nil).count(list => list.contains(num)))
  }
}
