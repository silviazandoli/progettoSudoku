import scala.annotation.tailrec

class SudokuMatrix {
  val dimSudoku = 9
  val puzzle: Array[Array[Int]] = Array.ofDim[Int](dimSudoku, dimSudoku)

  val matList: Array[Array[List[Int]]] = Array.ofDim[List[Int]](dimSudoku, dimSudoku)

  val nameFile = "input/sudoku11.txt"

  def initList() = {
    for (i <- 0 until dimSudoku) {
      for (j <- 0 until dimSudoku) {
        matList(i)(j) = createList(i, j)
      }
    }
  }

  def createList(row: Int, col: Int): List[Int] = {
    if (puzzle(row) (col) > 0) {
      return Nil
    }

    val arrayNum = Array.ofDim[Int](dimSudoku+1)

    // inizializzazione vettore 1 ... n
    for (k <- 1 until dimSudoku) {
      arrayNum(k) = k
    }

    // eliminazione numeri riga
    for (k <- 0 until dimSudoku) {
      if (puzzle(row) (k) > 0) {
        arrayNum(puzzle(row) (k)) = 0
      }
    }

    // eliminazione numeri colonna
    for (k <- 0 until dimSudoku) {
      if (puzzle(k) (col) > 0) {
        arrayNum(puzzle(k) (col)) = 0
      }
    }

    // eliminazione numeri quadrato
    val r = (row / 3) * 3
    val c = (col / 3) * 3
    for (i <- r until r + 3) {
      for (j <- c until c + 3) {
        if (puzzle(i) (j) > 0) {
          arrayNum(puzzle(i) (j)) = 0
        }
      }
    }

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

}
