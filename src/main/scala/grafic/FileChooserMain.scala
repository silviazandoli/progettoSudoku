package grafic

import java.awt.Dimension
import java.awt.event.{ActionEvent, KeyEvent}
import java.io.File

import grafic.Sudoku.Sudoku
import grafic.panels.AuxFunctSPanel
import grafic.panels.AuxFunctSPanel.{startGame, startStop}
import grafic.panels.funAux.{SaveLoad, ThreadTime}
import javax.swing._
import javax.swing.filechooser.FileNameExtensionFilter
import resolutionAlgorithm.FullExploration
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle
import utility.getPuzzle

<<<<<<< HEAD
//Made by Zandoli
=======
import javax.swing.WindowConstants.EXIT_ON_CLOSE

object FileChooserMain extends App {
>>>>>>> 5bb2355887b2d463b51fdc09d3194d1862e5c714

object FileChooserMain extends App {

  var count = 1
  val mainFrame = new JFrame("Sudoku")
  val menuBar = new JMenuBar()
  val menu = new JMenu("File")
  val openEasy = new JMenuItem("Open Easy",
    KeyEvent.VK_O)
  mainFrame.setPreferredSize(new Dimension(400, 300))
  val openMedium = new JMenuItem("Open Intermedium", KeyEvent.VK_F)
  val openHard = new JMenuItem(" Open Hard", KeyEvent.VK_D)
  menu.setMnemonic(KeyEvent.VK_F)
  val loadFile = new JMenuItem("Load Old", KeyEvent.VK_Y)
  openEasy.setAccelerator(KeyStroke.getKeyStroke(
    KeyEvent.VK_O, ActionEvent.ALT_MASK))

  menuBar.add(menu)

  val aboutMenu = new JMenuItem("About", KeyEvent.VK_U)
  openMedium.setAccelerator(KeyStroke.getKeyStroke(
    KeyEvent.VK_F, ActionEvent.ALT_MASK))
  val exitMenu = new JMenuItem("Exit", KeyEvent.VK_X)
  openHard.setAccelerator(KeyStroke.getKeyStroke(
    KeyEvent.VK_D, ActionEvent.ALT_MASK))


  loadFile.setAccelerator(KeyStroke.getKeyStroke(
    KeyEvent.VK_Y, ActionEvent.ALT_MASK))
  var thread: ThreadTime = ThreadTime()
  aboutMenu.setAccelerator(KeyStroke.getKeyStroke(
    KeyEvent.VK_U, ActionEvent.ALT_MASK))
  var load = false
  exitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK))


  menu.add(openEasy)
  menu.add(openMedium)
  menu.add(openHard)
  menu.add(loadFile)
  menu.addSeparator()
  menu.add(aboutMenu)
  menu.add(exitMenu)
  mainFrame.setJMenuBar(menuBar)
  mainFrame.pack()
  mainFrame.setVisible(true)

<<<<<<< HEAD
  //mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
=======
  mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE)
>>>>>>> 5bb2355887b2d463b51fdc09d3194d1862e5c714

  openEasy.addActionListener((e: ActionEvent) => {
    load = false
    initAndUpload(mainFrame, "input/easy") 
    cont()
  })

  openMedium.addActionListener((e: ActionEvent) => {
    load = false
    initAndUpload(mainFrame, "input/medium")
    cont()
  })

  openHard.addActionListener((e: ActionEvent) => {
    load = false
    initAndUpload(mainFrame, "input/hard")
    cont()
  })

  loadFile.addActionListener((e: ActionEvent) => {
    load = true
    //if you load a game that you stopped you have to set the old time and score too
    SaveLoad.read()
    initAndUpload(mainFrame, "temp")
    cont()
  })

  exitMenu.addActionListener((e: ActionEvent) => {
    sys.exit(0)
  })

  aboutMenu.addActionListener((e: ActionEvent) => {
    val n = JOptionPane.showMessageDialog(null, "Project done by:\n" + " Lorenzo Pacini\n " +
      "Silvia Zandoli\n" + " Alberto Antonelli", "About", JOptionPane.DEFAULT_OPTION)
  })

  def initAndUpload(frame: JFrame, modality: String): Unit = {
    import grafic.Helpers._

    //use of implicit

    AuxFunctSPanel.firstTime = true

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