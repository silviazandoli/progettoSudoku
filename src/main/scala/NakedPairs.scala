import scala.io.Source

object NakedPairs  {
  val unit = 3 // larghezza blocco -> for che scorre di tre
  import SudokuLoad.{puzzle,dimSudoku,display}
  import SudokuMatrix.matList;

  def main(args: Array[String]): Unit = {
    println("start sudoku naked")
    solve(0, 0)
    display()
  }

  def solve(row: Int, col: Int): Boolean = {
    if (puzzleSolved()) {
      return true
    } else {
      //for riga x colonna
      for (i <- 0 until dimSudoku) {
        for (j <- 0 until dimSudoku) {
          if (matList(i)(j).size == 2) { // se non entra significa l'elenco ha un solo elemento all'interno
                                          // deve essere assegnato al puzzle.
            /*lista size*/
            var number = new Array[Int](dimSudoku)



          }
        }
      }
      //for del blocco 3x3
      for (k <- 0 until unit) {
        for (z <- 0 until unit) {
          print("blocco")
        }
      }
      false
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
}
