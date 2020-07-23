package resolutionAlgorithm
import utility.matList
object HiddenPair{
case class PossiblePair(cell1: Int, cell2: Int, intersection: Set[Set[Int]])

    //A hidden pair occurs when a pair of numbers appears in exactly two squares in a row, column, or block,
    // but those two numbers aren't the only ones in their squares.you can get rid of the other candidates in those squares
    //per
    // val emptyCells: List[(Int,Int)]

    // updateList(rowCol: (Int, Int), elem: Int): aggiorna giÃ  la matList e elimina gli elementi Ã¨ in sudoku matrix
    //la matlist deve essere condivisa, ci deve essere un'istanza della matList, non piÃ¹
    //assegnare qui un'altra variabile a matList
    //gli algoritmi NON risolvono il sudoku, presi singolarmente non risolvono il sudoku, concentrarsi per casi noti.
    //bisogna concentrasi per casi noti, come per esempio, si prende il sudoku per quella pagina lÃ¬. applicando l'algoritmo per
    //questa cella si prende il numero fissato
    //alla fine noi abbiamo il solve di forza bruta  per risolverlo


  def solveHiddenPair(): Unit = {
      val row = 1
      // prende le celle della matList con piÃ¹ di un elemento
      val ml = matList(row).toList.zipWithIndex.filter(_._1.size > 1)

      //possiblePairs contains all the possibles pairs with their coordinates
      val possiblePairs = ml.map(couples).toSet.subsets(2).toList.map(e => {
        val val1 = e.head
        val val2 = e.tail.head
        val intersection = val1._1.toSet.intersect(val2._1.toSet)
        PossiblePair(val1._2, val2._2, intersection)

      }).filter(_.intersection.nonEmpty)

      println(possiblePairs)
/*possiblePairs.foreach(p=>{
  val cell1=p.cell1
  val cell2=p.cell2
  val exclusion=ml.filter(_._2 != cell1).filter(_._2 != cell2).map(e => e._1.toSet).flatten.toSet
  if(! exclusion.contains(p.cell1) && ! exclusion.contains(p.cell2)){
    possiblePairs.drop(cell1)
    possiblePairs.drop(cell2)
  }
})*/
    //trova la hidden pair
     possiblePairs.filter(p => {
        val cell1 = p.cell1
        val cell2 = p.cell2
        val exclusion = ml.filter(_._2 != cell1).filter(_._2 != cell2).map(e => e._1.toSet).flatten.toSet
        println(exclusion)
       // ! exclusion.toList.contains(p.cell1) && ! exclusion.toList.contains(p.cell2)
        val c1=exclusion.contains(p.cell1)
        println(c1)
        val c2=exclusion.contains(p.cell2)
        println(c2)
        // e1.union(e2)}

      //  c1 && c2
        println(!c1 && !c2)
        !c1 && !c2
     /*  if(c1==false && c2==false){
          return true
       }else{
         return false
       }*/
        //con questo filter trovo le hidden pair possibili
        //todo
        //fare questo lavoro per ogni riga, colonna e blocco
        //fare la cosa dell'eliminazione
      })
      println(possiblePairs)

      //per trovare le coppie
      // List(1,2,3).toSet[Int].subsets.map(_.toList).toList

    }
  // updateList(rowCol: (Int, Int), elem: Int): aggiorna già  la matList e elimina gli elementi ¨ in sudoku matrix

    def couples(l: (List[Int], Int)): (List[Set[Int]], Int) = {
      val l1 = l._1.toSet.subsets(2).toList

      //memorizzo gli indici che mi sono arrivati su l
      val l2 = l._2
      (l1, l2)
    }

}
