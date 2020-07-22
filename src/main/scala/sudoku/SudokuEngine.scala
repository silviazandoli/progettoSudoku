package sudoku

import sudoku.MatListOperation.{minList, setUnitList, updateList}
import resolutionAlgorithm.FullExploration.solve
import resolutionAlgorithm.HiddenSingles.totalHiddenSingles
import util.TimeStampImpl
import utility.puzzleSolved

object SudokuEngine extends App {
  /*
  strategia con assegnazione numero di liste unitarie
   */
  def strategyList(): Unit = {
    val timeStamp = TimeStampImpl(System.currentTimeMillis())

    var elem = 0
    while (elem != 0) {
      val rowCol = minList()
      elem = setUnitList(rowCol)

      if (elem != 0) updateList(rowCol, elem) // assegna valore lista unitaria

      if (!puzzleSolved()) totalHiddenSingles()
    }

    solve(0, 0)

    timeStamp.calculateDiff(System.currentTimeMillis())
  }

  strategyList()
}
