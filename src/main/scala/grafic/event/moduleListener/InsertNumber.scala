package grafic.event.moduleListener

<<<<<<< HEAD
import grafic.panels.TextOpNumber.TextOpNumber
=======
import sudoku.MatListOperation
>>>>>>> 4f2a35d9e1c728b8e295e4c5be069e6ac2cc7c1e

protected[event] object InsertNumber {
  import java.awt.Color
  import javax.swing.JOptionPane
  import grafic.event.moduleListener.ControlNumbersAndFinish.actionUtent
  import grafic.util.{CLOSED_CELL_BGCOLOR, CLOSED_CELL_TEXT}
  import grafic._

  //private def operationOnGUI(row: Int, col: Int, t: JTextField): Unit = {
  private def operationOnGUI(row: Int, col: Int, t: TextOpNumber): Unit = {
    t.setForeground(Color.green)
    JOptionPane.showMessageDialog(cp, "Good! The number is in Puzzle", "Message", JOptionPane.DEFAULT_OPTION)

    /*
    tfCells(row)(col).setEditable(false)
    tfCells(row)(col).setBackground(CLOSED_CELL_BGCOLOR)
    tfCells(row)(col).setForeground(CLOSED_CELL_TEXT)
     */
    t.setEditable(false)
    t.setBackground(CLOSED_CELL_BGCOLOR)
    t.setForeground(CLOSED_CELL_TEXT)

    masks(row)(col) = true
  }

  //def writeNumber(row: Int, col: Int, number: Int, t: JTextField): Unit = {
  def writeNumber(row: Int, col: Int, number: Int, t: TextOpNumber): Unit = {
    getPuzzleResolt(row)(col) match {
      case `number` =>
        operationOnGUI(row, col, t)
        //messa a comodo
        setPressed(row, col)
        //in case of finish
        actionUtent()
        /* TODO BISOGNA FARE UPDATElIST PER AGGIORNARE LA LISTA degli elementi?? @Antonelli*/
        //MatListOperation.updateList((row,col),number)
      case _ =>
        t.setForeground(Color.red)
        setPressed(-1, -1)
        //tfCells(row)(col).setEditable(true) // si dò 2° chanche
        t.setEditable(true)
        JOptionPane.showMessageDialog(cp, "Bad! The number Not in puzzle!", "Message", JOptionPane.DEFAULT_OPTION)
    }
  }
}
