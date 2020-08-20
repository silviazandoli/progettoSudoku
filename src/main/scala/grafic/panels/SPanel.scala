package grafic.panels

object SPanel {
  import java.awt.{BorderLayout, Color, Dimension, FlowLayout}
  import java.awt.event.ActionEvent
  import javax.swing.{JButton, JPanel, JTextField}

  import grafic.{showNumberList, AssociateListener}
  import grafic.util.FONT_MATLIST

  def apply(dimension: Dimension): SPanel = SPanel(dimension)

  trait SPanelTrait extends JPanel //construct the sudoku display panel
  {
    val pb = new JPanel() //create the button panel
    val FL = new FlowLayout()
    //it shows the lists for every square

    //you have the possibility to write the number in the square
    val CS = new JButton(" Undo")

    val startStopButton = new JButton(" StartStop ")

    val ES = new JButton(" Easy ")
    val MS = new JButton(" Medium ")
    val HS = new JButton(" Hard ")

    val WS = new Color(0xf5, 0xf5, 0xf5) //White Smoke

    val dim: Dimension //

    private val ButtonsHeight = 20 //sudoku display its 580 pixels high
    private val ButtonsWidth = 100 //button panel its 200 pixels wide

    this.setLayout(new BorderLayout())

    pb.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight)); // dim
    pb.setBackground(WS)

    FL.setVgap(55)
    FL.setHgap(100); //set the flow layout to give  symmetric display
    pb.setLayout(FL)

    showNumberList.setForeground(Color.WHITE)
    showNumberList.setBackground(Color.BLUE)
    showNumberList.setFont(FONT_MATLIST)
    showNumberList.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight))

    pb.add(showNumberList)

    startStopButton.addActionListener((_: ActionEvent) => {
      AssociateListener.createMatrix()
      startGame()
    })

    pb.add(startStopButton)

    pb.add(ES)

    pb.add(MS)

    pb.add(HS)

    pb.add(CS)

    val textTime = new JTextField()
    textTime.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight))
    pb.add(textTime)

    this.add(pb)
    this.setPreferredSize(dim)

    def startGame(): Unit = {
      val thread = new Thread {
        override def run() {
          while(true) textTime.setText("" + System.currentTimeMillis())
        }
      }
      thread.start()
    }
  }

  case class SPanel(dim: Dimension) extends SPanelTrait
}