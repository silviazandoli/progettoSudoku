import SudokuMatrix.matList

import scala.annotation.tailrec
import scala.io.Source

object SudokuLoad {
  val dimSudoku = 9
  val puzzle: Array[Array[Int]] = Array.ofDim[Int](dimSudoku, dimSudoku)
  val nameFile = "input/sudoku05.txt"

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
      case h :: t => ({
        var col = 0
        h.foreach(ch => {
          puzzle(row)(col) = ch.asDigit
          if (puzzle(row)(col) > 0) elemEmpty-=1
          col+=1
        })
      ; parsePuzzle(t, row+1)})
      case _ =>
    }
  }

  object util {
    def formatSudokuLine(l:Array[Int]): String =
      l.map(y => if (y == 0) "_" else y.toString).mkString(" ")
  }
  def display(): Unit = {
    display("")
  }

  def display(title: String): Unit = {
    println(title + " " + elemEmpty)
    for {
      i <- puzzle.indices
    } yield {
      print(util.formatSudokuLine(puzzle(i)))
      println()
    }
    println()
  }

  @tailrec
  final def printList[T](f: T => Unit, list: List[T]): Unit = list match {
    case h :: t => f(h); printList(f, t)
    case _ =>
  }

  def displayList(row: Int, col: Int): Unit = {
    print("[" + row + " " + col + "]  ")
    printList(print, matList(row)(col))
  }
}
