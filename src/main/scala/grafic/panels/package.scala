package grafic

package object panels {
  import java.awt.{Color, FlowLayout}
  import javax.swing.{JButton, JPanel}

  val pb = new JPanel() //create the button panel
  val FL = new FlowLayout()

  //you have the possibility to write the number in the square
  val CS = new JButton(" Undo")

  val startStopButton = new JButton(" StartStop ")

  val ES = new JButton(" Easy ")
  val MS = new JButton(" Medium ")
  val HS = new JButton(" Hard ")

  val WS = new Color(0xf5, 0xf5, 0xf5) //White Smoke

  val ButtonsHeight = 20 //sudoku display its 580 pixels high
  val ButtonsWidth = 100 //button panel its 200 pixels wide

  var thread: Thread = _
}