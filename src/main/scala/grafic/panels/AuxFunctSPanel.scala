package grafic.panels

object AuxFunctSPanel {
  import java.awt.Color
  import grafic.util.{score, factSecond}
  import grafic.textTime

  def startGame(): Unit = {
    val timeInit = System.currentTimeMillis()/factSecond
    thread = new Thread {
      override def run() {
        while (true) {
          textTime.setText("Your Time: " + ((System.currentTimeMillis()/factSecond)-timeInit))
        }
      }

      override def interrupt(): Unit = {
        super.interrupt()
        val text = textTime.getText()
        val time = text.substring(11, text.length).toInt

        textTime.setText("")
        textTime.append("Your score = " + score)
        textTime.append("\n Your time = " + time)

        startStopButton.setBackground(Color.green)
      }
    }
    thread.start()
  }
}
