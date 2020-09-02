package grafic.panels

object SPanel {
  import java.awt.event.ActionEvent
  import java.awt.{BorderLayout, Color, Dimension, EventQueue}
  import javax.swing.JPanel

  import grafic.panels.funAux.SaveLoad
  import grafic.util.FONT_MATLIST
  import grafic.{showNumberList, textTime, tfCells}
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
      synchronized {
        for (i <- 0 until dimSudoku) {
          for (j <- 0 until dimSudoku) {
            if (tfCells(i)(j).getList.nonEmpty) {
              val t = new Thread(() => tfCells(i)(j).displayList())
              System.out.println("riga " + i + " colonna " + j + " controllata")
              try
                if (EventQueue.isDispatchThread) t.start()
                else EventQueue.invokeAndWait(() => t.run())
              catch {case e: Exception => println(e)}
            }
          }
        }
        })


    pb.add(refreshList)
    textTime.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight*2)); // dim
    pb.add(textTime)
    saveButton.addActionListener((_: ActionEvent) => SaveLoad.save())
    pb.add(saveButton)

    adviceButton.addActionListener((_: ActionEvent) => Advice.suggerisci())
    pb.add(adviceButton)

    this.add(pb)
    this.setPreferredSize(dim)
  }

  case class SPanel(dim: Dimension) extends SPanelTrait
}