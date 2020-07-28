package grafic

import java.awt.{Color, Container}
import java.awt.event.{ActionEvent, ActionListener}

import javax.swing.{JOptionPane, JTextField}
import utility.matList

object EventMouse {
  def apply(row: Int, col: Int, cp: Container) = EventMouseImplement(row, col, cp)

  trait EventMouseTrait extends ActionListener {
    val row: Int
    val col: Int
    val container: Container

    def actionPerformed(e: ActionEvent): Unit = {
      val t: JTextField = e.getSource.asInstanceOf[JTextField]
      try {
        println(t.getText.toInt)
        val number = t.getText.toInt
        t.setBackground(Color.yellow)
        val possibleValues = matList(row)(col).toSet

        if (possibleValues.contains(number)) {
          t.setForeground(Color.green)
          JOptionPane.showMessageDialog(container, "Good! The number is in MatList", "Message", JOptionPane.DEFAULT_OPTION)
        } else {
          t.setForeground(Color.red)
          var message = "The number is not correct! Possible values: "
          possibleValues.foreach(v => message = message + v + " ")
          JOptionPane.showMessageDialog(container, message, "Message", JOptionPane.WARNING_MESSAGE)
        }

        //it shows the list of possible values
        //(ps: ho fatto che l'utente può vedere i numeri candidati per quella cella quando l'utente inserisce un numero errato in una
        //determinata casella
      } catch {
        case _: Throwable => t.setForeground(Color.red)
          JOptionPane.showMessageDialog(container, "It wasn't inserted a number!", "Messaggio", JOptionPane.WARNING_MESSAGE)
      }
    }
  }

  case class EventMouseImplement(row: Int, col: Int, container: Container) extends EventMouseTrait
}
