package grafic

import java.awt.event.{ActionListener, MouseAdapter, MouseEvent}
import java.awt.{Dimension, _}

import javax.swing.{JFrame, JPanel, JTextField}
import utility.{dimSudoku, matList, puzzle, tfCells}

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
    private val DisplayHeight = 580 //sudoku display its 580 pixels high
    private val ButtonsWidth = 200 //button panel its 200 pixels wide
    private val WindowWidth = 777 //its 777 pixels wide


    //private val masks = Array(Array(false, false, true, false, false, true, false, false, true), Array(false, true, false, false, false, false, false, false, true), Array(false, false, false, false, true, false, false, false, false), Array(false, false, false, false, false, true, false, false, true), Array(false, true, false, true, false, false, false, false, false), Array(false, false, false, false, false, false, false, false, true), Array(false, false, true, false, false, true, false, false, false), Array(false, true, false, false, false, false, true, false, false), Array(false, false, false, false, false, false, false, false, true))
    private val WindowHeight = 636 //its 636 pixels high

    def create(): Unit = {

      /* val f = new JFrame("Sudoku v3.0")

       f.setResizable(false) //not to be resized


       f.setSize(WindowWidth, WindowHeight) //size fixed by size of display and borders

       f.setLocation(0, 0) //start top left

       f.setLayout(new BorderLayout) //north south east west and centre*/

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

          //aggiunta controlli-> che sia inserito un carattere che sia un numero, che il numero inserito non sia corretto
          //(nel caso non appartenga alla matList), etc

          val event: ActionListener = EventMouse(row, col, cp, puzzleResolt)
          tfCells(row)(col).addActionListener(event)

          //possibilità di cliccare su ogni casella
          tfCells(row)(col).addMouseListener(new MouseAdapter() //we listen for mouse clicks on this panel
          {
            //aggiunto evento per cliccare su ogni casella
            override def mousePressed(e: MouseEvent): Unit = {
              selectNumber(e.getX, e.getY); //the called method on mouse click

              println("MatList riga " + row + " colonna " + col + " è " + matList(row)(col))

            } //end of mouse select
          }); //end of mouse listener
          // prima era cp
          def selectNumber(row: Int, col: Int): Unit = {


          }

          matrixGame.add(tfCells(row)(col)) // ContentPane adds JTextField

          puzzle(row)(col) match {
            case 0 =>
              tfCells(row)(col).setText("")
              // tfCells(row)(col).setText(matList(row)(col).toString()) // set to empty string
              tfCells(row)(col).setEditable(true)
              tfCells(row)(col).setBackground(OPEN_CELL_BGCOLOR)
            //  tfCells(row)(col).addActionListener(listener)
            case _ =>
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

      // CANVAS_WIDTH/3 = 180

      val spanelImplements = SPanelImplements(new Dimension(MATRIX_WIDTH / 2, MATRIX_HEIGHT / 2))

      cp.add(spanelImplements, BorderLayout.WEST)

      cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT))
      pack()
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) // Handle window closing // Handle window closing

      //add the panel for the buttons

      //import grafic.SPanel

      //cp.add(new SPanel(new Dimension(0, CANVAS_HEIGHT)), BorderLayout.WEST) //set the borders

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
