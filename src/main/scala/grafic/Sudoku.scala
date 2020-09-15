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
  import grafic.panels.SPanel
  import grafic.util._

  sealed trait SudokuTrait extends JFrame {

    /**
     * create panel for sudoku matrix and JTextField for
     * show of possible numbers in each cell on list
     */
    def create(): Unit = {
      this.setLocation(300, 50) //center
      cp = this.getContentPane
      CreateMatrix.createMatrix()

      cp.add(SPanel(new Dimension(MATRIX_WIDTH / 2, MATRIX_HEIGHT / 2)), BorderLayout.WEST)
      cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT))
      pack()

      showNumberList.setEditable(false)
      showNumberList.setEnabled(false)

      setTitle("Sudoku")
      setVisible(true)
      }
    }
  case class Sudoku() extends SudokuTrait
}
