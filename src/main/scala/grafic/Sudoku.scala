package grafic

import scala.swing.event.Event

/**
 * Made by Pacini
 */
//evento che ti può dare la possibilità di cliccare sulla casella
case class SudokuEvent(x: Int, y: Int) extends Event

object Sudoku {
  import java.awt.{Dimension, _}
  import javax.swing.JFrame
  import javax.swing.WindowConstants.EXIT_ON_CLOSE
  import grafic.panels.SPanel
  import grafic.util._
  import grafic.FileChooserMain.mainFrame

  sealed trait SudokuTrait extends JFrame {

    def create(): Unit = {
      this.setLocation(300, 50) //center
      var matrix = this
      cp = this.getContentPane
      CreateMatrix.createMatrix()

      cp.add(SPanel(new Dimension(MATRIX_WIDTH / 2, MATRIX_HEIGHT / 2)), BorderLayout.WEST)
      cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT))
      pack()

      //mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
      mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE)

      showNumberList.setEditable(false)
      showNumberList.setEnabled(false)

      setTitle("Sudoku")
      setVisible(true)
      }
    }
  case class Sudoku() extends SudokuTrait
}
