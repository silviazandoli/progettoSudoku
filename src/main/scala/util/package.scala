import scala.annotation.tailrec

package object utility {

  val dimSudoku = 9
  val matList: Array[Array[List[Int]]] = Array.ofDim[List[Int]](dimSudoku, dimSudoku)
  var puzzle: Array[Array[Int]] = Array.ofDim[Int](dimSudoku, dimSudoku)

  def getPuzzle: Array[Array[Int]] = {
    val puzzleTemp: Array[Array[Int]] = Array.ofDim[Int](dimSudoku, dimSudoku)
    for {
      i <- 0 until dimSudoku
      j <- 0 until dimSudoku
    } yield {
      puzzleTemp(i)(j) = puzzle(i)(j)
    }
    puzzleTemp
  }

  @tailrec
  final def computeOnList[T](f: T => Unit, list: List[T]): Unit = list match {
    case h :: t => f(h); computeOnList(f, t)
    case _ =>
  }

  def printMatrix(): Unit = {
    for {
      i <- 1 until dimSudoku
      j <- 1 until dimSudoku
    } yield computeOnList(print, matList(i)(j))
  }
}
