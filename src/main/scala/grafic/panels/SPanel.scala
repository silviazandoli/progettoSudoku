package grafic.panels

object SPanel {
  import java.awt.event.ActionEvent
  import java.awt.{BorderLayout, Color, Dimension, EventQueue}

  import grafic.panels.funAux.SaveLoad
  import grafic.util.FONT_MATLIST
  import grafic.{showNumberList, textTime, tfCells}
  import javax.swing.JPanel
  import utility.dimSudoku

  def apply(dimension: Dimension): SPanel = SPanel(dimension)

  //construct the sudoku display panel
  trait SPanelTrait extends JPanel {
    val dim: Dimension //

    this.setLayout(new BorderLayout())

    pb.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight)); // dim
    pb.setBackground(WS)

    FL.setVgap(55)
    FL.setHgap(100) //set the flow layout to give  symmetric display
    pb.setLayout(FL)

    showNumberList.setForeground(Color.WHITE)
    showNumberList.setBackground(Color.BLUE)
    showNumberList.setFont(FONT_MATLIST)
    showNumberList.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight))

    pb.add(showNumberList)

    startStopButton.setBackground(Color.green)
    startStopButton.addActionListener((_: ActionEvent) => AuxFunctSPanel.startStop())

    pb.add(startStopButton)

    refreshList.addActionListener((_: ActionEvent) =>
        for (i <- 0 until dimSudoku; j <- 0 until dimSudoku
             if tfCells(i)(j).getList.nonEmpty) {
          System.out.println("riga "+i + " colonna "+j+ " controllata")
          val t = new Thread(() => tfCells(i)(j).displayList())
          //SwingUtilities.invokeAndWait(() => t.run())
          try if (EventQueue.isDispatchThread) t.run()
          else EventQueue.invokeAndWait(t)
          catch {
            case e: Exception =>
              System.out.println(e)
          }
        })

    pb.add(refreshList)

    textTime.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight*2)); // dim
    pb.add(textTime)

    saveButton.addActionListener((_: ActionEvent) => SaveLoad.save())
    pb.add(saveButton)



    this.add(pb)
    this.setPreferredSize(dim)
  }

  case class SPanel(dim: Dimension) extends SPanelTrait
}