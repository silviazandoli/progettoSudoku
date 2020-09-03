package grafic.event

import java.awt.event.{MouseAdapter, MouseEvent}
import javax.swing.JOptionPane

import grafic.event.moduleListener.{MatListVision, SayHelp}
<<<<<<< HEAD
import grafic.panels.TextOpNumber.TextOpNumber
=======
>>>>>>> 0ff42b8bfd007ad07745a66a1a1caba0d87d88db
import grafic.set
import grafic.util.{FONT_MATLIST, FONT_MINILIST, NUMBER, NUMBER_LIST}
import utility.matList

/**
 * Made By Pacini (Alert Dialog with control of numbers made by Zandoli, n match made by Pacini)
 */
sealed trait MouseListener extends MouseAdapter {
  val row: Int
  val col: Int

  //aggiunto evento per cliccare su ogni casella
  override def mousePressed(e: MouseEvent): Unit = {
    val t: TextOpNumber = e.getSource.asInstanceOf[TextOpNumber]
    if (t.isEditable) {selectNumber(t: TextOpNumber)} //the called method on mouse click
  }

  def selectNumber(t: TextOpNumber): Unit = {
   val options = Array[AnyRef]("Insert numbers", "Insert list of numbers", "See matlist", "Help!")
    val n = JOptionPane.showOptionDialog(null, "How to proceed?", "User mode", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options(3))

    n match {
      case 1 => t.setText(""); t.setFont(FONT_MINILIST); set[String](NUMBER_LIST)
      case 2 => MatListVision.seeVision(matList(row)(col).toSet, t)
      case 3 => SayHelp.sayHelp(row,col,t)
      case _ => t.setText(""); t.setFont(FONT_MATLIST); set[String](NUMBER)
    }
  }
}

object MouseListener {
  def apply(row: Int, col: Int): MouseListener = MouseListenerImplements(row: Int, col: Int)
  private case class MouseListenerImplements(row: Int, col: Int) extends MouseListener
}
