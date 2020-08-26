package grafic.util

object CreateMatrix {
  import javax.swing.{JPanel,BorderFactory}
  import java.awt.{Dimension, GridLayout, Color}
  import utility.{dimSudoku, puzzle}
  import grafic.{cp, tfCells, masks}
  import grafic.panels.TextOpNumber.TextOpNumber

  def createMatrix(): Unit = {
    val matrixGame = new JPanel()

    matrixGame.setPreferredSize(new Dimension(MATRIX_WIDTH, MATRIX_HEIGHT))
    matrixGame.setLayout(new GridLayout(dimSudoku, dimSudoku))

    cp.add(matrixGame)

    for (row <- 0 until dimSudoku; col <- 0 until dimSudoku) {
      tfCells(row)(col) = TextOpNumber()
      tfCells(row)(col).setBorder(BorderFactory.createLineBorder(Color.black))
      matrixGame.add(tfCells(row)(col)) // ContentPane adds JTextArea

      puzzle(row)(col) match {
        case 0 =>
          tfCells(row)(col).setText("")
          tfCells(row)(col).setBackground(OPEN_CELL_BGCOLOR)

          masks(row)(col) = false

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

    for {
      i <- 0 until dimSudoku
      j <- 2 until dimSudoku by 3
    } {
      tfCells(i)(j).setBorder(BorderFactory.createMatteBorder(1,1,1,3,Color.red))
    }

    for {
      i <- 2 until dimSudoku by 3
      j <- 0 until dimSudoku
    } {
      tfCells(i)(j).setBorder(BorderFactory.createMatteBorder(1,1,3,1,Color.red))
    }
  }
}
