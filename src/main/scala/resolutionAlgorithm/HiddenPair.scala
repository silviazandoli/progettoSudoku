package resolutionAlgorithm

import sudoku.SudokuLoad.{dimSudoku, puzzle}
import sudoku.MatListOperation.matList

object HiddenPair {
  //A hidden pair occurs when a pair of numbers appears in exactly two squares in a row, column, or block,
  // but those two numbers aren't the only ones in their squares.you can get rid of the other candidates in those squares
  //per
 // val emptyCells: List[(Int,Int)]
  def solveHiddenPair(row: Int, col: Int): Unit = {
    //val regions = List("row", "col", "block")
    val exludingSet = List.empty

    //1) I check for every row, col and block
    for (i <- 0 until dimSudoku) {
      for (j <- 0 until dimSudoku) {


        val remainingDigits = matList(i)(j).toList

        //put empty cells coordinates in freeCells
     //todo
       // if (puzzle(i)(j)==0) emptyCells.
        //number of free cells in puzzle
        val freeSize = puzzle.flatten.filter(_ == 0).toList.size
        for(a<-0 until freeSize){
          for(b<-a+1 until freeSize){
            //checking two cells at a time
            for(n<-0 until freeSize){
              if(n!=a && n!=b){
          //      freeCells.find(n)
              }
            }
          }
        }











      }


    }






  }

  /* def possible(row:Int,col:Int, puzzle: Array[Array[Int]]):List[Int] = {

         //escludo per riga
         val rowExcl = puzzle(row).toList.filter(_ != 0).toSet

         //escludo per colonna
         val colExcl = puzzle.toList.map(_ (col)).filter(_ != 0).toSet

         //escludo per blocco 3*3
         val ci = row / 3
         val cj = col / 3

         val block = puzzle.grouped(3).toList(ci).flatMap { x => x.grouped(3).toList(cj) }.filter(_ != 0).toList.toSet
         println(" riga" + row + " colonna" + col + " numeri riga: " + rowExcl + " numeri colonna: " + colExcl + " blocco:" + block)

         //faccio l'unione per riga, per blocco e colonna
         val unity = rowExcl.union(colExcl).union(block)

         //faccio un set differenza, in possible ci metti tutti i numeri che non sono nell'unione
         val possible = (1 to dimSudoku).toSet.diff(unity).toList
         println(possible)

         //println(" matList nella posizione " + row + "," + col+ " è " + possible)
     possible


   }
   def createMatlist(puzzle: Array[Array[Int]]) = {
        for(i<-0 until dimSudoku) {
          for(j<-0 until dimSudoku) {
            matList(i)(j)=possible(i,j,puzzle)
            println(" matList nella posizione " + i + "," + j+ " è " + matList(i)(j))
          }
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
