package grafic

import javax.swing.JTextArea

import scala.swing.event.Event

//evento che ti può dare la possibilità di cliccare sulla casella
case class SudokuEvent(x: Int, y: Int) extends Event

object Sudoku {
  import java.awt.{Dimension, _}

  import grafic.event.{MouseListener, WriteOnCell}
  import grafic.panels.SPanel
  import grafic.panels.TextOpNumber.TextOpNumber
  import grafic.util._
  import javax.swing.{JFrame, JPanel}
  import utility.{dimSudoku, puzzle}

  sealed trait SudokuTrait extends JFrame {
    def create(): Unit = {
      this.setLocation(300, 50) //center

      cp = this.getContentPane
      val matrixGame = new JPanel()

      matrixGame.setPreferredSize(new Dimension(MATRIX_WIDTH, MATRIX_HEIGHT))
      matrixGame.setLayout(new GridLayout(dimSudoku, dimSudoku))

      cp.add(matrixGame)

      val tfCells = Array.ofDim[JTextArea](dimSudoku, dimSudoku)

      // Construct 9x9 JTextFields and add to the content-pane
      for (row <- 0 until dimSudoku; col <- 0 until dimSudoku) {
        tfCells(row)(col) = TextOpNumber()

        matrixGame.add(tfCells(row)(col)) // ContentPane adds JTextArea

        puzzle(row)(col) match {
          case 0 =>
            tfCells(row)(col).setText("")
            tfCells(row)(col).setBackground(OPEN_CELL_BGCOLOR)

            masks(row)(col) = false

            //aggiunta controlli-> che sia inserito un carattere che sia un numero, che il numero inserito non sia corretto
            //(nel caso non appartenga alla matList), etc
            tfCells(row)(col).addKeyListener(WriteOnCell(row, col))
            tfCells(row)(col).addMouseListener(MouseListener(row, col))

          case _ =>
            tfCells(row)(col).setText(puzzle(row)(col) + "")
            tfCells(row)(col).setEditable(false)
            tfCells(row)(col).setBackground(CLOSED_CELL_BGCOLOR)
            tfCells(row)(col).setForeground(CLOSED_CELL_TEXT)

            masks(row)(col) = true
        }

        // Beautify all the cells
        tfCells(row)(col).setAlignmentX(10)
        tfCells(row)(col).setFont(FONT_NUMBERS)
      }

      cp.add(SPanel(new Dimension(MATRIX_WIDTH / 2, MATRIX_HEIGHT / 2)), BorderLayout.WEST)

      cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT))
      pack()
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) // Handle window closing // Handle window closing

      showNumberList.setEditable(false)
      showNumberList.setEnabled(false)

      setTitle("Sudoku")
      setVisible(true)
      }
    }

  case class Sudoku() extends SudokuTrait
}
