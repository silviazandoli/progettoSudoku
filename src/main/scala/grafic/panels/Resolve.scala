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


  def resolve(main : JFrame) = {
    //System.exit(0)
    initList()
    strategyList()
    stopVar = true;
    main.dispose()
    //main.setVisible(false)
    val sudoku = Sudoku()
    sudoku.create()

  }

}
