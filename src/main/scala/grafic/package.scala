import java.awt.Container

package object grafic {
  import javax.swing.JTextArea
  import utility.dimSudoku

  val masks: Array[Array[Boolean]] = Array.ofDim[Boolean](dimSudoku, dimSudoku)
  private var puzzleResolt: Array[Array[Int]] = Array.ofDim[Int](dimSudoku, dimSudoku)

  def utentSolved(): Boolean = masks.flatten.forall(_ == true)

  private var rowPressed = -1
  private var colPressed = -1

  private var write = ""

  val NUMBER = "Insert numbers"
  val NUMBER_LIST = "Insert list of numbers"
  val SEE_MATLIST = "See matlist"

  var cp: Container = _
  val showNumberList = new JTextArea("") // bruttino

  def setWrite(writeString: String): Unit = {write = writeString}
  def getWrite: String = write

  def setPuzzleResolt(puzzleResolt: Array[Array[Int]]): Unit = {this.puzzleResolt = puzzleResolt}
  def getPuzzleResolt(): Array[Array[Int]] = puzzleResolt

  def setPressed(row: Int, col: Int): Unit = {
    rowPressed = row
    colPressed = col
  }

  def getPressed: (Int, Int) = (rowPressed, colPressed)
}
