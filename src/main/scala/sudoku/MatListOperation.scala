package sudoku

/**
 * Made by Zandoli and Pacini
 *
 * an object for developing the operations on the matList (which contains the possible numbers for every square)
 *
 * */

object MatListOperation {
  import utility.{dimSudoku, matList, puzzle}

  /***
   * initialization of the matList
   */
  def initList(): Unit = {
    (0 until dimSudoku).foreach(i => {
      val rowExcl = puzzle(i).toList.filter(_ != 0).toSet
      for (j<-0 until dimSudoku)
        puzzle(i)(j) match {
          case 0 => matList(i)(j) = possible(rowExcl, i, j)
          case _ => matList(i)(j) = Nil
        }
    })
  }

  // ==================== //

  /**
   * Made by Zandoli
   *
   * For every square it determines the possible values
   * @param rowExcl values exclused in row
   * @param row the row
   * @param col the column
   * @return the possible values
   */
  def possible(rowExcl: Set[Int], row:Int,col:Int):List[Int] = {
    //exclusion for column
    val colExcl = puzzle.toList.map(_ (col)).filter(_ != 0).toSet

    //exclusion for block 3*3
    val ci = row / 3
    val cj = col / 3

    val block = puzzle.grouped(3).toList(ci).flatMap { x => x.grouped(3).toList(cj) }.filter(_ != 0).toList.toSet

    //make the union for row, block and column
    val unity = rowExcl.union(colExcl).union(block)

    //make a set for difference, in possible i put all number that aren't in the union
    (1 to dimSudoku).toSet.diff(unity).toList
  }

  // ==================== //

  /**
   * Made by Lorenzo Pacini
   */
  def minList(): (Int, Int) = {
    var ijMin = (0, 0)
    var minLength = dimSudoku + 1

    for {i <- 0 until dimSudoku; j <- 0 until dimSudoku
         if matList(i)(j) != Nil && matList(i)(j).length < minLength
    } yield {
      minLength = matList(i)(j).length
      ijMin = (i, j)
    }

    ijMin
  }

  /**
   * Made by Lorenzo Pacini
   */
  def setUnitList(rowCol: (Int, Int)): Int = matList(rowCol._1)(rowCol._2).length match {
    case 1 =>
      val elem = matList(rowCol._1)(rowCol._2).head
      puzzle(rowCol._1)(rowCol._2) = elem
      matList(rowCol._1)(rowCol._2) = Nil
      elem

    case _ => 0
  }

  /**
   * Made by Lorenzo Pacini
   */
  def updateList(rowCol: (Int, Int), elem: Int): Unit = {
    val row = rowCol._1
    val col = rowCol._2

    /*
    update for row and column
     */
    for (i <- 0 until dimSudoku) yield {
      if (i != col && matList(row)(i) != null) matList(row)(i) = matList(row)(i).filter(e => e != elem)
      if (i != row && matList(i)(col) != null) matList(i)(col) = matList(i)(col).filter(e => e != elem)
    }

    /*
    update for block
     */
    val r = (row / 3) * 3
    val c = (col / 3) * 3

    for {i <- r until r + 3; j <- c until c + 3; if i != row && j != col && matList(i)(j) != Nil}
      yield {matList(i)(j) = matList(i)(j).filter(e => e != elem)}
  }
}
