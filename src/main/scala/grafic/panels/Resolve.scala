package grafic.panels

import java.awt.Container

import grafic.Sudoku.Sudoku
import sudoku.MatListOperation.initList
import sudoku.SudokuEngine.strategyList
import AuxFunctSPanel.stopVar
import javax.swing.JFrame



/**
 * @Antonelli => da implementare
 */
object Resolve {

  def resolve(cp : Container) = {
    //System.exit(0)
    initList()
    strategyList()
    stopVar = true;
    //main.dispose()
    cp.setVisible(false)
    val sudoku = Sudoku()
    sudoku.create()

  }

}
