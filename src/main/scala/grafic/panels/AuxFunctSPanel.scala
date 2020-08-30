package grafic.panels

object AuxFunctSPanel {

  import java.awt.Color

  import grafic.textTime
  import grafic.util.{AssociateListener, factSecond, score}

  var timeInit: Long = 0
  var stopVar = false
  var firstTime = true

  //if you load a game that you stopped you have to set the old time and score too
 /* if(load) {
    SaveLoad.read()
  }*/

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
              textTime.append("\nYour time = " + time)

              startStopButton.setBackground(Color.green)
            } catch {
              case _: NumberFormatException =>
            }
          }
        }
      }
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

  def startGame(): Unit = {
    stopVar = false
    if (firstTime) {
      timeInit = System.currentTimeMillis() / factSecond - timeInit
      firstTime = false

      thread.start()
    }
  }
}
