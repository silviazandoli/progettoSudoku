import java.awt.Container

import javax.swing.JTextField

package object grafic {
  import javax.swing.JTextArea
  import utility.dimSudoku

  val masks: Array[Array[Boolean]] = Array.ofDim[Boolean](dimSudoku, dimSudoku)
  private var puzzleResolt: Array[Array[Int]] = Array.ofDim[Int](dimSudoku, dimSudoku)
  var tfCells: Array[Array[JTextField]] = Array.ofDim[JTextField](dimSudoku, dimSudoku)

  def utentSolved(): Boolean = masks.flatten.forall(_ == true)

  private var rowPressed = -1
  private var colPressed = -1

  private var write = ""

  var cp: Container = _
  val showNumberList = new JTextArea("") // bruttino

  def setWrite(writeString: String): Unit = {write = writeString}
  def getWrite: String = write

  def setPuzzleResolt(puzzleResolt: Array[Array[Int]]): Unit = {this.puzzleResolt = puzzleResolt}
  def getPuzzleResolt: Array[Array[Int]] = puzzleResolt

  def setPressed(row: Int, col: Int): Unit = {
    rowPressed = row
    colPressed = col
  }

  def getPressed: (Int, Int) = (rowPressed, colPressed)
}
