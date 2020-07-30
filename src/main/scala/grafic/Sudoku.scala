package grafic

import java.awt.{Dimension, _}

import grafic.event.{MouseListener, WriteOnCell}
import javax.swing.{JFrame, JPanel, JTextField}
import utility.{dimSudoku, puzzle, tfCells}

import scala.swing.event.Event

//evento che ti può dare la possibilità di cliccare sulla casella
case class SudokuEvent(x: Int, y: Int) extends Event

object Sudoku {

  trait SudokuTrait extends JFrame {
    val SUBGRID_SIZE = 3 // Size of the sub-grid

    val MATRIX_CELL_SIZE = 30 // Cell width/height in pixels
    val CELL_SIZE = 70 // Cell width/height in pixels

    val MATRIX_WIDTH: Int = MATRIX_CELL_SIZE * dimSudoku // 60 x 9 = 540
    val MATRIX_HEIGHT: Int = MATRIX_CELL_SIZE * dimSudoku

    val CANVAS_WIDTH: Int = CELL_SIZE * dimSudoku // 70 x 9 = 630
    val CANVAS_HEIGHT: Int = CELL_SIZE * dimSudoku

    val OPEN_CELL_BGCOLOR: Color = Color.YELLOW
    val OPEN_CELL_TEXT_YES = new Color(0, 255, 0) // RGB

    val OPEN_CELL_TEXT_NO: Color = Color.RED
    val CLOSED_CELL_BGCOLOR = new Color(240, 240, 240)
    val CLOSED_CELL_TEXT: Color = Color.BLACK
    val FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20)
    val puzzleResolt: Array[Array[Int]]
    private val WS = new Color(0xf5, 0xf5, 0xf5) //White Smoke

    def create(): Unit = {
      /* f.setLayout(new BorderLayout) //north south east west and centre*/

      this.setLocation(300, 50) //center

      val cp = this.getContentPane
      val matrixGame = new JPanel()

      matrixGame.setPreferredSize(new Dimension(MATRIX_WIDTH, MATRIX_HEIGHT))
      matrixGame.setLayout(new GridLayout(dimSudoku, dimSudoku))

      cp.add(matrixGame)

      // Construct 9x9 JTextFields and add to the content-pane
      for (row <- 0 until dimSudoku) {
        for (col <- 0 until dimSudoku) {

          tfCells(row)(col) = new JTextField() // Allocate element of array

          matrixGame.add(tfCells(row)(col)) // ContentPane adds JTextField

          puzzle(row)(col) match {
            case 0 =>
              tfCells(row)(col).setText("")
              // tfCells(row)(col).setText(matList(row)(col).toString()) // set to empty string
              tfCells(row)(col).setEditable(true)
              tfCells(row)(col).setBackground(OPEN_CELL_BGCOLOR)

              masks(row)(col) = false

              //aggiunta controlli-> che sia inserito un carattere che sia un numero, che il numero inserito non sia corretto
              //(nel caso non appartenga alla matList), etc
              tfCells(row)(col).addActionListener(WriteOnCell(row, col, cp, puzzleResolt))
              tfCells(row)(col).addMouseListener(MouseListener(row, col))

            case _ =>
              tfCells(row)(col).setText(puzzle(row)(col) + "")
              tfCells(row)(col).setEditable(false)
              tfCells(row)(col).setBackground(CLOSED_CELL_BGCOLOR)
              tfCells(row)(col).setForeground(CLOSED_CELL_TEXT)

              masks(row)(col) = true
          }

          // Beautify all the cells
          tfCells(row)(col).setHorizontalAlignment(10)
          tfCells(row)(col).setFont(FONT_NUMBERS)
        }
      }

      cp.add(SPanel(new Dimension(MATRIX_WIDTH / 2, MATRIX_HEIGHT / 2)), BorderLayout.WEST)

      cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT))
      pack()
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) // Handle window closing // Handle window closing

      setTitle("Sudoku")
      setVisible(true)


      //set the borders

      /*  //val dp: Nothing = new Nothing
         //set the background of the sudoku display black
        cp.add(dp.CS)

        f.add(dp.CS, BorderLayout.WEST) //add the sudoku display panel*/


    }
  }

  case class Sudoku(puzzleResolt: Array[Array[Int]]) extends SudokuTrait
}
