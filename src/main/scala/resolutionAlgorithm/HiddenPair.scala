package resolutionAlgorithm

import resolutionAlgorithm.SudokuMatrix.matList
import SudokuLoad.dimSudoku
import scala.annotation.tailrec

object HiddenPair {
  //A hidden pair occurs when a pair of numbers appears in exactly two squares in a row, column, or block,
  // but those two numbers aren't the only ones in their squares.you can get rid of the other candidates in those squares


  /*
  implementazione provvisoria di trovare coppie nel puzzle
   */
  @tailrec
  def findCouplePuzzle(row: Int, col: Int): Unit = {
    val listCouple = findCouple(row, col)

    if (listCouple != Nil) {
      listCouple(0)
      listCouple(1)
    }

    if (row < dimSudoku) findCouplePuzzle(row + 3, col)
  }

  /*
  data una cella cerca ogni possibile coppia nel suo sottoquadrato
   */
  def findCouple(row: Int, col: Int): List[(Int, Int)] = {
    val r = (row / 3) * 3
    val c = (col / 3) * 3

    val coupleFirst = (row, col)
    var coupleSecond = (row, col)

    for {
      i <- r until r + 3
      j <- c until c + 3
      if i != row && j != col
    } yield {
      if (matList(row)(col) == matList(i) (j)) {
        coupleSecond = (i, j)
        return List(coupleFirst, coupleSecond)
      }
    }
    Nil
  }

}
