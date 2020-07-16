import scala.annotation.tailrec

object SudokuMatrix {
  import Sudoku.{puzzle,dimSudoku}

  val matList: Array[Array[List[Int]]] = Array.ofDim[List[Int]](dimSudoku, dimSudoku)

  def initList(): Seq[Unit] = {
    for {
      i <- 0 until dimSudoku
      j <- 0 until dimSudoku
    } yield matList(i)(j) = createList(i, j)
  }

  def createList(row: Int, col: Int): List[Int] = {
    if (puzzle(row) (col) > 0) {
      return Nil
    }

    val arrayNum = Array.ofDim[Int](dimSudoku)

    // inizializzazione vettore 1 ... n
    for {
      k <- 0 until dimSudoku
    } yield arrayNum(k) = k + 1

    // eliminazione numeri riga & colonna
    for {
      k <- 0 until dimSudoku
    } yield {
      if (puzzle(row)(k) > 0) arrayNum(puzzle(row)(k)-1) = 0
      if (puzzle(k)(col) > 0) arrayNum(puzzle(k)(col)-1) = 0
    }

    // eliminazione numeri quadrato
    val r = (row / 3) * 3
    val c = (col / 3) * 3

    for {
      i <- r until r + 3
      j <- c until c + 3
      if puzzle(i) (j) > 0
    } yield arrayNum(puzzle(i) (j)-1) = 0

    if (row == 0 && col != 10) println(arrayNum.toList)

    arrayNum.filter(elem => elem > 0).toList
  }
  
  final def printList[T](f: T => Unit, list: List[T]): Unit = list match {
    case h :: t => (f(h), printList(f, t))
    case _ =>
  }

  def printMatrix(): Unit = {
    for {
      i <- 1 until dimSudoku
      j <- 1 until dimSudoku
    } yield printList(print, matList(i)(j))
  }

  /*
  strategia di gioco
   */
  def strategyList() = {
    var elem = 0
    do {
      val rowCol = minList()
      elem = setUnitList(rowCol)

      println("elem = " + elem)

      if (elem != 0) updateList(rowCol, elem) // assegna valore lista unitaria
    } while (elem != 0)
  }

  def minList(): (Int, Int) = {
    var ijMin = (0, 0)
    var minLength = dimSudoku + 1

    for {
      i <- 0 until dimSudoku
      j <- 0 until dimSudoku
      if (matList(i)(j).length > 0 && matList(i)(j).length < minLength)
    } {
      minLength = matList(i)(j).length
      ijMin = (i, j)
    }

    ijMin
  }

  def setUnitList(rowCol: (Int, Int)): Int = {
    if (matList(rowCol._1)(rowCol._2).length == 1) {
      val elem = matList(rowCol._1)(rowCol._2).head

      puzzle(rowCol._1)(rowCol._2) = elem
      matList(rowCol._1)(rowCol._2) = Nil

      return elem
    }
    0
  }

  def updateList(rowCol: (Int, Int), elem: Int): Unit = {

    val row = rowCol._1
    val col = rowCol._2

    /*
    aggiornamento per riga e per colonna
     */
    for {
      i <- 0 until dimSudoku
    } yield {
      if (i != col) matList(row)(i) = matList(row)(i).filter(e => e != elem)
      if (i != row) matList(i)(col) = matList(i)(col).filter(e => e != elem)
    }

    val r = (row / 3) * 3
    val c = (col / 3) * 3

    /*
    aggiornamento sotto - quadrato
     */
    for {
      i <- r until r + 3
      j <- c until c + 3
    } yield {
      if (i != row && j != col) matList(i)(j) = matList(i)(j).filter(e => e != elem)
    }
  }
}
