package sudoku

import sudoku.MatListOperation.{initList, minList, setUnitList, updateList}
import resolutionAlgorithm.FullExploration.solve
import resolutionAlgorithm.HiddenSingles.totalHiddenSingles
import strategies.{Strategy, StrategyImpl}
import sudoku.SudokuLoad.loadPuzzle
import util.TimeStampImpl
import utility.{display, puzzle, puzzleSolved}

object SudokuEngine extends App {
  val nameFile = "input/sudoku05.txt"

  /*
  strategia con assegnazione numero di liste unitarie
   */
  def strategyList(): Unit = {
    val timeStamp = TimeStampImpl(System.currentTimeMillis())

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

    val strat2 = new StrategyImpl {override def resolutionMethod(): Unit = totalHiddenSingles()}
    val strat3 = new StrategyImpl {override def resolutionMethod(): Unit = solve(0, 0)}

    val strategies = List[Strategy](strat1, strat2, strat3)
    strategies.foreach(el => if (!puzzleSolved()) el.strategy())

    timeStamp.calculateDiff(System.currentTimeMillis())
  }

  loadPuzzle(nameFile)
  display("Inizio", puzzle)
  initList()
  strategyList()
  display("Soluzione", puzzle)
}
