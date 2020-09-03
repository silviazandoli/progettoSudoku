package grafic.event

import java.awt.Color
import java.awt.event.{KeyEvent, KeyListener}
import javax.swing.JOptionPane

import grafic._
import grafic.event.moduleListener.{InsertNumber, WriteListUser}
import grafic.panels.TextOpNumber.TextOpNumber
import grafic.util._
import utility.matList

/**
Made by Pacini (Alert dialog with control of numbers made by Zandoli)
 */
sealed trait WriteOnCell extends KeyListener {
  val row: Int
  val col: Int

  def keyReleased(e: KeyEvent): Unit = {
    val t: TextOpNumber = e.getSource.asInstanceOf[TextOpNumber]
    try {
      var retText = t.getText

      if (retText.length > 1) {
        val posInit = retText.length - 1
        val posLast = retText.length

        retText = retText.substring(posInit, posLast)
      }

      val number = retText.toInt
      t.setEditable(true)

      get[String] match {
        case NUMBER_LIST =>
          val possibleValues = matList(row)(col).toSet
          WriteListUser.writePossibileElements(possibleValues, number, t)
        case NUMBER =>
          InsertNumber.writeNumber(row, col, number, t)
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
    override def keyTyped(e: KeyEvent): Unit = {}
    override def keyPressed(e: KeyEvent): Unit = {}
  }
}
