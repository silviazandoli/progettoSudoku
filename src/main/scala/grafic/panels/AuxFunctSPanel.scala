package grafic.panels

/**
 * Made by Pacini
 */
object AuxFunctSPanel {
  import java.awt.Color
  import grafic.util.{AssociateListener, factSecond}
  import grafic.panels.funAux.ThreadTime

  var timeInit: Long = 0
  var stopVar = false
  var firstTime = true

  var thread: ThreadTime = ThreadTime()

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