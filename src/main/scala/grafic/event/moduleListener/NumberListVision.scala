package grafic.event.moduleListener

import java.awt.Color

import grafic.{cp, setPressed}
import javax.swing.{JOptionPane, JTextField}

object NumberListVision {
  def seeVision(possibleValues: Set[Int], number: Int, t: JTextField) = {
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

    /**
     * TODO: fare modulo che ha una funzione per aiutare
     *  l'utente a scrivere i numeri ==> @Pacini
     */
  }
}
