package grafic.event

import java.awt.event.{MouseAdapter, MouseEvent}

<<<<<<< HEAD
import grafic.event.moduleListener.MatListVision
import grafic.panels.TextOpNumber.TextOpNumber
=======
import grafic.event.moduleListener.{MatListVision, SayHelp}
>>>>>>> 4f2a35d9e1c728b8e295e4c5be069e6ac2cc7c1e
import grafic.setWrite
import grafic.util.{NUMBER, NUMBER_LIST}
import javax.swing.{JOptionPane, JTextField}
import utility.matList

sealed trait MouseListener extends MouseAdapter {
  val row: Int
  val col: Int
  val possibleValues: Set[Int] = matList(row)(col).toSet

  //aggiunto evento per cliccare su ogni casella
  override def mousePressed(e: MouseEvent): Unit = {
    val t: TextOpNumber = e.getSource.asInstanceOf[TextOpNumber]
    if (t.isEditable) {selectNumber()} //the called method on mouse click
  }

  def selectNumber(): Unit = {
   val options = Array[AnyRef]("Insert numbers", "Insert list of numbers", "See matlist", "Help!")
    val n = JOptionPane.showOptionDialog(null, "How to proceed?", "User mode", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options(3))

    n match {
      case 1 => setWrite(NUMBER_LIST)
      case 2 => MatListVision.seeVision(possibleValues)
      case 3 => SayHelp.sayHelp(row,col)
      case _ => setWrite(NUMBER)
    }
  }
}

object MouseListener {
  def apply(row: Int, col: Int): MouseListener = MouseListenerImplements(row: Int, col: Int)

  private case class MouseListenerImplements(row: Int, col: Int) extends MouseListener
}
