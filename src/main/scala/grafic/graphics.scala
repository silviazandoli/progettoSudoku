package grafic

import java.awt.{Dimension, Frame, Label}

class MainFrame extends Frame {
  def closeOperation() { sys.exit(0) }
}

class UI extends MainFrame {
  //val title = "GUI Program #1"
  override val preferredSize = new Dimension(320, 240)
  val contents = new Label("Here is the contents!")

  contents.setText("GUI Program #1")
}

object GuiProgramOne extends App {
  val ui = new UI
  ui.setVisible(true)
  println("End of main function")
}
