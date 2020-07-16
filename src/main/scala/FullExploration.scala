object FullExploration {
  import SudokuLoad.{puzzle,dimSudoku, display}

  def main(args: Array[String]): Unit = {
    solve(0, 0)
    display()
  }

  def validate(row: Int, col: Int, num: Int): Boolean = {
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
  }

  def puzzleSolved(): Boolean = {
    for (i <- 0 until dimSudoku) {
      for (j <- 0 until dimSudoku) {
        if (puzzle(i)(j) == 0) {
          return false
        }
      }
    }

    true
  }

  def next(row: Int, col: Int): Boolean = {
    if (col >= 8) {
      solve(row + 1, 0)
    } else {
      solve(row, col + 1)
    }
  }

  def solve(row: Int, col: Int): Boolean = {
    if (puzzleSolved()) {
      return true
    } else if (puzzle(row)(col) > 0) {
      return next(row, col)
    } else {
      for (i <- 1 to dimSudoku) {
        if (validate(row, col, i)) {
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