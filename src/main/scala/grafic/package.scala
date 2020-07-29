import utility.dimSudoku

package object grafic {

  import java.awt.{BorderLayout, Color, Dimension, FlowLayout}
  import javax.swing.{JButton, JPanel}

  val masks: Array[Array[Boolean]] = Array.ofDim[Boolean](dimSudoku, dimSudoku)

  def utentSolved(): Boolean = masks.flatten.forall(_ == true)

  def printMask(): Unit = {
    println("==== printMask ==== ")
    (0 until dimSudoku).foreach(i => { (0 until dimSudoku).foreach(j => {
      print(masks(i)(j) + " ")
    })
    println(" ==== ")
  })}

  object SPanel {
    def apply(dimension: Dimension): SPanel = SPanel(dimension)

    trait SPanelTrait extends JPanel //construct the sudoku display panel
    {
      val pb = new JPanel() //create the button panel
      val FL = new FlowLayout()
      //it shows the lists for every square
      val SS = new JButton("show lists")
      //you have the possibility to write the number in the square
      val CS = new JButton(" Undo")
      val GBS = new JButton(" Only numbers ")

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
      private val DisplayWidth = 557 //sudoku display its 557 pixels wide
      //SS.setText()
      //SS.addActionListener(this);
      SS.setForeground(Color.BLUE)
      SS.setBackground(Color.CYAN)
      SS.addActionListener(l => {
        // println("Hello!!")
        // val combo=new J
      })

      pb.add(SS)

      //GBS.addActionListener(this);
      pb.add(GBS)

      // ES.addActionListener(this);
      pb.add(ES)

      //  MS.addActionListener(this);
      pb.add(MS)

      private val MB = new Color(0x00, 0x00, 0xcd) //Medium blue

      // HS.addActionListener(this);
      pb.add(HS)
      private val P = new Color(0x80, 0, 0x80) //purple blank number
      //CS.addActionListener(this);
      pb.add(CS)
      // FL.add(pb, BorderLayout.WEST);

      //add the push button panel to the display panel
      this.add(pb)
      this.setPreferredSize(dim)
    }

    case class SPanel(dim: Dimension) extends SPanelTrait
  }
}
