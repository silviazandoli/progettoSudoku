package grafic

import java.awt.{Color, Dimension, Font, GridLayout}

import javax.swing.{JFrame, JTextField}
import utility.{dimSudoku, puzzle, tfCells}

class Sudoku extends JFrame {
  val SUBGRID_SIZE = 3 // Size of the sub-grid

  val CELL_SIZE = 60 // Cell width/height in pixels

  val CANVAS_WIDTH: Int = CELL_SIZE * dimSudoku
  val CANVAS_HEIGHT: Int = CELL_SIZE * dimSudoku

  val OPEN_CELL_BGCOLOR: Color = Color.YELLOW
  val OPEN_CELL_TEXT_YES = new Color(0, 255, 0) // RGB

  val OPEN_CELL_TEXT_NO: Color = Color.RED
  val CLOSED_CELL_BGCOLOR = new Color(240, 240, 240)
  val CLOSED_CELL_TEXT: Color = Color.BLACK
  val FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20)

  private val masks = Array(Array(false, false, true, false, false, true, false, false, true), Array(false, true, false, false, false, false, false, false, true), Array(false, false, false, false, true, false, false, false, false), Array(false, false, false, false, false, true, false, false, true), Array(false, true, false, true, false, false, false, false, false), Array(false, false, false, false, false, false, false, false, true), Array(false, false, true, false, false, true, false, false, false), Array(false, true, false, false, false, false, true, false, false), Array(false, false, false, false, false, false, false, false, true))

  def create(): Unit = {
    val cp = this.getContentPane
    cp.setLayout(new GridLayout(dimSudoku, dimSudoku)) // 9x9 GridLayout

    val listener = new InputListener
    // Construct 9x9 JTextFields and add to the content-pane
    for (row <- 0 until dimSudoku) {
      for (col <- 0 until dimSudoku) {

        tfCells(row)(col) = new JTextField() // Allocate element of array

        cp.add(tfCells(row)(col)) // ContentPane adds JTextField

        if (masks(row)(col)) {
          tfCells(row)(col).setText("") // set to empty string

          tfCells(row)(col).setEditable(true)
          tfCells(row)(col).setBackground(OPEN_CELL_BGCOLOR)

          tfCells(row)(col).addActionListener(listener)
        }
        else {
          tfCells(row)(col).setText(puzzle(row)(col) + "")
          tfCells(row)(col).setEditable(false)
          tfCells(row)(col).setBackground(CLOSED_CELL_BGCOLOR)
          tfCells(row)(col).setForeground(CLOSED_CELL_TEXT)
        }
        // Beautify all the cells
        tfCells(row)(col).setHorizontalAlignment(10)
        tfCells(row)(col).setFont(FONT_NUMBERS)
      }
    }

    cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT))
    pack()
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) // Handle window closing // Handle window closing

    setTitle("Sudoku")
    setVisible(true)
  }
}
