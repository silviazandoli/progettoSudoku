import scala.io.Source

object NakedPairs  {
  val unit = 3
  import Sudoku.{puzzle,dimSudoku}

  def main(args: Array[String]): Unit = {
    println("start sudoku naked")
    //loadPuzzle(nameFile, 0)
    display()

    solve(0, 0)
    display()
  }
  def loadPuzzle(nameFile: String, numRiga: Int): Unit = {
    parsePuzzle(readFile(nameFile).toList, numRiga)
  }

  def readFile(fileName: String): Array[String] = {
    val file = Source.fromFile(fileName)
    val it = file.getLines()
    Source.fromFile(fileName).close()
    it.toArray
  }

  def parsePuzzle(puzzleInput: List[String], row: Int): Unit = {
    puzzleInput match {
      case h :: t => ( {
        var col = 0
        h.foreach(ch => {
          puzzle(row)(col) = ch.asDigit
          col += 1
        })
      }, parsePuzzle(t, row + 1))
      case _ =>
    }
  }

  def display(): Unit = {
    for (i <- puzzle.indices) {
      print(util.formatSudokuLine(puzzle(i)))
      println()
    }
    println()
  }

  object util {
    def formatSudokuLine(l: Array[Int]): String =
      l.map(y => if (y == 0) "_" else y.toString).mkString(" ")
  }

  def solve(row: Int, col: Int): Boolean = {
    if (puzzleSolved()) {
      return true
    } else {
      for (i <- 0 until dimSudoku) {
        for (j <- 0 until dimSudoku) {
          if (matList(i)(j).size <= 3) {
            /*lista size*/
              var number = new Array[Int](dimSudoku)
            for (k <- 0 until unit) {
              for (z <- 0 until unit) {
                if (puzzle(k)(z) == matList(i)(j)) {

                }
              }
            }
          }
        }

      }
      false
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
  }
}
