package grafic.event

import java.awt.event.{MouseAdapter, MouseEvent}

import javax.swing.JOptionPane
import utility.{matList, puzzle}

sealed trait MouseListener extends MouseAdapter {
  val row: Int
  val col: Int

  //aggiunto evento per cliccare su ogni casella
  override def mousePressed(e: MouseEvent): Unit = {
    selectNumber() //the called method on mouse click
  }

  def selectNumber(): Unit = {
    println("MatList riga " + row + " colonna " + col + " è " + matList(row)(col))
    println("Puzzle riga " + row + " colonna " + col + " è " + puzzle(row)(col))

   val options = Array[AnyRef]("Insert numbers", "Insert list of numbers", "see matlist")
    val n = JOptionPane.showOptionDialog(null, "How to proceed?", "User mode", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options(2))
  }
}

object MouseListener {
  def apply(row: Int, col: Int): MouseListener = MouseListenerImplements(row: Int, col: Int)

  private case class MouseListenerImplements(row: Int, col: Int) extends MouseListener
}
