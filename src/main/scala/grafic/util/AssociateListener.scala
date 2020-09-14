package grafic.util

/**
 * Made by Pacini
 */
object AssociateListener {
  import grafic.event.{MyMouseListener, WriteOnCell}
  import grafic.panels.TextOpNumber.TextOpNumber
  import utility.{dimSudoku, puzzle}
  import grafic._

  import scala.swing.{Color, Font}

  /**
   * associa i listener per capire l'operazione da fare
   * e per capire cosa ha premuto l'utente
   */
  def associateListener(): Unit = {
    for (row <- 0 until dimSudoku; col <- 0 until dimSudoku) {
      puzzle(row)(col) match {
        case 0 =>
          tfCells(row)(col).addMouseListener(MyMouseListener(row, col))
          tfCells(row)(col).addKeyListener(WriteOnCell(row, col))
        case _ =>
      }
    }
  }

  /**
   *  scrive il numero su una cella della matrice di gioco,
   *  impostandone colore di foreground e background
   */
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
