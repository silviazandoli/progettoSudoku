package grafic.panels

/**
 * Made by Pacini (function refresh made by Antonelli)
 */
object SPanel {
  import java.awt.event.ActionEvent
  import java.awt.{BorderLayout, Dimension, EventQueue}
  import javax.swing.JPanel

  import grafic.tfCells
  import utility.dimSudoku

  import grafic.panels.funAux.MakePanelGrafic._

  def apply(dimension: Dimension): SPanel = SPanel(dimension)

  //construct the sudoku display panel
  trait SPanelTrait extends JPanel {
    val dim: Dimension //

    this.setLayout(new BorderLayout())
    setDimension()
    showNumberListMake()
    startStopButtonMake()

    refreshList.addActionListener((_: ActionEvent) =>
        for (i <- 0 until dimSudoku; j <- 0 until dimSudoku; if tfCells(i)(j).getList.nonEmpty) {
            val t = new Thread(() => synchronized {tfCells(i)(j).displayList()})
            println("riga " + i + " colonna " + j + " controllata")
            try
              if (EventQueue.isDispatchThread) t.start()
              else EventQueue.invokeAndWait(() => t.run())
            catch {case e: Exception => println(e)}
        })

    addButtons()

    this.add(pb)
    this.setPreferredSize(dim)
  }

  case class SPanel(dim: Dimension) extends SPanelTrait
}