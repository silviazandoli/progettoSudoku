package grafic.panels.funAux

import grafic.textTime
import grafic.panels.AuxFunctSPanel.{stopVar, timeInit}
import grafic.util.{factSecond, score}

/**
 * Made by Pacini
 */
sealed trait ThreadTime extends Thread {

  /**
   * append time and score on textField for
   * user to understand his/her performance
   */
  private def appendScoreTime(): Unit = {
    val text: String = textTime.getText()
    if (!text.isEmpty) {
      try {
        val time = text.substring(11, text.length).toInt
        textTime.setText("")
        textTime.append("Your score = " + score)
        textTime.append("\nYour time = " + time)
      } catch {
        case _: NumberFormatException =>
      }
    }
  }

  /**
   * set current time on field of game time
   */
  override def run() {
    while (true) {
      if (!stopVar) {
        textTime.setText("Your Time: " + ((System.currentTimeMillis() / factSecond) - timeInit))
      } else {
        appendScoreTime()
      }
    }
  }
}
object ThreadTime {
  def apply(): ThreadTime = ThreadTimeImpl()
  private case class ThreadTimeImpl() extends ThreadTime
}
