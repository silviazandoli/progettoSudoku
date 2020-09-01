package grafic.event.moduleListener

protected[event] object ControlNumbersAndFinish {
  import java.awt.Color

  import grafic.{cp, setPressed, utentSolved}
  import javax.swing.{JOptionPane, JTextArea}


  def seeVision(possibleValues: Set[Int], number: Int, t: JTextArea): Unit = {
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
          //cp.setVisible(false)

         // reupload of the sudoku f
          //the interface of Sudoku remains open, so you don't have to write anything here
          //when you finish the game click the exit button in the matrix and open a new file from the interface n
        //  FileChooser.initAndReUpload("input")

          //FileChooserMain.initAndReUpload(null)
        case 1 => System.exit(0)
        case _ => System.out.println("cancel")
      }
    }
  }

  //riapload di un altro sudoku quando si è già giocato (non si riapre più l'interfaccia dell'inizio)
 /* def initAndReUpload(): Unit = {
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
  }*/

}

