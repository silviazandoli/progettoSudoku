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

/*made by Zandoli*/

object FileChooser {
  var count=1
  
//method for the upload of a sudoku
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

  def processFile(f: File) = {
    println(f)
    loadPuzzle(f.toString)
    initList()
    val sudokuSolver = FullExploration(getPuzzle)
    sudokuSolver.solve(0, 0)
    //setPuzzleResolt(sudokuSolver.returnPuzzle())
    graficSet(sudokuSolver.returnPuzzle())
    val sudoku = Sudoku()
    sudoku.create()
  }

  def cont() = {
    count = count + 1
    if (count != 1) {
      startGame()
      if (startStop == true) startGame()
    }
  }
}

//using of the pattern implicit
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
