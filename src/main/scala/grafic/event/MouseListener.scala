package grafic.event

import java.awt.event.{MouseAdapter, MouseEvent}

object MouseListener {
  import utility.{puzzle, matList}

  trait MouseListenerTrait extends MouseAdapter {
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

  case class MouseListener(row: Int, col: Int) extends MouseListenerTrait
}
