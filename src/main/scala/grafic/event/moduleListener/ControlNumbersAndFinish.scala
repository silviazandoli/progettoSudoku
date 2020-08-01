package grafic.event.moduleListener

import java.awt.Color
import grafic.{cp, setPressed}
import javax.swing.{JOptionPane, JTextField}

object ControlNumbers {


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

}
