package sudoku

/**
 * Made by Pacini
 */
object SudokuLoad {
  import scala.annotation.tailrec
  import scala.io.Source

  import utility.{puzzle, computeOnList}

  def readFile(fileName: String): Array[String] = {
    val file = Source.fromFile(fileName)
    val it = file.getLines()
    Source.fromFile(fileName).close()
    it.toArray
  }

  def loadPuzzle(nameFile: String): Unit = {
    parsePuzzle(readFile(nameFile).toList, 0)
  }

  @tailrec
  def parsePuzzle(puzzleInput: List[String], row: Int): Unit = {
    puzzleInput match {
      case h :: t =>
        var col = 0

        def closurePuzzle(ch: Char): Unit = {
          puzzle(row)(col) = ch.asDigit
          col+=1
        }

        computeOnList(closurePuzzle, h.toList)
      ; parsePuzzle(t, row+1)
      case _ =>
    }
  }
}
