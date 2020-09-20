package grafic.event.moduleListener.moduleUpdate

/**
 * Made by Pacini
 */
protected[event] object UpdateListUser {
  import grafic.panels.TextOpNumber.TextOpNumber
  import grafic.tfCells
  import utility.dimSudoku

  /**
   * Remove a number in the game cell
   * @param cell of the game
   * @param number to be removed
   */
  private def remove(cell: TextOpNumber, number: Int): Unit = {
    val set = cell.getList
    if (set.nonEmpty && set.contains(number)) {
      cell.removeNumber(number)
    }
  }

  /**
   * Update the list of numbers in all the involved cells
   * @param coord of the cell that has just been filled
   * @param number to cancel in the other near cell, (all the row, all the column and all square of 3x3)
   */
  def updateListUser(coord: (Int, Int), number: Int): Unit = {
    val row = coord._1
    val col = coord._2

    for (k <- 0 until dimSudoku) {
      remove(tfCells(row)(k), number)
      remove(tfCells(k)(col), number)
      remove(tfCells(row)(col), k+1)
      /*
      tfCells(row)(k).removeFromList(number)
      tfCells(k)(col).removeFromList(number)
       */
    }

    val ci = row / 3
    val cj = col / 3
    val squareCells = tfCells.grouped(3).toList(ci).flatMap { x => x.grouped(3).toList(cj) }

    squareCells.foreach(jTarea => remove(jTarea, number))
    //squareCells.foreach(jTarea => jTarea.removeFromList(number))
  }
}
