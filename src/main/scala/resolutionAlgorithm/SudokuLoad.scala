package resolutionAlgorithm

import resolutionAlgorithm.SudokuMatrix.matList

import scala.annotation.tailrec
import scala.io.Source

object SudokuLoad {
  val dimSudoku = 9
  val puzzle: Array[Array[Int]] = Array.ofDim[Int](dimSudoku, dimSudoku)
  var elemEmpty: Int = dimSudoku * dimSudoku

  def readFile(fileName: String): Array[String] = {
    val file = Source.fromFile(fileName)
    val it = file.getLines()
    Source.fromFile(fileName).close()
    it.toArray
  }

  def loadPuzzle(nameFile: String, numRiga: Int): Unit = {
    parsePuzzle(readFile(nameFile).toList, numRiga)
  }

  @tailrec
  def parsePuzzle(puzzleInput: List[String], row: Int): Unit = {
    puzzleInput match {
      case h :: t =>
        var col = 0
        def closurePuzzle(ch: Char): Unit = {
          if (puzzle(row)(col) > 0) elemEmpty-=1
          puzzle(row)(col) = ch.asDigit
          col+=1
        }

        computeOnList(closurePuzzle, h.toList)
      ; parsePuzzle(t, row+1)
      case _ =>
    }
  }

  def display(): Unit = {
    display("")
  }

  def display(title: String): Array[Array[Int]] = {
    def closureSudokuLine(l:Array[Int]): String = {
      l.map {
        case 0 => "_"
        case y => `y`.toString
      }.mkString(" ")
    }

    println(title)
    for {
      i <- puzzle.indices
    } yield {
      computeOnList(print, closureSudokuLine(puzzle(i)).toList)
      println()
    }
    println()

    puzzle
  }

  @tailrec
  final def computeOnList[T](f: T => Unit, list: List[T]): Unit = list match {
    case h :: t => f(h); computeOnList(f, t)
    case _ =>
  }

  def displayList(row: Int, col: Int): Unit = {
    print("[" + row + " " + col + "]  ")
    computeOnList(print, matList(row)(col))
  }
}
