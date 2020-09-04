package grafic

import java.awt.Dimension
import java.awt.event.{ActionEvent, ActionListener, KeyEvent}
import java.io.File

import grafic.Sudoku.Sudoku
import grafic.panels.AuxFunctSPanel
import grafic.panels.AuxFunctSPanel.{startGame, startStop}
import grafic.panels.funAux.SaveLoad
import javax.swing._

import javax.swing.filechooser.FileNameExtensionFilter
import resolutionAlgorithm.FullExploration
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle
import utility.getPuzzle

//Made by Zandoli

object MyMenuHelpers {
  def createMenu(menu: JMenuItem*): JMenu = {
    val menuItem = new JMenu("File")
    menu.foreach(menuItem.add(_))
    menuItem
  }
  // Uses an implicit conversion to shorten the code
  implicit def functionActionListener(f: ActionEvent => Unit) =
    new ActionListener {
      def actionPerformed(event: ActionEvent) = f(event)
    }
}

object FileChooserMain extends App {

  var count = 1
  var load=false
  val mainFrame = new JFrame("Sudoku")
  mainFrame.setPreferredSize(new Dimension(400, 300))
  val menuBar = new JMenuBar()
  val openEasy = new JMenuItem("Open Easy", KeyEvent.VK_O)
  val openMedium = new JMenuItem("Open Intermedium", KeyEvent.VK_F)
  val openHard = new JMenuItem(" Open Hard", KeyEvent.VK_D)
  val loadFile = new JMenuItem("Load Old", KeyEvent.VK_Y)
  val aboutMenu = new JMenuItem("About", KeyEvent.VK_U)
  val exitMenu = new JMenuItem("Exit", KeyEvent.VK_X)

  openEasy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK))
  openMedium.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK))
  openHard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK))
  loadFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.ALT_MASK))
  aboutMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.ALT_MASK))
  exitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK))

  import grafic.MyMenuHelpers._

  mainFrame.setJMenuBar(menuBar)
  val menu = createMenu(openEasy, openMedium, openHard, loadFile, aboutMenu, exitMenu)
  menuBar.add(menu)

  openEasy.addActionListener((_: ActionEvent) => (load=false,initAndUpload(mainFrame, "input/easy"), cont()))
  openMedium.addActionListener((_: ActionEvent) => (load=false,initAndUpload(mainFrame, "input/medium"), cont()))
  openHard.addActionListener((_: ActionEvent) => (load=false,initAndUpload(mainFrame, "input/hard"), cont()))
 loadFile.addActionListener((_: ActionEvent) => (load=true,SaveLoad.read(),initAndUpload(mainFrame,"temp"),cont()))
  val text="made by Pacini, Zandoli, Antonelli"
  aboutMenu.addActionListener((_:ActionEvent)=>JOptionPane.showMessageDialog(mainFrame, s"Sudoku ${text}"))
  exitMenu.addActionListener((_:ActionEvent)=>sys.exit(0))

  mainFrame.pack()
  mainFrame.setVisible(true)

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