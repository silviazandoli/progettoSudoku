package resolutionAlgorithm

import resolutionAlgorithm.SudokuLoad.dimSudoku
import resolutionAlgorithm.SudokuMatrix.matList

object HiddenPair {
  //inserisce in ogni cella i numeri possibili
  //Runna da TestHiddenPair

  def createMatlist(puzzle: Array[Array[Int]]) = {
    val possible=(1 to dimSudoku).toList

     for(i<-0 until dimSudoku){

     for(j<-0 until dimSudoku){
       //escludo per riga
       val row=puzzle(i).toList.filter(_!=0).toSet

      //escludo per colonna
       val col=puzzle.toList.map(_(j)).filter(_!=0).toSet

      //escludo per blocco 3*3
       val ci = i / 3
       val cj = j / 3

       val block = puzzle.grouped(3).toList(ci).flatMap { x => x.grouped(3).toList(cj)}.filter(_!=0).toList.toSet
       println(" riga"+ i+ " colonna"+j+ " numeri riga: "+ row+ " numeri colonna: "+ col+ " blocco:"+block)

       //faccio l'unione per riga, per blocco e colonna
         val unity=row.union(col).union(block)

        //faccio un set differenza, in possible ci metti tutti i numeri che non sono nell'unione
         val possible=(1 to dimSudoku).toSet.diff(unity).toList
       println(possible)

        matList(i)(j)=possible

       println(possible)
       println(" matList nella posizione "+i+","+j + " è "+matList(j)(j))


     }

   }

    }

    //1 escludo quelli per riga
   /*  val row0=puzzle(0).toList.filter(_!=0).toSet
    println(row0)
    //2 escludo quelli per colonna
    val col0=puzzle.toList.map(_(0)).filter(_!=0).toSet

    //3 escludo quelli per blocco 3*3
    val block0=puzzle.take(3).toList.map(_.take(3).toList).flatten.filter(_!=0).toSet
    val un=row0.union(col0).union(block0)
    val possible=(1 to dimSudoku).toSet.diff(un).toList
    println(possible)
    matList(0)(0)=possible
    matList(0)(1)=possible
    matList(0)(2)=possible
    matList(0)(0).foreach(i=> println(i))

    println(matList(0)(2))

  }*/
  //A hidden pair occurs when a pair of numbers appears in exactly two squares in a row, column, or block,
  // but those two numbers aren't the only ones in their squares.you can get rid of the other candidates in those squares


  /*
  implementazione provvisoria di trovare coppie nel puzzle
   */

 /* def findCouplePuzzle(row: Int, col: Int): Unit = {
    val listCouple = findCouple(row, col)

    if (listCouple != Nil) {
      listCouple(0)
      listCouple(1)
    }

    if (row < dimSudoku) findCouplePuzzle(row + 3, col)
  }*/

  /*
  data una cella cerca ogni possibile coppia nel suo sottoquadrato
   */
 /* def findCouple(row: Int, col: Int): List[(Int, Int)] = {
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
  }*/

}
