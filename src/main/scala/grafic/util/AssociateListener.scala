package grafic.util

object AssociateListener {
  import grafic.event.{MouseListener, WriteOnCell}
  import grafic.panels.TextOpNumber.TextOpNumber
  import utility.{dimSudoku, puzzle}
  import grafic._

  import scala.swing.{Color, Font}

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

  def writeText(textOpNumber: TextOpNumber, row: Int, col: Int,
                editFlag: Boolean,
                font: Font, color1: Color, color2: Color) (strText: String): Unit = {
    textOpNumber.setEditable(editFlag)
    textOpNumber.setText(strText)
    textOpNumber.setFont(font)
    textOpNumber.setBackground(color1)
    textOpNumber.setForeground(color2)

    masks(row)(col) = !editFlag
  }

  def writeTextEmpty(textOpNumber: TextOpNumber, row: Int, col: Int,
                     editFlag: Boolean,
                     font: Font, color1: Color, color2: Color): Unit = {
    writeText(textOpNumber, row, col,
      editFlag,
      font, color1, color2) ("")
  }
}
