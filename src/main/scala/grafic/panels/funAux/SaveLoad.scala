package grafic.panels.funAux

object SaveLoad {
  import java.io.{BufferedWriter, File, FileWriter}

  import grafic.{masks, tfCells}
  import utility.dimSudoku

  /*
  implicit class FileMonads(f: File) {
    def check: Option[File] = if (f.exists) Some(f) else None //returns "Maybe" monad
    def remove: Option[File] = if (f.delete()) Some(f) else None //returns "Maybe" monad
  }
   */

  def save(): Unit = {
    val file = new File("temp/tmp.txt")
    file.createNewFile()
    val bw = new BufferedWriter(new FileWriter(file))

    //new File(path).check
    // foundFile.remove

    for {
      i <- 0 until dimSudoku
      j <- 0 until dimSudoku
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
