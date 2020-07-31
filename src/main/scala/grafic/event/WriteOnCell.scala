package grafic.event

import java.awt.Color
import java.awt.event.{ActionEvent, ActionListener}

import grafic.util._
import grafic._
import grafic.event.moduleListener.{InsertNumber, MatListVision, NumberListVision}
import javax.swing.{JOptionPane, JTextField}
import utility.matList

sealed trait WriteOnCell extends ActionListener {
  val row: Int
  val col: Int

  def actionPerformed(e: ActionEvent): Unit = {
    val t: JTextField = e.getSource.asInstanceOf[JTextField]
    try {
      val number = t.getText.toInt
      tfCells(row)(col).setEditable(true)
      val possibleValues = matList(row)(col).toSet

      getWrite match {
        case NUMBER_LIST =>
          NumberListVision.seeVision(possibleValues, number, t)

        case SEE_MATLIST =>
          MatListVision.seeVision(possibleValues)

        case NUMBER =>
          InsertNumber.writeNumber(row, col, number, t)
      }
      //it shows the list of possible values
      //(ps: ho fatto che l'utente può vedere i numeri candidati per quella cella quando l'utente inserisce un numero errato in una
      //determinata casella
    } catch {
      case _: Throwable => t.setForeground(Color.red)
        JOptionPane.showMessageDialog(cp, "It wasn't inserted a number!", "Messaggio", JOptionPane.WARNING_MESSAGE)
    }
  }
}

object WriteOnCell {
  import java.awt.Container

  def apply(row: Int, col: Int): WriteOnCell = WriteOnCellImpl(row, col)

  private case class WriteOnCellImpl(row: Int, col: Int) extends WriteOnCell {
    val container: Container = cp
  }
}
