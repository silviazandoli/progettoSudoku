package grafic.event

import java.awt.Color
import java.awt.event.{ActionEvent, ActionListener}

import grafic._
import grafic.event.moduleListener.{InsertNumber, WriteListUser}
<<<<<<< HEAD
import grafic.panels.TextOpNumber.TextOpNumber
=======
>>>>>>> 4f2a35d9e1c728b8e295e4c5be069e6ac2cc7c1e
import grafic.util._
import javax.swing.JOptionPane
import utility.matList

sealed trait WriteOnCell extends ActionListener {
  val row: Int
  val col: Int

  def actionPerformed(e: ActionEvent): Unit = {
    //val t: JTextField = e.getSource.asInstanceOf[JTextField]
    val t: TextOpNumber = e.getSource.asInstanceOf[TextOpNumber]
    try {
      val number = t.getText.toInt
      //tfCells(row)(col).setEditable(true)
      t.setEditable(true)
      val possibleValues = matList(row)(col).toSet

      getWrite match {
        case NUMBER_LIST => WriteListUser.writePossibileElements(possibleValues, number, t)
        case NUMBER => InsertNumber.writeNumber(row, col, number, t)
      }

    } catch {
          //it controls it was inserted a input which is not a number
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
