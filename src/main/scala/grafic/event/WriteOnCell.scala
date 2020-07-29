package grafic.event

import java.awt.{Color, Container}
import java.awt.event.{ActionEvent, ActionListener}

import grafic.{masks, utentSolved}
import javax.swing.{JOptionPane, JTextField}
import utility.{matList, tfCells}

sealed trait WriteOnCell extends ActionListener {
  val row: Int
  val col: Int
  val container: Container
  val puzzleResolt: Array[Array[Int]]

  val CLOSED_CELL_BGCOLOR: Color = Color.GRAY
  val CLOSED_CELL_TEXT: Color = Color.BLACK

  def actionPerformed(e: ActionEvent): Unit = {
    val t: JTextField = e.getSource.asInstanceOf[JTextField]
    try {
      println(t.getText.toInt)
      val number = t.getText.toInt
      t.setBackground(Color.yellow)
      val possibleValues = matList(row)(col).toSet

      if (possibleValues.contains(number)) {
        t.setForeground(Color.green)

        puzzleResolt(row)(col) match {
          case `number` =>
            JOptionPane.showMessageDialog(container, "Good! The number is in Puzzle", "Message", JOptionPane.DEFAULT_OPTION)
            tfCells(row)(col).setEditable(false)
            tfCells(row)(col).setBackground(CLOSED_CELL_BGCOLOR)
            tfCells(row)(col).setForeground(CLOSED_CELL_TEXT)

            masks(row)(col) = true

            if (utentSolved()) {
              JOptionPane.showMessageDialog(container, "Game end puzzle solved", "Message", JOptionPane.DEFAULT_OPTION)
            }
          case _ => JOptionPane.showMessageDialog(container, "Good! The number is in MatList", "Message", JOptionPane.DEFAULT_OPTION)
        }
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

object WriteOnCell {
  import java.awt.Container

  def apply(row: Int, col: Int, cp: Container, puzzleResolt: Array[Array[Int]]): WriteOnCell = WriteOnCellImpl(row, col, cp, puzzleResolt)

  private case class WriteOnCellImpl(row: Int, col: Int, cp: Container, puzzleResolt: Array[Array[Int]]) extends WriteOnCell {
    val container: Container = cp
  }
}
