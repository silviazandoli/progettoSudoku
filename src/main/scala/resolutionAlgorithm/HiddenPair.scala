package resolutionAlgorithm

import resolutionAlgorithm.SudokuLoad.dimSudoku
import resolutionAlgorithm.SudokuMatrix.matList

object HiddenPair {
  //inserisce in ogni cella i numeri possibili
  def createMatlist(puzzle: Array[Array[Int]]) = {
   for(i<-0 until dimSudoku){
     for(j<-0 until dimSudoku){
       val row=puzzle(i).toList.filter(_!=0).toSet
       val col=puzzle.toList.map(_(j)).filter(_!=0).toSet
     }

   }
    //1 escludo quelli per riga
    val row0=puzzle(0).toList.filter(_!=0).toSet
    println(row0)
    //2 escludo quelli per colonna
    val col0=puzzle.toList.map(_(0)).filter(_!=0).toSet

    //3 escludo quelli per blocco 3*3
    val block0=puzzle.take(3).toList.map(_.take(3).toList).flatten.filter(_!=0).toSet
    val un=row0.union(col0).union(block0)
    val possible=(1 to dimSudoku).toSet.diff(un)
    println(possible)
    matList(0)(0)=possible.toList
  }

  //A hidden pair occurs when a pair of numbers appears in exactly two squares in a row, column, or block,
  // but those two numbers aren't the only ones in their squares.you can get rid of the other candidates in those squares


  /*
  implementazione provvisoria di trovare coppie nel puzzle
   */

  def findCouplePuzzle(row: Int, col: Int): Unit = {
    val listCouple = findCouple(row, col)

    if (listCouple != Nil) {
      listCouple(0)
      listCouple(1)
    }

    if (row < dimSudoku) findCouplePuzzle(row + 3, col)
  }

  /*
  data una cella cerca ogni possibile coppia nel suo sottoquadrato
   */
  def findCouple(row: Int, col: Int): List[(Int, Int)] = {
    val r = (row / 3) * 3
    val c = (col / 3) * 3

    val coupleFirst = (row, col)
    var coupleSecond = (row, col)

    for {
      i <- r until r + 3
      j <- c until c + 3
      if i != row && j != col
    } yield {
      if (matList(row)(col) == matList(i) (j)) {
        coupleSecond = (i, j)
        return List(coupleFirst, coupleSecond)
      }
    }
    Nil
  }

}
