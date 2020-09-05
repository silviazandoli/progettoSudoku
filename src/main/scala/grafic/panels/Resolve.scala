package grafic.panels

import grafic.Sudoku.Sudoku
import sudoku.MatListOperation.initList
import sudoku.SudokuEngine.strategyList
import AuxFunctSPanel.thread


/**
 * @Antonelli => da implementare
 */
object Resolve {

  def resolve() = {
    initList()
    strategyList()
    thread.stop()
    val sudoku = Sudoku()
    sudoku.create()
  }

}
