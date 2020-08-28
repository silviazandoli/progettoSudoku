package grafic.panels

import grafic.util.AssociateListener

object AuxFunctSPanel {
  import java.awt.Color
  import grafic.util.{score, factSecond}
  import grafic.textTime

  var timeInit: Long = 0
  var stopVar = false
  var firstTime = true

  var thread = new Thread {
    override def run() {
      while (true) {
        if (!stopVar) {
          textTime.setText("Your Time: " + ((System.currentTimeMillis() / factSecond) - timeInit))
        } else {
          val text = textTime.getText()
          if (!text.isEmpty) {
            try {
              val time = text.substring(11, text.length).toInt

              textTime.setText("")
              textTime.append("Your score = " + score)
              textTime.append("\n Your time = " + time)

              startStopButton.setBackground(Color.green)
            } catch {
              case _: NumberFormatException =>
            }
          }
        }
      }
    }
  }

  def startGame(): Unit = {
    stopVar = false
    if (firstTime) {
      timeInit = System.currentTimeMillis()/factSecond
      firstTime = false
      thread.start()
    }
  }

  def startStop(): Unit = {
    if (startStopButton.getBackground == Color.green) {
      AssociateListener.associateListener()
      startGame()
      startStopButton.setBackground(Color.red)
    } else {
      stopVar = true
      startStopButton.setBackground(Color.green)
    }
  }
}
