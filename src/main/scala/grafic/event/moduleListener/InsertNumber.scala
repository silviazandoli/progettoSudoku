package grafic.event.moduleListener

protected[event] object InsertNumber {
  import java.awt.Color
  import javax.swing.JOptionPane
  import grafic.event.moduleListener.ControlNumbersAndFinish.actionUtent
  import grafic.util.{CLOSED_CELL_BGCOLOR, CLOSED_CELL_TEXT, FONT_NUMBERS}
  import grafic._
  import grafic.panels.TextOpNumber.TextOpNumber

  private def operationOnGUI(row: Int, col: Int, number: Int, t: TextOpNumber): Unit = {
    t.setForeground(Color.green)
    JOptionPane.showMessageDialog(cp, "Good! The number is in Puzzle", "Message", JOptionPane.DEFAULT_OPTION)

    t.setEditable(false)
    t.setText(""+number)
    t.setFont(FONT_NUMBERS)
    t.setBackground(CLOSED_CELL_BGCOLOR)
    t.setForeground(CLOSED_CELL_TEXT)

    masks(row)(col) = true
  }

  def writeNumber(row: Int, col: Int, number: Int, t: TextOpNumber): Unit = {
    getPuzzleResolt(row)(col) match {
      case `number` =>
        operationOnGUI(row, col, number, t)
        //messa a comodo
        setPressed(row, col)
        //in case of finish
        actionUtent()
        /* TODO BISOGNA FARE UPDATElIST PER AGGIORNARE LA LISTA degli elementi?? */
        //MatListOperation.updateList((row,col),number)
      case _ =>
        t.setForeground(Color.red)
        setPressed(-1, -1)
        t.setEditable(true) // si dò 2° chanche
        JOptionPane.showMessageDialog(cp, "Bad! The number Not in puzzle!", "Message", JOptionPane.DEFAULT_OPTION)
    }
  }
}
