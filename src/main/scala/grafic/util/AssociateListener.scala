package grafic.util

object AssociateListener {
  import grafic.event.{MouseListener, WriteOnCell}
  import grafic.panels.TextOpNumber.TextOpNumber
  import grafic.util._
  import utility.{dimSudoku, puzzle}
  import grafic._

  def associateListener() = {
    for (row <- 0 until dimSudoku; col <- 0 until dimSudoku) {
      puzzle(row)(col) match {
        case 0 =>
          tfCells(row)(col).addKeyListener(WriteOnCell(row, col))
          tfCells(row)(col).addMouseListener(MouseListener(row, col))
      }
    }
  }
}
