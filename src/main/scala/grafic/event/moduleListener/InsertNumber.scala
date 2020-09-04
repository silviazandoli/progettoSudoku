package grafic.event.moduleListener

/**
Made by Pacini, the alert dialogs with control of the numbers are made by Zandoli

 */
protected[event] object InsertNumber {
  import java.awt.Color
  import javax.swing.JOptionPane

  import grafic.event.moduleListener.ControlNumbersAndFinish.actionUtent
  import grafic.event.moduleListener.moduleUpdate.UpdateListUser
  import grafic.util.{AssociateListener, CLOSED_CELL_BGCOLOR, CLOSED_CELL_TEXT, FONT_NUMBERS, score}
  import grafic.panels.TextOpNumber.TextOpNumber
  import grafic._
  import sudoku.MatListOperation

  private def operationOnGUI(row: Int, col: Int, number: Int, t: TextOpNumber): Unit = {
    t.setForeground(Color.green)
    JOptionPane.showMessageDialog(cp, "Good! The number is in Puzzle", "Message", JOptionPane.DEFAULT_OPTION)

    AssociateListener.writeText(tfCells(row)(col), row, col,
      editFlag = false,
      FONT_NUMBERS, CLOSED_CELL_BGCOLOR, CLOSED_CELL_TEXT)("" + number)
  }

  private def operationOnNumber(row: Int, col: Int, number: Int, t: TextOpNumber): Unit = {
    operationOnGUI(row, col, number, t)
    graficSet(row, col)
    //in case of finish
    actionUtent()

    MatListOperation.updateList((row,col),number)
    UpdateListUser.updateListUser((row,col),number)
    score = score + 1
  }

  def writeNumber(row: Int, col: Int, number: Int, t: TextOpNumber): Unit = {
    val array = graficGet[Array[Array[Int]]]
    array(row)(col) match {
      case `number` =>
        operationOnNumber(row, col, number, t)

      case _ =>
        t.setForeground(Color.red)
        t.setEditable(true) // si dò 2° chanche
        graficSet((-1, -1))
        JOptionPane.showMessageDialog(cp, "Bad! The number Not in puzzle!", "Message", JOptionPane.DEFAULT_OPTION)
    }
  }
}
