package grafic.event

import java.awt.event.{MouseAdapter, MouseEvent}
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
  }
}

object MouseListener {
  def apply(row: Int, col: Int): MouseListener = MouseListenerImplements(row: Int, col: Int)

  private case class MouseListenerImplements(row: Int, col: Int) extends MouseListener
}