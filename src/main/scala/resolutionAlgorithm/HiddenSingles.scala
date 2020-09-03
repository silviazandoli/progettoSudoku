package resolutionAlgorithm

/**
 * Made by Pacini
 */
object HiddenSingles {
  import utility.{puzzle, dimSudoku, matList, contains}
  import sudoku.MatListOperation.updateList

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

  def numFound(rowCol: Int, num: Int, flag: Boolean): Int = {
    var valFound = 0

    if (flag) {
      (0 until dimSudoku).foreach(j => if (contains(matList(rowCol)(j), num)) valFound=valFound+1)
    } else {
      (0 until dimSudoku).foreach(j => if (contains(matList(j)(rowCol), num)) valFound=valFound+1)
    }

    valFound
  }

  /*
  a sinistra il numero di volte che compare,
  a destra la colonna in cui è stato trovato
   */
  def searchInRow(row: Int, num: Int): Boolean = {
    numFound(row, num, flag = true) == 1
  }

  def searchInColumn(col: Int, num: Int): Boolean = {
    numFound(col, num, flag = false) == 1
  }

  def searchInSquare(row: Int, col: Int, num: Int): Boolean = {
    val ci = row / 3
    val cj = col / 3
    val squareCells = matList.grouped(3).toList(ci).flatMap { x => x.grouped(3).toList(cj) }

    squareCells.filterNot(list => list == Nil).count(list => list.contains(num)) == 1
  }
}
