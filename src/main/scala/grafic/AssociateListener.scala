package grafic

object AssociateListener {
  import java.awt.{Dimension, GridLayout}

  import grafic.event.{MouseListener, WriteOnCell}
  import grafic.panels.TextOpNumber.TextOpNumber
  import grafic.util._
  import javax.swing.JPanel
  import utility.{dimSudoku, puzzle}

  def createMatrix(): Unit = {
    val matrixGame = new JPanel()

    matrixGame.setPreferredSize(new Dimension(MATRIX_WIDTH, MATRIX_HEIGHT))
    matrixGame.setLayout(new GridLayout(dimSudoku, dimSudoku))

    cp.add(matrixGame)

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
  }
}
