

object FullExploration {
  import SudokuLoad.{puzzle,dimSudoku}

 /* def validate(row: Int, col: Int, num: Int): Boolean = {
    for (i <- 0 until dimSudoku) {

      if (puzzle(row)(i) == num || puzzle(i)(col) == num) {
        return false
      }
    }

    val r = (row / 3) * 3
    val c = (col / 3) * 3
    for (i <- r until r + 3) {
      for (j <- c until c + 3) {
        if (puzzle(i)(j) == num) {
          return false
        }
      }
    }
    true
  }*/
 def validate(position:(Int,Int),value:Int): Boolean = {
   //for each row, column and block 3*3
   val v=puzzle.transpose
   val ci = position._1 / 3
   val cj = position._2 / 3
   val squareCells = puzzle.grouped(3).toList(ci).flatMap { x => x.grouped(3).toList(cj) }

   !puzzle(position._1).contains(value) && !v(position._2).contains(value) && !squareCells.contains(value)

 }

  def puzzleSolved(): Boolean = puzzle.flatten.forall(_.!=(0))

  def next(row: Int, col: Int): Boolean = {
    if (col >= 8) {
      solve(row + 1, 0)
    } else {
      solve(row, col + 1)
    }
  }

  def solve(row: Int, col: Int): Boolean = {
    if (puzzleSolved()) return true
    else if (puzzle(row)(col) > 0) {
      return next(row, col)
    } else {
      for (i <- 1 to dimSudoku) {
        if (validate((row, col), i)) {
          puzzle(row)(col) = i

          if (next(row, col)) {
            return true
          }

          puzzle(row)(col) = 0
        }
      }
    }
    false
  }
}