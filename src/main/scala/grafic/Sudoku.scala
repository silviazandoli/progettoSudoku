package grafic

import scala.swing.event.Event

//evento che ti può dare la possibilità di cliccare sulla casella
case class SudokuEvent(x: Int, y: Int) extends Event

object Sudoku {
  import java.awt.{Dimension, _}
  import java.awt.event.{WindowAdapter, WindowEvent}
  import grafic.panels.SPanel
  import grafic.util._
  import grafic.panels.AuxFunctSPanel.{timeInit, stopVar}
  import javax.swing.JFrame

  sealed trait SudokuTrait extends JFrame {
    def create(): Unit = {
      this.setLocation(300, 50) //center

      cp = this.getContentPane

      CreateMatrix.createMatrix()

      cp.add(SPanel(new Dimension(MATRIX_WIDTH / 2, MATRIX_HEIGHT / 2)), BorderLayout.WEST)
      cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT))
      pack()
      //handle window closing si fa in FileChooserMain così se chiudo la matrice del Sudoku l'interfaccia
      //dell'upload rimane

      this.addWindowListener(new WindowAdapter {
        override def windowClosed(e: WindowEvent) {
          synchronized {
            stopVar = true
            timeInit = 0
            score = 0
            textTime.setText("")
          }
          super.windowClosed(e)
        }
      })

      showNumberList.setEditable(false)
      showNumberList.setEnabled(false)

      setTitle("Sudoku")
      setVisible(true)
      }
    }

  case class Sudoku() extends SudokuTrait
}
