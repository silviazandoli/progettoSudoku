package grafic.panels

object AuxFunctSPanel {
  import java.awt.Color
  import grafic.util.{AssociateListener, factSecond}
  import grafic.panels.funAux.ThreadTime
  import grafic.panels.funAux.FunThread.myThread

  var timeInit: Long = 0
  var stopVar = false
  var firstTime = true

  //var thread: ThreadTime = _

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

  def startGame() = {
    stopVar = false
    if (firstTime) {
      timeInit = System.currentTimeMillis() / factSecond - timeInit
      firstTime = false

      myThread.start() // thread
    }
  }

  /*
  def startGame(): Unit = {
    synchronized {
      textTime.setText("")
    }
    if (timeInit <= 0) timeInit = System.currentTimeMillis() / factSecond
    stopVar = false
  }
   */
}
