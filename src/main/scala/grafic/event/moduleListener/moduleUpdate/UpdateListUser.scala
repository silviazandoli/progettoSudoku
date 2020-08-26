package grafic.event.moduleListener.moduleUpdate

protected[event] object UpdateListUser {
  import javax.swing.SwingUtilities

  import grafic.panels.TextOpNumber.TextOpNumber
  import grafic.tfCells
  import utility.dimSudoku

  private def remove(cell: TextOpNumber, number: Int): Unit = {
    val set = cell.getList
    if (set.nonEmpty && set.contains(number)) {
      cell.removeNumber(number)
    }
  }

  def updateListUser(coord: (Int, Int), number: Int): Unit = {
    val row = coord._1
    val col = coord._2

    for (k <- 0 until dimSudoku) {
      remove(tfCells(row)(k), number)
      remove(tfCells(k)(col), number)
    }

    val ci = row / 3
    val cj = col / 3
    val squareCells = tfCells.grouped(3).toList(ci).flatMap { x => x.grouped(3).toList(cj) }

    squareCells.foreach(jTarea => remove(jTarea, number))
    //squareCells.foreach(jTarea=>jTarea.removeFromList(number))

    try {
      SwingUtilities.invokeLater(() => {
        displayList(row, col)
      })
    } catch {
      case iE: InterruptedException => println(iE.getMessage)
    }
  }

  def displayList(row: Int, col: Int): Unit = {
    for (k <- 0 until dimSudoku; if k != col) tfCells(row)(k).displayList()
    for (k <- 0 until dimSudoku; if k != row) tfCells(k)(col).displayList()

    val ci: Int = row / 3
    val cj: Int = col / 3
    val squareCells: Array[TextOpNumber] = tfCells.grouped(3).toList(ci).flatMap { x => x.grouped(3).toList(cj) }

    squareCells.foreach(jTarea => {
      if (jTarea.getList.nonEmpty) {
        jTarea.displayList()
      }
    })
  }
}
