package grafic.panels

import grafic.Sudoku.Sudoku
import sudoku.MatListOperation.initList
import sudoku.SudokuEngine.strategyList
import AuxFunctSPanel.stopVar


/**
 * @Antonelli => da implementare
 */
object Resolve {

  def resolve() = {
    initList()
    strategyList()
    stopVar = true;
    val sudoku = Sudoku()
    sudoku.create()
  }

}
