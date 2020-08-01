package grafic.event.moduleListener



import java.awt.Color

import grafic.MainGraphic.initAndUpload
import grafic.{cp, setPressed, utentSolved}
import javax.swing.{JOptionPane, JTextField}

protected[event] object ControlNumbersAndFinish {


  def seeVision(possibleValues: Set[Int], number: Int, t: JTextField): Unit = {
    if (possibleValues.contains(number)) {
      t.setForeground(Color.green)
      val messageOk = "The number belongs to list "
      JOptionPane.showMessageDialog(cp, messageOk,
        "Message", JOptionPane.WARNING_MESSAGE)
    } else {
      setPressed(-1, -1)

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
          cp.setVisible(false)
          initAndUpload()
        case 1 => System.exit(0)
        case _ => System.out.println("cancel")
      }
    }
  }

}

