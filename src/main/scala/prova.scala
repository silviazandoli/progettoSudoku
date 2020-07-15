object prova extends App {

  val dimSudoku = 9
  val matList: Array[Array[List[Int]]] = Array.ofDim[List[Int]](dimSudoku, dimSudoku)

  val puzzle: Array[Array[Int]] = Array.ofDim[Int](dimSudoku, dimSudoku)

  val arrayNum = Array.ofDim[Int](dimSudoku+1)

  def initPuzzle() = {
    for {
      i <- 0 until dimSudoku
      j <- 0 until dimSudoku
    } yield puzzle(i)(j) = i

    for {
      k <- 1 until dimSudoku
    } yield arrayNum(k) = k

    /*
    for (k <- 1 until dimSudoku) {
      arrayNum(k) = k
    }
     */
  }

  def azerPuzzle(row: Int, col: Int) = {
    for {
      k <- 0 until dimSudoku
      if puzzle(row)(k) > 0
    } yield arrayNum(puzzle(row)(k)) = 0

    for {
      k <- 0 until dimSudoku
      if puzzle(k)(col) > 0
    } yield arrayNum(puzzle(k) (col)) = 0

    // yield arrayNum(puzzle(k) (col)) = 0
    //arrayNum(puzzle(k) (col)) = 0
  }

  initPuzzle()
  azerPuzzle(5, 6)

  println(arrayNum.toList)
}
