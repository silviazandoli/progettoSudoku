package sudoku

import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper.Algorithm
import resolutionAlgorithm.FullExploration
import sudoku.MatListOperation.{initList, minList, setUnitList, updateList}
import resolutionAlgorithm.FullExploration.solve
import resolutionAlgorithm.HiddenSingles.totalHiddenSingles
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

    var elem = 0
    while (elem != 0) {
      val rowCol = minList()
      elem = setUnitList(rowCol)

      if (elem != 0) updateList(rowCol, elem) // assegna valore lista unitaria
    }

    if (!puzzleSolved()) totalHiddenSingles()

    solve(0, 0)

    timeStamp.calculateDiff(System.currentTimeMillis())
  }

  loadPuzzle(nameFile)
  display("Inizio", puzzle)
  initList()
  strategyList()
  display("Soluzione", puzzle)
}
