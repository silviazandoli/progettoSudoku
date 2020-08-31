package grafic.panels.funAux

import grafic.panels.AuxFunctSPanel.{timeInit, stopVar}
import grafic.textTime
import grafic.util.{factSecond, score}

sealed trait ThreadTime extends Thread {
  override def run() {
    while (true) {
      if (!stopVar) {
        synchronized {
          textTime.setText("Your Time: " + ((System.currentTimeMillis() / factSecond) - timeInit))
        }
      } else {
        val text = textTime.getText()
        if (!text.isEmpty) {
          try {
            val time = text.substring(11, text.length).toInt

            synchronized {
              textTime.setText("")
              textTime.append("Your score = " + score)
              textTime.append("\nYour time = " + time)
            }

            //startStopButton.setBackground(Color.green)
          } catch {
            case _: NumberFormatException =>
          }
        }
      }
    }
  }
}
object ThreadTime {
  def apply(): ThreadTime = ThreadTimeImpl()

  private case class ThreadTimeImpl() extends ThreadTime
}
