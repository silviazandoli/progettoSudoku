package grafic.event

import java.awt.event.{ActionEvent, ActionListener}
import java.awt.{Color, Container}

import grafic.MainGraphic.initAndUpload
import grafic.{masks, setPressed, utentSolved}
import javax.swing.{JOptionPane, JTextField}
import utility.{matList, tfCells}

sealed trait WriteOnCell extends ActionListener {
  val row: Int
  val col: Int
  val container: Container
  val puzzleResolt: Array[Array[Int]]
  var n: String

  val CLOSED_CELL_BGCOLOR: Color = Color.GRAY
  val CLOSED_CELL_TEXT: Color = Color.BLACK

  def actionPerformed(e: ActionEvent): Unit = {
    val t: JTextField = new JTextField(n)
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

            /*
            messa a comodo
             */
            setPressed(row, col)

            if (utentSolved()) {
              JOptionPane.showMessageDialog(container, "Game end, Puzzle solved", "Message", JOptionPane.DEFAULT_OPTION)
              val option = JOptionPane.showConfirmDialog(null, "New Game?", "Message", JOptionPane.YES_NO_CANCEL_OPTION)
              option match {
                case 0 =>  initAndUpload()
                case 1 => System.exit(0)
                case _ => System.out.println("cancel")
              }
            }
          case _ =>
            setPressed(-1, -1)
            JOptionPane.showMessageDialog(container, "Good! The number is in MatList", "Message", JOptionPane.DEFAULT_OPTION)
        }
      } else {
        setPressed(-1, -1)

        t.setForeground(Color.red)
        var message = "The number is not correct! Possible values: "
        possibleValues.foreach(v => message = message + v + " ")
        JOptionPane.showMessageDialog(container, message, "Message", JOptionPane.WARNING_MESSAGE)
        /*val option = JOptionPane.showConfirmDialog(null, "New Game?", "Message", JOptionPane.YES_NO_CANCEL_OPTION)
        option match {
          case 0 => initAndUpload()
          case 1 => System.exit(0)
          case _ => System.out.println("cancel")
        }*/
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

  def apply(row: Int, col: Int, cp: Container, puzzleResolt: Array[Array[Int]]/*, n: String*/): WriteOnCell = WriteOnCellImpl(row, col, cp, puzzleResolt/*,n*/)

  private case class WriteOnCellImpl(row: Int, col: Int, cp: Container, puzzleResolt: Array[Array[Int]]/*,n: String*/) extends WriteOnCell {
    val container: Container = cp
    override var n: String = _
  }

}
