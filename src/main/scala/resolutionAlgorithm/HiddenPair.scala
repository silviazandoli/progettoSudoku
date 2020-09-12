package resolutionAlgorithm

import utility.{dimSudoku, matList}

/*Made by Zandoli*/

/*A hidden pair occurs when a pair of numbers appears in exactly
 two squares in a row, column, or block, but those two numbers aren't the only ones in their squares.
 */

object HiddenPair {

  def solveHiddenPair(): Unit = {
    val rows = (0 until dimSudoku).toList.map(checkRow)
    //we go to get the indexes
    rows.zipWithIndex.foreach(t => {
      val row = t._2
      t._1.foreach(p => {
        val newValues = p.intersection.head.toList
        //in the two squares it returns the newValues that are the values of the Hidden Pair with all other candidates removed
        //we overwrite the squares
        matList(row)(p.cell1) = newValues
        matList(row)(p.cell2) = newValues
      })
    })
    println("Hidden Pairs in rows:" + rows)

    val cols = (0 until dimSudoku).toList.map(checkColumn)
    cols.zipWithIndex.foreach(t => {
      val col = t._2
      t._1.foreach(p => {
        val newValues = p.intersection.head.toList
        matList(p.cell1)(col) = newValues

        matList(p.cell2)(col) = newValues
      })
    })
    println("Hidden Pairs in columns: " + cols)


    val blocks = (0 until dimSudoku).toList.map(checkBlock)
    blocks.zipWithIndex.foreach(t => {
      val block = t._2
      var shiftRow = 0
      var shiftCol = 0
      block match {
        case 0 | 1 | 2 =>
          shiftRow = 0
          shiftCol = block * 3
        case 3 | 4 | 5 =>
          shiftRow = 3
          shiftCol = (block - 3) * 3
        case 6 | 7 | 8 =>
          shiftRow = 6
          shiftCol = (block - 6) * 3
      }
      t._1.foreach(p => {
        //we need to localize the two squares in the block
        List(p.cell1, p.cell2).foreach(c => {
          import resolutionAlgorithm.HiddenPairsHelpers._
          //use of an implicit
          val converted=c.base3()
          val ct = (converted._1 + shiftRow, converted._2 + shiftCol)
          matList(ct._1)(ct._2) = p.intersection.head.toList
        })


      })
    })
    println("Hidden Pairs in blocks:" + blocks)

  }

  def check(ml: List[(List[Int], Int)]): List[PossiblePair] = {
    //possiblePairs contains all the possibles pairs with their coordinates
    val possiblePairs = ml.map(couples).toSet.subsets(2).toList.map(e => {
      //the first
      val val1 = e.head //(List[Set[Int]],Int)
      //the second
      val val2 = e.tail.head
      //intersection are the pairs which are present in both
      val intersection = val1._1.toSet.intersect(val2._1.toSet)
      PossiblePair(val1._2, val2._2, intersection)

    }).filter(_.intersection.nonEmpty) //those which have intersection nonEmpty could be the possible HiddenPairs

    // println(possiblePairs)
    //there are some cases as List(1,7,Set(Set(4,3),Set(5,6)). From row 34 to 38
    //I make sure to separate the different pairs in order to get
    // List(1,7,Set(Set(4,3))) e List(1,7,Set(Set(5,6)))
    val flattenPairs = possiblePairs.flatMap(p => {
      p.intersection.map(pair => {
        PossiblePair(p.cell1, p.cell2, Set(pair))
      })
    })
    //it finds the hidden pairs
    val hiddenPairs = flattenPairs.filter(p => {
      val cell1 = p.cell1
      val cell2 = p.cell2
      //on matList I remove elems of cell1 and cell2 and I leave other elements
      val exclusion = ml.filter(_._2 != cell1).filter(_._2 != cell2).flatMap(e => e._1.toSet).toSet
      //we have to compare inside intersection elem per elem. We get the first
      //If exclusion contains the first pair
      val c1 = exclusion.contains(p.intersection.head.head)
      //we have to compare inside intersection elem per elem. We get the second. tail contains more element so we get the head
      //If exclusion contains the second pair
      val c2 = exclusion.contains(p.intersection.head.tail.head)
      //if both the possible pairs aren't in exclusion they are an HIDDEN PAIR
      !c1 && !c2


    })
    hiddenPairs
  }


  def checkRow(row: Int): List[PossiblePair] = {

    //it gets the squares of the matList which have more than one element
    //in the result with zipWithIndex we store also the indexes of the elements that we don't discard
    //in _1 there is the list

    val ml = matList(row).toList.zipWithIndex.filter(_._1.size > 1)

    check(ml)

  }


  def checkColumn(col: Int): List[PossiblePair] = {

    //it gets the squares of the matList which have more than one element
    val ml = matList.map(_ (col)).zipWithIndex.filter(_._1.size > 1).toList
    check(ml)

  }


  def checkBlock(blk: Int): List[PossiblePair] = {
    /*blk=0 i=0..2 j=0..2 ; blk=1 i=0..2 j=3..5; blk=2 i=0..2 j=6..8 ; blk=3 i=3..5 j=0..2; blk=4 i=3..5 j=3..5; blk=5 i=3..5 j=6..8
      blk=6 i=6..8 j=0..2 ; blk=7 i=6..8 j=3..5; blk=8 i=6..8 j=6..8
     */
    val starti = blk match {
      case 0 | 1 | 2 => 0
      case 3 | 4 | 5 => 3
      case 6 | 7 | 8 => 6
    }
    val startj = (blk * 3) % 9

    val square = for {
      i <- starti to (starti + 2)
      j <- startj to (startj + 2)


    } yield (i, j)
    val h = square.head

    //calc indexes of the block
    def calcindex(p1: Int, p2: Int): Int = {
      val pp1 = p1 - h._1
      val pp2 = p2 - h._2
      //pp1*3^1+ pp2*3^0
      pp1 * 3 + pp2
    }

    val ml = square.map(p => (matList(p._1)(p._2), calcindex(p._1, p._2))).toList
    // println(ml)
    check(ml)


  }

  def couples(l: (List[Int], Int)): (List[Set[Int]], Int) = {
    //"subsets" create all possible combinations from the elements of a list
    //we have to sort the couples and to consider for example the case (4,5)=(5,4)
    // from the list we only take the the subsets who have size two
    //it obtains a list of elems taken 2 per 2
    val l1 = l._1.toSet.subsets(2).toList

    //I store the indexes that got to me on l and put them on l2
    val l2 = l._2
    (l1, l2)
  }


  case class PossiblePair(cell1: Int, cell2: Int, intersection: Set[Set[Int]])

}

//an implicit
object HiddenPairsHelpers{
  implicit class IntHelper(num:Int){

    def base3(): (Int, Int) = {
      val one = num / 3
      val first = num % 3
      val second = one % 3
      (second, first)
    }
  }
}
