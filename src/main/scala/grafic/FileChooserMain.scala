package grafic

import java.awt.Dimension
import java.awt.event.{ActionEvent, KeyEvent}
import java.io.File

import grafic.Sudoku.Sudoku
import javax.swing._
import javax.swing.filechooser.FileNameExtensionFilter
import resolutionAlgorithm.FullExploration
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle
import utility.getPuzzle

object FileChooserMain extends App {

  val mainFrame = new JFrame("Sudoku")

  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

  mainFrame.setPreferredSize(new Dimension(300, 200))
  val menuBar = new JMenuBar()


  val menu = new JMenu("File")
  val menu2= new JMenu("About")
  menu.setMnemonic(KeyEvent.VK_F)
  // menu.getAccessibleContext.setAccessibleDescription("The only menu in this program that has menu items")
  menuBar.add(menu,menu2)


  val openMenu = new JMenuItem("Open",
    KeyEvent.VK_O)
  openMenu.setAccelerator(KeyStroke.getKeyStroke(
    KeyEvent.VK_O, ActionEvent.ALT_MASK));

  val exitMenu = new JMenuItem("Exit", KeyEvent.VK_X)
  exitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK))


  menu.add(openMenu)
  menu.addSeparator()
  menu.add(exitMenu)
  mainFrame.setJMenuBar(menuBar)
  mainFrame.pack()
  mainFrame.setVisible(true)

  openMenu.addActionListener((e: ActionEvent) => {
    initAndReUpload(mainFrame)
  })
  exitMenu.addActionListener((e: ActionEvent) => {
    sys.exit(0)
  })


  def initAndReUpload(frame: JFrame): Unit = {
    import grafic.Helpers._
    //val jfc = new JFileChooser("input")
    //val jfc = new JFileChooser("input")
    //implicit
    val jfc = "input".filechooser()


    //val retValue = jfc.showOpenDialog(null)
    val retValue = jfc.open(frame)
    if (retValue == JFileChooser.APPROVE_OPTION) {
      val file = jfc.multipleFiles()
      //open one sudoku or multiple sudokus
      file.foreach(processFile)

    }
  }

  def processFile(f: File) = {
    println(f)
    loadPuzzle(f.toString)
    initList()

    val sudokuSolver = FullExploration(getPuzzle)
    sudokuSolver.solve(0, 0)

    setPuzzleResolt(sudokuSolver.returnPuzzle())

    val sudoku = Sudoku()
    sudoku.create()

  }

  //initAndReUpload()
}

//using of the pattern implicit
object Helpers {

  implicit class MyStringHelper(str: String) {
    def filechooser() = {
      val jfc = new JFileChooser(str)
      jfc.setMultiSelectionEnabled(true)

      jfc.setAcceptAllFileFilterUsed(false)
      val filter = new FileNameExtensionFilter("Files txt", "txt")
      jfc.addChoosableFileFilter(filter)
      jfc

    }
  }

  implicit class MyFileChooserHelper(jfc: JFileChooser) {
    def open(frame:JFrame) = jfc.showOpenDialog(frame)

    def multipleFiles() = jfc.getSelectedFiles()
  }

}