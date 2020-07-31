package grafic.event.moduleListener

protected[event] object InsertNumber {
  import java.awt.Color
  import javax.swing.{JOptionPane, JTextField}
  import grafic.MainGraphic.initAndUpload
  import grafic.{tfCells, masks, cp, setPressed, getPuzzleResolt, utentSolved}
  import grafic.util.{CLOSED_CELL_BGCOLOR, CLOSED_CELL_TEXT}

  def writeNumber(row: Int, col: Int, number: Int, t: JTextField): Unit = {
    getPuzzleResolt(row)(col) match {
      case `number` =>
        t.setForeground(Color.green)
        JOptionPane.showMessageDialog(cp, "Good! The number is in Puzzle", "Message", JOptionPane.DEFAULT_OPTION)

        tfCells(row)(col).setEditable(false)
        tfCells(row)(col).setBackground(CLOSED_CELL_BGCOLOR)
        tfCells(row)(col).setForeground(CLOSED_CELL_TEXT)

        masks(row)(col) = true

        //messa a comodo
        setPressed(row, col)

        if (utentSolved()) {
          JOptionPane.showMessageDialog(cp, "Game end, Puzzle solved", "Message", JOptionPane.DEFAULT_OPTION)
          val option = JOptionPane.showConfirmDialog(null, "New Game?", "Message", JOptionPane.YES_NO_CANCEL_OPTION)
          option match {
            case 0 =>
              cp.setVisible(false)
              initAndUpload()
            case 1 => System.exit(0)
            case _ => System.out.println("cancel")
          }
        }
      case _ =>
        t.setForeground(Color.red)
        setPressed(-1, -1)
        tfCells(row)(col).setEditable(true) // si dò 2° chanche
        JOptionPane.showMessageDialog(cp, "Bad! The number Not in puzzle!", "Message", JOptionPane.DEFAULT_OPTION)
    }
  }
}
