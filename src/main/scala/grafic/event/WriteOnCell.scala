package grafic.event

import java.awt.Color
import java.awt.event.{ActionEvent, ActionListener}

import grafic.MainGraphic.initAndUpload
import grafic.util._
import grafic._
import javax.swing.{JOptionPane, JTextField}
import utility.matList

sealed trait WriteOnCell extends ActionListener {
  val row: Int
  val col: Int

  def actionPerformed(e: ActionEvent): Unit = {
    val t: JTextField = e.getSource.asInstanceOf[JTextField]
    try {
      val number = t.getText.toInt
      t.setBackground(Color.yellow)

      tfCells(row)(col).setEditable(true)
      val possibleValues = matList(row)(col).toSet

      getWrite match {
        case NUMBER_LIST =>
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
        case SEE_MATLIST =>
          println(SEE_MATLIST)
          showNumberList.setEditable(true)
          showNumberList.setEnabled(true)

          possibleValues.foreach(el => {
            val textIns = el + ","
            showNumberList.append(textIns)
          })

          showNumberList.setEditable(false)
          showNumberList.setEnabled(false)
        case NUMBER =>
          getPuzzleResolt(row)(col) match {
            case `number` =>
              t.setForeground(Color.green)
              JOptionPane.showMessageDialog(cp, "Good! The number is in Puzzle", "Message", JOptionPane.DEFAULT_OPTION)

              tfCells(row)(col).setEditable(false)
              tfCells(row)(col).setBackground(CLOSED_CELL_BGCOLOR)
              tfCells(row)(col).setForeground(CLOSED_CELL_TEXT)

              masks(row)(col) = true

              //messa a comodo
              setPressed(row, col)

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
            case _ =>
              t.setForeground(Color.red)
              setPressed(-1, -1)
              tfCells(row)(col).setEditable(true)
              JOptionPane.showMessageDialog(cp, "Bad! The number Not in puzzle!", "Message", JOptionPane.DEFAULT_OPTION)
          }
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

  def apply(row: Int, col: Int, cp: Container): WriteOnCell = WriteOnCellImpl(row, col, cp)

  private case class WriteOnCellImpl(row: Int, col: Int, cp: Container) extends WriteOnCell {
    val container: Container = cp
  }
}
