package resolutionAlgorithm

import utility.dimSudoku
/**
 * Made by Zandoli and Pacini
 *
 * the main resolution algorithm in brute force
 * */
sealed trait FullExploration {
  val puzzleGame: Array[Array[Int]]

  private val next: (Int, Int) => Boolean = (row: Int, col: Int) => col match {
    case 8 => solve(row + 1, 0)
    case _ => solve(row, col + 1)
  }

  /**
   * Made by Zandoli
   *
   *it checks that a number is present only once for each row, column and block
   * @param position row and column
   * @param value the number
   * @return if present
   */
  def validate(position: (Int, Int), value: Int): Boolean = {
    //for each row, column and block 3*3
    val v = puzzleGame.transpose
    val ci = position._1 / 3
    val cj = position._2 / 3
    val squareCells = puzzleGame.grouped(3).toList(ci).flatMap { x => x.grouped(3).toList(cj) }

    !puzzleGame(position._1).contains(value) && !v(position._2).contains(value) && !squareCells.contains(value)
  }

  // ---- //

  private def computationMatrix(row: Int, col: Int): Boolean = {
    puzzleGame(row)(col) match {
      case 0 =>
        (1 to dimSudoku).filter(i => validate((row, col), i))
          .foreach(elem => {
            puzzleGame(row)(col) = elem
            if (next(row,col)) {
              return true
            } else {
              puzzleGame(row)(col) = 0
            }
          })
        false
      case _ => next(row,col)
    }
  }

  /**
   * Made by Pacini
   *
   * it solves
   * @param row
   * @param col
   * @return true if is all solved
   */
  def solve(row: Int, col: Int): Boolean = {
    if (puzzleGame.flatten.forall(_.!=(0))) return true
    computationMatrix(row, col)
  }

  def returnPuzzle(): Array[Array[Int]] = puzzleGame
}

object FullExploration {
  def apply(puzzleGame: Array[Array[Int]]): FullExploration = FullExplorationImplements(puzzleGame)
  private case class FullExplorationImplements(override val puzzleGame: Array[Array[Int]]) extends FullExploration
}

