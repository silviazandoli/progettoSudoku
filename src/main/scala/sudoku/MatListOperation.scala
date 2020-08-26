package sudoku

object MatListOperation {
  import utility.{dimSudoku, matList, puzzle}

  /**
   * fatto da Lorenzo Pacini
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
   *
   done by Silvia Zandoli
   */
  def possible(rowExcl: Set[Int], row:Int,col:Int):List[Int] = {
    //escludo per colonna
    val colExcl = puzzle.toList.map(_ (col)).filter(_ != 0).toSet

    //escludo per blocco 3*3
    val ci = row / 3
    val cj = col / 3

    val block = puzzle.grouped(3).toList(ci).flatMap { x => x.grouped(3).toList(cj) }.filter(_ != 0).toList.toSet

    //faccio l'unione per riga, per blocco e colonna
    val unity = rowExcl.union(colExcl).union(block)

    //faccio un set differenza, in possible ci metti tutti i numeri che non sono nell'unione
    (1 to dimSudoku).toSet.diff(unity).toList
  }

  // ==================== //

  /**
   * fatto da Lorenzo Pacini
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

  def setUnitList(rowCol: (Int, Int)): Int = matList(rowCol._1)(rowCol._2).length match {
    case 1 =>
      val elem = matList(rowCol._1)(rowCol._2).head
      puzzle(rowCol._1)(rowCol._2) = elem
      matList(rowCol._1)(rowCol._2) = Nil
      elem

    case _ => 0
  }

  def updateList(rowCol: (Int, Int), elem: Int): Unit = {
    val row = rowCol._1
    val col = rowCol._2

    /*
    aggiornamento per riga e per colonna
     */
    for (i <- 0 until dimSudoku) yield {
      if (i != col && matList(row)(i) != null) matList(row)(i) = matList(row)(i).filter(e => e != elem)
      if (i != row && matList(i)(col) != null) matList(i)(col) = matList(i)(col).filter(e => e != elem)
    }

    val r = (row / 3) * 3
    val c = (col / 3) * 3

    for {i <- r until r + 3; j <- c until c + 3; if i != row && j != col && matList(i)(j) != Nil}
      yield {matList(i)(j) = matList(i)(j).filter(e => e != elem)}
  }
}
