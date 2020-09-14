package grafic

import java.awt.Dimension
import java.awt.event.{ActionEvent, ActionListener, KeyEvent}

import grafic.FileChooser.{cont, initAndUpload}
import grafic.panels.funAux.SaveLoad.read
import javax.swing._

/*Made by Zandoli*/

/*It creates the initial interface when you can choose a file to start the game*/
object MyMenuHelpers {
  def createMenu(menu: JMenuItem*): JMenu = {
    val menuItem = new JMenu("File")
    menu.foreach(menuItem.add(_))
    menuItem
  }

  // Use of an implicit conversion to shorten the code
  implicit def functionActionListener(f: ActionEvent => Unit) =
    new ActionListener {
      def actionPerformed(event: ActionEvent) = f(event)
    }
}
//the main interface
object FileChooserMain {
  val mainFrame = new JFrame("Sudoku")
  var load = false

  def createMainGraphic() = {
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

    openEasy.addActionListener((_: ActionEvent) => (load = false, initAndUpload(mainFrame, "input/easy"), cont()))
    openMedium.addActionListener((_: ActionEvent) => (load = false, initAndUpload(mainFrame, "input/medium"), cont()))
    openHard.addActionListener((_: ActionEvent) => (load = false, initAndUpload(mainFrame, "input/hard"), cont()))
    loadFile.addActionListener((_: ActionEvent) => (load = true, read(), initAndUpload(mainFrame, "temp"),cont()))
    val text = "made by Pacini, Zandoli, Antonelli"
    aboutMenu.addActionListener((_: ActionEvent) => JOptionPane.showMessageDialog(mainFrame, s"Sudoku ${text}"))
    exitMenu.addActionListener((_: ActionEvent) => sys.exit(0))

    mainFrame.pack()
    mainFrame.setVisible(true)
  }
}