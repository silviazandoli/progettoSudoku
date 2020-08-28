package grafic.panels.funAux

import java.io.{BufferedWriter, File, FileWriter}

import grafic.masks

object SaveLoad {
  import grafic.tfCells
  import utility.dimSudoku

  def save(): Unit = {
    val file = new File("temp/tmp.txt")
    val bw = new BufferedWriter(new FileWriter(file))

    for {
      i <- 0 until dimSudoku
      j <- 0 until dimSudoku
      //if (tfCells(i)(j).getList.isEmpty)
    } {
      if (masks(i)(j)) {
        val text = tfCells(i)(j).getText
        val number = text.charAt(0)
        bw.append(number)
      } else {
        bw.append('0')
      }

      if (j == dimSudoku - 1) {
        bw.append('\n')
      }
    }
    bw.close()
  }
}
