package resolutionAlgorithm
import utility.{dimSudoku, matList}
/*A hidden pair occurs when a pair of numbers appears in exactly
 two squares in a row, column, or block, but those two numbers aren't the only ones in their squares.
 */
//todo
//manca il blocco
//fare la cosa dell'eliminazione (con l'updateList che c'è nel  progetto)
object HiddenPair {

  def solveHiddenPair(): Unit = {
    val rows = (0 until dimSudoku).toList.map(checkRow)
    println(rows)

    val cols = (0 until dimSudoku).toList.map(checkColumn)
    println(cols)
  }

  def checkRow(row: Int) = {

    // prende le celle della matList con piÃ¹ di un elemento
    val ml = matList(row).toList.zipWithIndex.filter(_._1.size > 1)

    //possiblePairs contains all the possibles pairs with their coordinates
    val possiblePairs = ml.map(couples).toSet.subsets(2).toList.map(e => {
      val val1 = e.head
      val val2 = e.tail.head
      val intersection = val1._1.toSet.intersect(val2._1.toSet)
      PossiblePair(val1._2, val2._2, intersection)

    }).filter(_.intersection.nonEmpty)

    // println(possiblePairs)
    //ci sono alcuni casi come List(1,7,Set(Set(4,3),Set(5,6)). da riga 34 a 38 faccio in modo di separare
    //le diverse coppie in modo che venga List(1,7,Set(Set(4,3))) e List(1,7,Set(Set(5,6)))
    val flattenPairs = possiblePairs.map(p => {
      p.intersection.map(pair => {
        PossiblePair(p.cell1, p.cell2, Set(pair))
      })
    }).flatten
    //trova la hidden pair
    val hiddenPairs = flattenPairs.filter(p => {
      val cell1 = p.cell1
      val cell2 = p.cell2
      val exclusion = ml.filter(_._2 != cell1).filter(_._2 != cell2).map(e => e._1.toSet).flatten.toSet
      //we have to compare inside intersection elem per elem. We get the first
      val c1 = exclusion.contains(p.intersection.head.head)
      //we have to compare inside intersection elem per elem. We get the second. tail contains more element so we get the head
      val c2 = exclusion.contains(p.intersection.head.tail.head)

      !c1 && !c2


    })
    hiddenPairs

  }

  def checkColumn(col: Int) = {

    // prende le celle della matList con piÃ¹ di un elemento
    //  val ml = matList(row).toList.zipWithIndex.filter(_._1.size > 1)
    val ml = matList.map(_ (col)).zipWithIndex.filter(_._1.size > 1)
    //possiblePairs contains all the possibles pairs with their coordinates
    val possiblePairs = ml.map(couples).toSet.subsets(2).toList.map(e => {
      val val1 = e.head
      val val2 = e.tail.head
      val intersection = val1._1.toSet.intersect(val2._1.toSet)
      PossiblePair(val1._2, val2._2, intersection)

    }).filter(_.intersection.nonEmpty)

    // println(possiblePairs)
    val flattenPairs = possiblePairs.map(p => {
      p.intersection.map(pair => {
        PossiblePair(p.cell1, p.cell2, Set(pair))
      })
    }).flatten
    //trova la hidden pair
    val hiddenPairs = flattenPairs.filter(p => {
      val cell1 = p.cell1
      val cell2 = p.cell2
      val exclusion = ml.filter(_._2 != cell1).filter(_._2 != cell2).map(e => e._1.toSet).flatten.toSet
      // println(exclusion)
      // ! exclusion.toList.contains(p.cell1) && ! exclusion.toList.contains(p.cell2)
      val c1 = exclusion.contains(p.intersection.head.head)
      //  println(c1)
      val c2 = exclusion.contains(p.intersection.head.tail.head)

      !c1 && !c2


    })
    hiddenPairs

  }

  def couples(l: (List[Int], Int)): (List[Set[Int]], Int) = {
    val l1 = l._1.toSet.subsets(2).toList

    //memorizzo gli indici che mi sono arrivati su l
    val l2 = l._2
    (l1, l2)
  }

  //per trovare le coppie
  // List(1,2,3).toSet[Int].subsets.map(_.toList).toList
  //fare la cancellazione di una intera coppia possible Pair

  def checkBlock(blk: Int) = {
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
    val ml = square.map(p => (matList(p._1)(p._2), (p._1 + p._2) % 9))


  }


  // updateList(rowCol: (Int, Int), elem: Int): aggiorna giÃ  la matList e elimina gli elementi Ã¨ in sudoku matrix



  // updateList(rowCol: (Int, Int), elem: Int): aggiorna già  la matList e elimina gli elementi ¨ in sudoku matrix
  //csearch for row, for column and for block


  case class PossiblePair(cell1: Int, cell2: Int, intersection: Set[Set[Int]])

}
