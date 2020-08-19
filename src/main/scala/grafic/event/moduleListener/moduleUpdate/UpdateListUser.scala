package grafic.event.moduleListener.moduleUpdate

object UpdateListUser {
  import grafic.panels.TextOpNumber.TextOpNumber
  import grafic.tfCells
  import utility.dimSudoku

  private def removeDisplay(cell: TextOpNumber, number: Int): Unit = {
    if (cell.getList.contains(number)) {
      cell.removeNumber(number)
      cell.displayList()
    }
  }

  def updateListUser(coord: (Int, Int), number: Int): Unit = {
    val row = coord._1
    val col = coord._2

    for {
      k <- 0 until dimSudoku
      if k != col
    } {
      removeDisplay(tfCells(row)(k).asInstanceOf[TextOpNumber], number)
    }

    for {
      k <- 0 until dimSudoku
      if k != row
    } {
      removeDisplay(tfCells(k)(col).asInstanceOf[TextOpNumber], number)
    }

    /*
    val ci = row / 3
    val cj = col / 3
    val squareCells = tfCells.grouped(3).toList(ci).flatMap { x => x.grouped(3).toList(cj) }

    squareCells.foreach(jTarea => {
      val jArea = jTarea.asInstanceOf[TextOpNumber]
      removeDisplay(jArea, number)
    })
     */

  }
}
