package grafic.event

import java.awt.event.{MouseAdapter, MouseEvent}

import grafic.event.moduleListener.MatListVision
import grafic.setWrite
import javax.swing.JOptionPane
import grafic.util.{NUMBER, NUMBER_LIST, SEE_MATLIST}
import utility.matList

sealed trait MouseListener extends MouseAdapter {
  val row: Int
  val col: Int
  val possibleValues = matList(row)(col).toSet

  //aggiunto evento per cliccare su ogni casella
  override def mousePressed(e: MouseEvent): Unit = {
    selectNumber() //the called method on mouse click
  }



  def selectNumber(): Unit = {
   val options = Array[AnyRef]("Insert numbers", "Insert list of numbers", "See matlist")
    val n = JOptionPane.showOptionDialog(null, "How to proceed?", "User mode", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options(2))

    n match {
      case 1 => setWrite(NUMBER_LIST)
      case 2 => MatListVision.seeVision(possibleValues)
      case _ => setWrite(NUMBER)
    }
  }
}

object MouseListener {
  def apply(row: Int, col: Int): MouseListener = MouseListenerImplements(row: Int, col: Int)

  private case class MouseListenerImplements(row: Int, col: Int) extends MouseListener
}
