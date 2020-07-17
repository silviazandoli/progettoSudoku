object NakedPairs {
  val unit = 3 // larghezza blocco -> for che scorre di tre

  import SudokuLoad.{puzzle, dimSudoku, display}
  import SudokuMatrix.matList;
  var e2lement = new Array[Int](2)


  def main(args: Array[String]): Unit = {
    println("start sudoku naked")
    solve()
    display()
  }

  def solve(): Unit = {
    /*if (puzzleSolved()) {
      return true
    } else {*/
    //for riga x colonna
    for (i <- 0 until dimSudoku) {
      for (j <- 0 until dimSudoku) {
        if (matList(i)(j).size == 2) {
          /*lista size*/
          val number : Array[List[Int]]  = Array.ofDim[List[Int]](2)//array con i 2 numeri
          var k: Int = 0 ;
          number(k) = matList(i)(j)(k)
          e2lement(k) = puzzle(i)(j)
          k+=1;
        }
      }
      //for del blocco 3x3
      for (k <- 0 until unit) {
        for (z <- 0 until unit) {
          print("blocco")
        }
      }
    }
  }

  def puzzleSolved(): Boolean = {
    for (i <- 0 until dimSudoku) {
      for (j <- 0 until dimSudoku) {
        if (puzzle(i)(j) == 0) {
          return false
        }
      }
    }

    true
  }
}
  /*def solve(row: Int, col: Int): Boolean = {
    var result: java.lang.Boolean = false
    var k: Int = 0
    while (k < 9 && !result) {
      if (naked_pair_unit(puzzle(k) || naked_pair_unit(puzzle(k)) ||
        naked_pair_unit(box(k))) {
        result = true
      }
      { k += 1; k - 1 }
    }
    return result;
  }
  def naked_pair_unit(C: Int[9][2]): Unit ={

  }*/

