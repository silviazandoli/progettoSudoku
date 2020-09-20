package grafic.event.moduleListener

import grafic.panels.TextOpNumber.TextOpNumber

/*made by Zandoli*/

protected[event] object ControlAndFinish {

  import java.awt.Color
  import grafic.{cp, graficSet, utentSolved}
  import javax.swing.JOptionPane

  /**
   * Controls if a number is contained in the list of numbers of a cell and shows a messaage dialog
   *
   * @param possibleValues the list of numbers
   * @param number         the number to control
   * @param t              the cell
   */
  def seeVisionErrors(possibleValues: Set[Int], number: Int, t: TextOpNumber): Unit = {
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

  /**
   * action when a sudoku is resolved
   */
  def actionUtent(): Unit = {
    if (utentSolved()) {
      JOptionPane.showMessageDialog(cp, "Game end, Puzzle solved", "Message", JOptionPane.DEFAULT_OPTION)
      val option = JOptionPane.showConfirmDialog(null, "New Game?", "Message", JOptionPane.YES_NO_CANCEL_OPTION)
      option match {
        case 0 =>

        // reupload of a sudoku
        //the interface of Sudoku remains open, so you don't have to write anything here
        //when you finish the game, and want to start another, click the exit button of the sudoku resolved
        // and open a new file from the interface

        case 1 => System.exit(0)
        case _ => System.out.println("cancel")
      }
    }
  }
}

