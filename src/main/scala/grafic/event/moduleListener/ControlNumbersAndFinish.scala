package grafic.event.moduleListener

protected[event] object ControlNumbersAndFinish {

  import java.awt.Color

  /*made by Zandoli*/

  import grafic.{cp, graficSet, utentSolved}
  import javax.swing.{JOptionPane, JTextArea}

  def seeVision(possibleValues: Set[Int], number: Int, t: JTextArea): Unit = {
    if (possibleValues.contains(number)) {
      t.setForeground(Color.green)
      val messageOk = "The number belongs to list "
      JOptionPane.showMessageDialog(cp, messageOk,
        "Message", JOptionPane.WARNING_MESSAGE)
    } else {
      graficSet[(Int, Int)](-1, -1)

      t.setForeground(Color.red)
      var message = "The number is not correct! Possible values: "
      possibleValues.foreach(v => message = message + v + " ")
      JOptionPane.showMessageDialog(cp, message, "Message", JOptionPane.WARNING_MESSAGE)
    }
  }

  def actionUtent(): Unit = {
    if (utentSolved()) {
      JOptionPane.showMessageDialog(cp, "Game end, Puzzle solved", "Message", JOptionPane.DEFAULT_OPTION)
      val option = JOptionPane.showConfirmDialog(null, "New Game?", "Message", JOptionPane.YES_NO_CANCEL_OPTION)
      option match {
        case 0 =>
        //cp.setVisible(false)

        // reupload of the sudoku
        //the interface of Sudoku remains open, so you don't have to write anything here
        //when you finish the game click the exit button in the matrix and open a new file from the interface

        case 1 => System.exit(0)
        case _ => System.out.println("cancel")
      }
    }
  }

}

