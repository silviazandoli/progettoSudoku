package grafic

import java.awt.event.ActionEvent
import java.awt.{Color, Dimension, Font, GridLayout}

import javax.swing.{JFrame, JOptionPane, JTextField}
import utility.{dimSudoku, matList, puzzle, tfCells}

import scala.swing.event.Event

//evento che ti può dare la possibilità di cliccare sulla casella
case class SudokuEvent(x: Int, y: Int) extends Event


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

  //private val masks = Array(Array(false, false, true, false, false, true, false, false, true), Array(false, true, false, false, false, false, false, false, true), Array(false, false, false, false, true, false, false, false, false), Array(false, false, false, false, false, true, false, false, true), Array(false, true, false, true, false, false, false, false, false), Array(false, false, false, false, false, false, false, false, true), Array(false, false, true, false, false, true, false, false, false), Array(false, true, false, false, false, false, true, false, false), Array(false, false, false, false, false, false, false, false, true))

  def create(): Unit = {
    val cp = this.getContentPane
    cp.setLayout(new GridLayout(dimSudoku, dimSudoku)) // 9x9 GridLayout


    // Construct 9x9 JTextFields and add to the content-pane
    for (row <- 0 until dimSudoku) {
      for (col <- 0 until dimSudoku) {

        tfCells(row)(col) = new JTextField() // Allocate element of array

        //aggiunta controlli che sia inserito un numero che non sia fuori dalla matList etc
        tfCells(row)(col).addActionListener((e: ActionEvent) => {
          val t: JTextField = e.getSource.asInstanceOf[JTextField]
          try {
            println(t.getText.toInt)
            val number = t.getText.toInt
            t.setBackground(Color.yellow)
            val possibleValues = matList(row)(col).toSet

            if (possibleValues.contains(number)) {
              t.setForeground(Color.green)
              JOptionPane.showMessageDialog(cp, "Good! The number is in MatList", "Message", JOptionPane.DEFAULT_OPTION)
            } else {
              t.setForeground(Color.red)

            }

            //it shows the list of possible values
            //(ps: ho fatto che l'utente può vedere i numeri candidati per quella cella quando l'utente inserisce un numero errato in una
            //determinata casella
            if (!possibleValues.contains(number)) {
              var message = "The number is not correct! Possible values: "
              possibleValues.foreach(v => message = message + v + " ")
              JOptionPane.showMessageDialog(cp, message, "Message", JOptionPane.WARNING_MESSAGE)

            }
          } catch {
            case _: Throwable => t.setForeground(Color.red)

              JOptionPane.showMessageDialog(cp, "It wasn't inserted a number!", "Messaggio", JOptionPane.WARNING_MESSAGE)
          }

        })
        /*JOptionPane.showMessageDialog(yourFrame,
    "WARNING.",
    "Warning",
    JOptionPane.WARNING_MESSAGE);*/
        cp.add(tfCells(row)(col)) // ContentPane adds JTextField
        val puzzleVal = puzzle(row)(col)

        if (puzzleVal == 0) {
          tfCells(row)(col).setText("")
         // tfCells(row)(col).setText(matList(row)(col).toString()) // set to empty string

          tfCells(row)(col).setEditable(true)
          tfCells(row)(col).setBackground(OPEN_CELL_BGCOLOR)

          //  tfCells(row)(col).addActionListener(listener)
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
