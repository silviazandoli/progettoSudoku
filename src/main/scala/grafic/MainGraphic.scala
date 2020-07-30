package grafic

import grafic.Sudoku.Sudoku
import javax.swing.JFileChooser
import resolutionAlgorithm.FullExploration
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle
import utility.getPuzzle

object MainGraphic extends App {
  /** uploading multiple Sudoku by Zandoli
   *
   */
  def initAndUpload(): Unit = {
    val jfc = new JFileChooser("input")
    val retValue = jfc.showOpenDialog(null)
    if (retValue == JFileChooser.APPROVE_OPTION) {
      val file = jfc.getSelectedFile
      println(file.getAbsolutePath)
      loadPuzzle(file.getAbsolutePath)
      initList()

      val sudokuSolver = FullExploration(getPuzzle)
      sudokuSolver.solve(0, 0)

      val sudoku = Sudoku(sudokuSolver.returnPuzzle())
      sudoku.create()
    }
  }
  initAndUpload()
}
