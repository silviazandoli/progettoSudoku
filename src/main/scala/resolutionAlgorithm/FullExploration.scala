package resolutionAlgorithm

import utility.{dimSudoku, puzzle, puzzleSolved}

object FullExploration {

 def validate(position:(Int,Int),value:Int): Boolean = {
   //for each row, column and block 3*3
   val v=puzzle.transpose
   val ci = position._1 / 3
   val cj = position._2 / 3
   val squareCells = puzzle.grouped(3).toList(ci).flatMap { x => x.grouped(3).toList(cj) }

   !puzzle(position._1).contains(value) && !v(position._2).contains(value) && !squareCells.contains(value)
 }

  def next(row: Int, col: Int): Boolean = col match {
    case 8 => solve(row + 1, 0)
    case _ => solve(row, col + 1)
  }

  def solve(row: Int, col: Int): Boolean = {
    if (puzzleSolved()) return true
    puzzle(row)(col) match {
      case 0 =>
        for {
          i <- 1 to dimSudoku
          if validate((row, col), i)
        } {
          puzzle(row)(col) = i
          if (next(row, col)) {
            return true
          }
          puzzle(row)(col) = 0
        }
        false
      case _ => next(row, col)
    }
  }
}
