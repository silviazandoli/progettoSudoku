package grafic.util

object AssociateListener {
  import grafic.event.{MouseListener, WriteOnCell}
  import utility.{dimSudoku, puzzle}
  import grafic._

  def associateListener(): Unit = {
    for (row <- 0 until dimSudoku; col <- 0 until dimSudoku) {
      puzzle(row)(col) match {
        case 0 =>
          tfCells(row)(col).addMouseListener(MouseListener(row, col))
          tfCells(row)(col).addKeyListener(WriteOnCell(row, col))
        case _ =>
      }
    }
  }
}
