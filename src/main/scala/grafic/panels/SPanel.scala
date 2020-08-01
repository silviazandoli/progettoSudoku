package grafic.panels

import java.awt.{BorderLayout, Color, Dimension, FlowLayout}

import grafic.showNumberList
import javax.swing.{JButton, JPanel}

object SPanel {
  def apply(dimension: Dimension): SPanel = SPanel(dimension)

  trait SPanelTrait extends JPanel //construct the sudoku display panel
  {
    val pb = new JPanel() //create the button panel
    val FL = new FlowLayout()
    //it shows the lists for every square

    //you have the possibility to write the number in the square
    val CS = new JButton(" Undo")

    val ES = new JButton(" Easy ")
    val MS = new JButton(" Medium ")
    val HS = new JButton(" Hard ")

    val WS = new Color(0xf5, 0xf5, 0xf5) //White Smoke

    val dim: Dimension //

    private val ButtonsHeight = 80 //sudoku display its 580 pixels high
    private val ButtonsWidth = 80 //button panel its 200 pixels wide

    this.setLayout(new BorderLayout())

    pb.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight)); // dim
    pb.setBackground(WS)

    FL.setVgap(55)
    FL.setHgap(100); //set the flow layout to give  symmetric display
    pb.setLayout(FL)

    showNumberList.setForeground(Color.BLACK)
    showNumberList.setBackground(Color.WHITE)
    showNumberList.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight))

    pb.add(showNumberList)

    pb.add(ES)

    pb.add(MS)

    pb.add(HS)

    //CS.addActionListener(this);
    pb.add(CS)

    this.add(pb)
    this.setPreferredSize(dim)
  }

  case class SPanel(dim: Dimension) extends SPanelTrait
}