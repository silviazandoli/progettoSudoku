package grafic.panels.funAux

import java.io.{BufferedReader, FileReader}

import grafic.textTime
import grafic.util.FileWork

import scala.util.Using

object SaveLoad {

  import java.io.{BufferedWriter, File, FileWriter}

  import grafic.FileChooserMain.load
  import grafic.panels.AuxFunctSPanel.timeInit
  import grafic.util.score
  import grafic.{masks, tfCells}
  import utility.dimSudoku

  def save(): Unit = {
    FileWork.deleteFile()
    FileWork.createFile()
    val bw = new BufferedWriter(new FileWriter(new File("temp/tmp.txt")))

    //you save the file
    for (i <- 0 until dimSudoku; j <- 0 until dimSudoku) {
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

    //you save the score and the time
    FileWork.createFile()

    val scoreFile = new BufferedWriter(new FileWriter(new File("score/score.txt")))
    val sco = score.toString

    scoreFile.write(sco)
    scoreFile.close()

    FileWork.createFile()
    try {
      val timerFile = new BufferedWriter(new FileWriter(new File("score/timer.txt")))
      val text = textTime.getText
      val time = text.substring(27, text.length)
      timerFile.write(time)
      timerFile.close()
    } catch {
      case _: Throwable => println("You have to save only after you have stopped the game!")
    }
  }

  def read(): Unit = {

    //the first if the case you open a new game
    if (!load) {
      timeInit = 0
      score = 0

    } else {
      /*for (lines <- bufferedSourceTimer.getLines) {
        lines.toList
      }*/
      val linesTimer: String =
        Using.resource(new BufferedReader(new FileReader("score/timer.txt"))) { reader =>
          Iterator.continually(reader.readLine()).takeWhile(_ != null).toSeq.toList.toString()

        }

      val linesScore: String =
        Using.resource(new BufferedReader(new FileReader("score/score.txt"))) { reader =>
          Iterator.continually(reader.readLine()).takeWhile(_ != null).toSeq.toList.toString()
        }
      val timel = linesTimer.count(a => a.isDigit)
      val scorel = linesScore.count(a => a.isDigit)

      timeInit = linesTimer.substring(5, (5 + timel)).toLong
      score = linesScore.substring(5, (5 + scorel)).toInt
      //println(lunghezza)
    }

  }
}
