package grafic.panels.funAux

sealed trait ThreadTime extends Thread {
  /*override def run() {
    while (true) {
      if (!stopVar) {
        synchronized {
          println("timeInit = " + timeInit)
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
object ThreadTime {
  def apply(): ThreadTime = ThreadTimeImpl()

  private case class ThreadTimeImpl() extends ThreadTime*/
}
