package sudoku

import resolutionAlgorithm.{FullExploration, HiddenSingles}
import resolutionAlgorithm.HiddenPair.solveHiddenPair
import resolutionAlgorithm.NakedPairs.solveNakedPair
import strategies.{Strategy, StrategyImpl}
import sudoku.MatListOperation.{initList, minList, setUnitList, updateList}
import sudoku.SudokuLoad.loadPuzzle
import util.TimeStampImpl
import utility.{display, puzzle, puzzleSolved}

object SudokuEngine extends App {
  val nameFile = "input/sudoku05.txt"

  /*
  strategia con assegnazione numero di liste unitarie
   */
  def strategyList(): Unit = {
    /**
     * case class timestamp fatta da Lorenzo Pacini
     */
    val timeStamp = TimeStampImpl(System.currentTimeMillis())

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
     * strategie 2/3 fatte da Lorenzo Pacini
     */

    val strat2 = new StrategyImpl {override def resolutionMethod(): Unit = HiddenSingles().totalHiddenSingles()}

    val strat3 = new StrategyImpl {override def resolutionMethod(): Unit = FullExploration(puzzle).solve(0, 0)}

    /*strategy 4 done by Zandoli*/
    val strat4=new StrategyImpl {override def resolutionMethod():Unit= solveHiddenPair()}

    val strat5 = new StrategyImpl {override def resolutionMethod():Unit= solveNakedPair()}

    /**
     * motore fatto da Lorenzo Pacini
     */
    val strategies = List[Strategy](strat1, strat2, strat3,strat4,strat5)
    strategies.foreach(el => if (!puzzleSolved()) el.strategy())

    timeStamp.calculateDiff(System.currentTimeMillis())
  }

  loadPuzzle(nameFile)
  display("Inizio", puzzle)
  initList()
  strategyList()
  display("Soluzione", puzzle)
}
