package sudoku

object SudokuEngine extends App {
  import resolutionAlgorithm.FullExploration
  import resolutionAlgorithm.HiddenSingles.totalHiddenSingles
  import resolutionAlgorithm.HiddenPair.solveHiddenPair
  import resolutionAlgorithm.NakedPairs.solveNakedPair
  import strategies.{Strategy, StrategyImpl}
  import sudoku.MatListOperation.{initList, minList, setUnitList, updateList}
  import sudoku.SudokuLoad.loadPuzzle
  import util.TimeStamp
  import utility.{display, puzzle, puzzleSolved}

  val nameFile = "input/easy/sudoku05.txt"

  /*
  strategia con assegnazione numero di liste unitarie
   */
  def strategyList(): Unit = {
    /**
     * case class timestamp fatta da Lorenzo Pacini
     */
    val timeStamp = TimeStamp(System.currentTimeMillis())

    /**
     * strategia1 fatta da Lorenzo Pacini
     */
    val strat1 = new StrategyImpl {
      override def resolutionMethod(): Unit = {
        var elem = -1
        while (elem != 0) {
          val rowCol = minList()
          elem = setUnitList(rowCol)

          if (elem != 0) updateList(rowCol, elem) // assegna valore lista unitaria
        }
      }
    }

    /**
     * strategies 2/3 made by Lorenzo Pacini
     */

    val strat2 = new StrategyImpl {override def resolutionMethod(): Unit = totalHiddenSingles()}

    val strat3 = new StrategyImpl {override def resolutionMethod(): Unit = FullExploration(puzzle).solve(0, 0)}

    /*strategy 4 done by Zandoli*/
    val strat4=new StrategyImpl {override def resolutionMethod():Unit= solveHiddenPair()}

    val strat5 = new StrategyImpl {override def resolutionMethod():Unit= solveNakedPair()}

    /**
     * engine made by Lorenzo Pacini
     */
    val strategies = List[Strategy](strat1, strat2, strat3,strat4,strat5)
    strategies.foreach(el => if (!puzzleSolved()) el.strategy())

    timeStamp.calculateDiff(System.currentTimeMillis())
  }

  loadPuzzle(nameFile)
  display(puzzle)("Inizio")
  initList()
  strategyList()
  display(puzzle)("Soluzione")
}
