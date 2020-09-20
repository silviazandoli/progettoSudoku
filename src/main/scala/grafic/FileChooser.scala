package grafic

import java.io.File

import grafic.Sudoku.Sudoku
import grafic.panels.AuxFunctSPanel
import grafic.panels.AuxFunctSPanel.{startGame, startStop}
import javax.swing._
import javax.swing.filechooser.FileNameExtensionFilter
import resolutionAlgorithm.FullExploration
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle
import utility.getPuzzle

/**
 * made by Zandoli
 *
 * object useful for FileChooserMain.
 *
 * */

object FileChooser {
  var count = 1

  /**
   * it enables to navigate the directories in the file system,and then choosing a file from a list
   *
   * @param frame    the frame of the interface
   * @param modality the initial directory
   */
  def initAndUpload(frame: JFrame, modality: String): Unit = {
    import grafic.Helpers._
    AuxFunctSPanel.firstTime = true
    //use of implicit
    val jfc = modality.filechooser()
    val retValue = jfc.open(frame)
    if (retValue == JFileChooser.APPROVE_OPTION) {
      //val file = jfc.multipleFiles()
      val file = jfc.selectedFile()
      //open one sudoku
      processFile(file)
      //file.foreach(processFile)
    }
  }

  /**
   * it creates a Sudoku to solve from a file
   *
   * @param f the file
   */
  def processFile(f: File) = {
    println(f)
    loadPuzzle(f.toString)
    initList()
    val sudokuSolver = FullExploration(getPuzzle)
    sudokuSolver.solve(0, 0)
    graficSet(sudokuSolver.returnPuzzle())
    val sudoku = Sudoku()
    sudoku.create()
  }

  /**
   * used for starting the timer when you open a sudoku
   */
  def cont() = {
    count = count + 1
    if (count != 1) {
      startGame()
      if (startStop == true) startGame()
    }
  }
}

/**
 * an object with implicit classes that are helpers for [[grafic.FileChooser]]
 */
object Helpers {

  implicit class MyStringHelper(str: String) {
    def filechooser() = {
      val jfc = new JFileChooser(str)
      jfc.setMultiSelectionEnabled(false)

      jfc.setAcceptAllFileFilterUsed(false)
      val filter = new FileNameExtensionFilter("Files txt", "txt")
      jfc.addChoosableFileFilter(filter)
      jfc
    }
  }

  implicit class MyFileChooserHelper(jfc: JFileChooser) {
    def open(frame: JFrame) = jfc.showOpenDialog(frame)

    //def multipleFiles() = jfc.getSelectedFiles()
    def selectedFile() = jfc.getSelectedFile()
  }

}
