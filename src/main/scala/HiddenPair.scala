
//file di prova, regola Hidden Pair/Triple
object HiddenPair {

  import SudokuLoad.dimSudoku

  val matList: Array[Array[List[Int]]] = Array.ofDim[List[Int]](dimSudoku, dimSudoku)

  def ruleHiddenSet: Boolean = {
    //A hidden pair occurs when a pair of numbers appears in exactly two squares in a row, column, or block,
    // but those two numbers aren't the only ones in their squares.you can get rid of the other candidates in those squares


    return true
  }

}
