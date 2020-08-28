package grafic.panels.funAux

import java.io.File

object SaveLoad {
  import grafic.tfCells
  import utility.dimSudoku

  def saveLoad(): Unit = {
    for {
      i <- 0 until dimSudoku
      j <- 0 until dimSudoku
      if (tfCells(i)(j).getList.isEmpty)
    } {
      val text = tfCells(i)(j).getText
      val number = text.toInt
    }

  }
}
