/**
 * Made by Pacini
 */
package object grafic {
  import java.awt.Container
  import javax.swing.JTextArea
  import utility.dimSudoku
  import grafic.panels.TextOpNumber.TextOpNumber

  val masks: Array[Array[Boolean]] = Array.ofDim[Boolean](dimSudoku, dimSudoku)
  private var puzzleResolt: Array[Array[Int]] = Array.ofDim[Int](dimSudoku, dimSudoku)

  private var rowPressed = -1
  private var colPressed = -1
  private var write = ""

  var cp: Container = _
  val showNumberList = new JTextArea()
  val textTime = new JTextArea()

  val tfCells: Array[Array[TextOpNumber]] = Array.ofDim[TextOpNumber](dimSudoku, dimSudoku)

  /**
   * @return true if in each cell is present the correct number, false otherwise
   */
  def utentSolved(): Boolean = masks.flatten.forall(_ == true)

  /**
   * @tparam T generic parameter of work
   */
  trait setGet[T] {
    def set(elem: T)
    def get: T
  }

  /**
   * function to set an element (very useful)
   * @param elem to set
   * @tparam T the type
   */
  def graficSet [T: setGet](elem : T): Unit = {implicitly[setGet[T]].set(elem)}

  /**
   * @tparam T the type
   * @return the type previously set
   */
  def graficGet [T: setGet] : T = {implicitly[setGet[T]].get}

  /**
   * implicit object to use the same function for different type element
   */
  object setGet {
    implicit object stringSetGet extends setGet[String] {
      override def set(str: String): Unit = {write = str}
      override def get: String = write
    }

    implicit object puzzleSetGet extends setGet[Array[Array[Int]]] {
      override def set(setPuzzleResolt: Array[Array[Int]]): Unit = {puzzleResolt = setPuzzleResolt}
      override def get: Array[Array[Int]] = puzzleResolt
    }

    implicit object pressedSetGet extends setGet[(Int, Int)] {
      override def set(rowCol: (Int, Int)): Unit = {rowPressed = rowCol._1; colPressed = rowCol._2}
      override def get: (Int, Int) = (rowPressed, colPressed)
    }
  }
}
