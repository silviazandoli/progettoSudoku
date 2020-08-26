package grafic.panels

object SPanel {
  import java.awt.{BorderLayout, Dimension, Color}
  import java.awt.event.ActionEvent
  import javax.swing.JPanel

  import grafic.util.{AssociateListener, FONT_MATLIST}
  import grafic.{textTime, showNumberList}
  import AuxFunctSPanel.startGame

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
    startStopButton.addActionListener((_: ActionEvent) => {
      if (startStopButton.getBackground == Color.green) {
        AssociateListener.associateListener()
        startGame()
        startStopButton.setBackground(Color.red)
      } else {
        try {
          if (thread != null) {
            thread.interrupt()
            thread = null
          }
        } catch {
          case eI : InterruptedException => println("Exception = " + eI.getMessage)
        }
      }
    })

    pb.add(startStopButton)
    pb.add(ES)
    pb.add(MS)
    pb.add(HS)
    pb.add(CS)

    textTime.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight*2)); // dim
    pb.add(textTime)

    this.add(pb)
    this.setPreferredSize(dim)
  }

  case class SPanel(dim: Dimension) extends SPanelTrait
}