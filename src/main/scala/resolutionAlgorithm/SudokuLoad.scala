package resolutionAlgorithm

import resolutionAlgorithm.SudokuMatrix.matList

import scala.annotation.tailrec
import scala.io.Source

object SudokuLoad {
  val dimSudoku = 9
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

  def display(puzzleGame: Array[Array[Int]]): Unit = {
    display("", puzzleGame)
  }

  def display(title: String, puzzleGame: Array[Array[Int]]): Unit = {
    def closureSudokuLine(l:Array[Int]): String = {
      l.map {
        case 0 => "_"
        case y => `y`.toString
      }.mkString(" ")
    }

    println(title)
    for {
      i <- 0 until dimSudoku
    } yield {
      computeOnList(print, closureSudokuLine(puzzleGame(i)).toList)
      println()
    }
    println()
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
