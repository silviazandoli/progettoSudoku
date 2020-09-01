package grafic.panels.funAux

import grafic.panels.AuxFunctSPanel.stopVar
import grafic.textTime
import grafic.panels.AuxFunctSPanel.timeInit
import grafic.util.{factSecond, score}

object FunThread {

  var myThread = new Thread() {
    override def run() {
      while (true) {
        println("stopVar = " + stopVar)
        if (!stopVar) {
          synchronized {
            textTime.setText("Your Time: " + ((System.currentTimeMillis() / factSecond) - timeInit))
          }
        } else {
          val text: String = textTime.getText()
          if (!text.isEmpty) {
            try {
              val time = text.substring(11, text.length).toInt
              synchronized {
                textTime.setText("")
                textTime.append("Your score = " + score)
                textTime.append("\nYour time = " + time)
              }
            } catch {
              case _: NumberFormatException =>
            }
          }
        }
      }
    }
  }
}
