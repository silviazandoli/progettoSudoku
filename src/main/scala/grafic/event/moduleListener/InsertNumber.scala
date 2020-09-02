package grafic.event.moduleListener

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

  def writeNumber(row: Int, col: Int, number: Int, t: TextOpNumber): Unit = {
    getPuzzleResolt(row)(col) match {
      case `number` =>
        operationOnGUI(row, col, number, t)
        //messa a comodo
        setPressed(row, col)
        //in case of finish
        actionUtent()
        /* TODO: Check */
        MatListOperation.updateList((row,col),number)
        UpdateListUser.updateListUser((row,col),number)
        t.setEditable(false)

        score = score + 1

      case _ =>
        t.setForeground(Color.red)
        setPressed(-1, -1)

        t.setEditable(true) // si dò 2° chanche

        JOptionPane.showMessageDialog(cp, "Bad! The number Not in puzzle!", "Message", JOptionPane.DEFAULT_OPTION)
    }
  }
}
