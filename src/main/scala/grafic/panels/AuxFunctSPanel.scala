package grafic.panels

import grafic.FileChooserMain.load

/**
 * Made by Pacini
 */
object AuxFunctSPanel {
  import java.awt.Color
  import grafic.util.{AssociateListener, factSecond}
  import grafic.panels.funAux.ThreadTime

  var timeInit: Long = 0
  var stopVar = true
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
    // no loaded and not stopped before
    stopVar = false
    if (firstTime) {
      if (!load) timeInit = System.currentTimeMillis() / factSecond
      firstTime = false

      if (!thread.isAlive) thread.start()
    }
  }
}