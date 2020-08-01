package grafic.event.moduleListener



import java.awt.Color

import grafic.Sudoku.Sudoku
import grafic.{cp, setPressed, setPuzzleResolt, utentSolved}
import javax.swing.{JFileChooser, JOptionPane, JTextField}
import resolutionAlgorithm.FullExploration
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle
import utility.getPuzzle

protected[event] object ControlNumbersAndFinish {


  def seeVision(possibleValues: Set[Int], number: Int, t: JTextField): Unit = {
    if (possibleValues.contains(number)) {
      t.setForeground(Color.green)
      val messageOk = "The number belongs to list "
      JOptionPane.showMessageDialog(cp, messageOk,
        "Message", JOptionPane.WARNING_MESSAGE)
    } else {
      setPressed(-1, -1)

      t.setForeground(Color.red)
      var message = "The number is not correct! Possible values: "
      possibleValues.foreach(v => message = message + v + " ")
      JOptionPane.showMessageDialog(cp, message, "Message", JOptionPane.WARNING_MESSAGE)
    }


  }

  def actionUtent(): Unit = {
    if (utentSolved()) {
      JOptionPane.showMessageDialog(cp, "Game end, Puzzle solved", "Message", JOptionPane.DEFAULT_OPTION)
      val option = JOptionPane.showConfirmDialog(null, "New Game?", "Message", JOptionPane.YES_NO_CANCEL_OPTION)
      option match {
        case 0 =>
          cp.setVisible(false)

          initAndUpload()
        case 1 => System.exit(0)
        case _ => System.out.println("cancel")
      }
    }
  }

  //re-upload after one having done one game
  def initAndUpload(): Unit = {
    //val jfc = new JFileChooser("input")
    val jfc = new JFileChooser("input")
    val retValue = jfc.showOpenDialog(null)
    if (retValue == JFileChooser.APPROVE_OPTION) {
      val file = jfc.getSelectedFile
      println(file.getAbsolutePath)
      loadPuzzle(file.getAbsolutePath)
      initList()

      val sudokuSolver = FullExploration(getPuzzle)
      sudokuSolver.solve(0, 0)

      setPuzzleResolt(sudokuSolver.returnPuzzle())

      val sudoku = Sudoku()
      sudoku.create()
    }
  }

}

