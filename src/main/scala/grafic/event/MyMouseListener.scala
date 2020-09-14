package grafic.event

import java.awt.event.{MouseEvent, MouseListener}

import javax.swing.JOptionPane
import grafic.event.moduleListener.{MatListVision, SayHelp}
import grafic.panels.TextOpNumber.TextOpNumber
import grafic.graficSet
import grafic.util.{FONT_MATLIST, FONT_MINILIST, NUMBER, NUMBER_LIST}
import utility.matList

/**
 * Made By Pacini (Alert Dialog made by Zandoli, n match made by Pacini)
 */
sealed trait MyMouseListener extends CellListener with MouseListener {

  //add event to click over each cell
  def mouseReleased(e: MouseEvent): Unit = {
    val t: TextOpNumber = e.getSource.asInstanceOf[TextOpNumber]
    if (t.isEditable) {actionCell(t: TextOpNumber)} //the called method on mouse click
  }

  def actionCell(t: TextOpNumber): Int = {
   val options = Array[AnyRef]("Insert numbers", "Insert list of numbers", "See matlist", "Help!")
    val n = JOptionPane.showOptionDialog(null, "How to proceed?", "User mode", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options(3))

    n match {
      case 1 => t.setText(""); t.setFont(FONT_MINILIST); graficSet[String](NUMBER_LIST)
      case 2 => MatListVision.seeVision(matList(row)(col).toSet, t)
      case 3 => SayHelp.sayHelp(row,col,t)
      case _ => t.setText(""); t.setFont(FONT_MATLIST); graficSet[String](NUMBER)
    }

    n
  }
}

object MyMouseListener {
  def apply(row: Int, col: Int): MyMouseListener = MouseListenerImplements(row: Int, col: Int)
  private case class MouseListenerImplements(row: Int, col: Int) extends MyMouseListener {
    override def mouseClicked(e: MouseEvent): Unit = {}
    override def mousePressed(e: MouseEvent): Unit = {}
    override def mouseEntered(e: MouseEvent): Unit = {}
    override def mouseExited(e: MouseEvent): Unit = {}
  }
}
