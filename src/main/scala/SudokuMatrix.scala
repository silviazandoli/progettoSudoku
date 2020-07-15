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

    // eliminazione numeri riga
    for {
      k <- 0 until dimSudoku
      if puzzle(row)(k) > 0
    } yield arrayNum(puzzle(row)(k)-1) = 0

    // eliminazione numeri colonna
    for {
      k <- 0 until dimSudoku
      if puzzle(k)(col) > 0
    } yield arrayNum(puzzle(k) (col)-1) = 0

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
}
