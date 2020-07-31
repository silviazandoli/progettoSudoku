package object grafic {
  import java.awt.{BorderLayout, Color, Dimension, FlowLayout}
  import javax.swing.{JButton, JPanel, JTextArea}
  import utility.dimSudoku

  val masks: Array[Array[Boolean]] = Array.ofDim[Boolean](dimSudoku, dimSudoku)

  def utentSolved(): Boolean = masks.flatten.forall(_ == true)

  private var rowPressed = -1
  private var colPressed = -1

  private var write = ""

  val NUMBER = "Insert numbers"
  val NUMBER_LIST = "Insert list of numbers"
  val SEE_MATLIST = "See matlist"

  val showNumberList = new JTextArea("") // bruttino

  def setWrite(writeString: String): Unit = {write = writeString}
  def getWrite: String = write

  def setPressed(row: Int, col: Int): Unit = {
    rowPressed = row
    colPressed = col
  }

  def getPressed: (Int, Int) = (rowPressed, colPressed)

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
      private val DisplayWidth = 557 //sudoku display its 557 pixels wide
      //SS.setText()
      //SS.addActionListener(this);
      showNumberList.setForeground(Color.BLUE)
      showNumberList.setBackground(Color.CYAN)
      showNumberList.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight))

      pb.add(showNumberList)

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
