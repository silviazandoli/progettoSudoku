package grafic.event.moduleListener

protected[event] object InsertNumber {
  import java.awt.Color
  import javax.swing.{JOptionPane, JTextField}
  import grafic.event.moduleListener.ControlNumbersAndFinish.actionUtent
  import grafic.util.{CLOSED_CELL_BGCOLOR, CLOSED_CELL_TEXT}
  import grafic._

  private def operationOnGUI(row: Int, col: Int, t: JTextField): Unit = {
    t.setForeground(Color.green)
    JOptionPane.showMessageDialog(cp, "Good! The number is in Puzzle", "Message", JOptionPane.DEFAULT_OPTION)

    tfCells(row)(col).setEditable(false)
    tfCells(row)(col).setBackground(CLOSED_CELL_BGCOLOR)
    tfCells(row)(col).setForeground(CLOSED_CELL_TEXT)

    masks(row)(col) = true
  }

  def writeNumber(row: Int, col: Int, number: Int, t: JTextField): Unit = {
    getPuzzleResolt(row)(col) match {
      case `number` =>
        operationOnGUI(row, col, t)
        //messa a comodo
        setPressed(row, col)
        //in case of finish
        actionUtent()
      case _ =>
        t.setForeground(Color.red)
        setPressed(-1, -1)
        tfCells(row)(col).setEditable(true) // si dò 2° chanche
        JOptionPane.showMessageDialog(cp, "Bad! The number Not in puzzle!", "Message", JOptionPane.DEFAULT_OPTION)
    }
  }
}
