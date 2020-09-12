package grafic.panels

/**
 * Made by Pacini
 */
object AuxFunctSPanel {
  import java.awt.Color
  import grafic.FileChooserMain.load
  import grafic.util.{AssociateListener, factSecond, score}
  import grafic.panels.funAux.ThreadTime

  var timeInit: Long = 0
  var stopVar = true
  var firstTime = true

  var thread: ThreadTime = ThreadTime()

  /**
   *  when button is green, user can click to start game.
   *  when button is red user can click to stop game and see his/her results.
   */
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

  /**
   * time init = actual if a new game is launched
   * (not launched a previous game)
   * if thread is not alive make execution of thread
   */
  def startGame(): Unit = {
    // no loaded and not stopped before
    stopVar = false
    if (firstTime) {
      if (!load) {
        timeInit = System.currentTimeMillis() / factSecond
        score = 0
      }
      firstTime = false

      if (!thread.isAlive) thread.start()
    }
  }
}