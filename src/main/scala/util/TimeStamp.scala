package util

sealed trait TimeStamp {
  def timeStart: Long

  def calculateDiff(timeEnd: Long): Unit = {
    println("time : " + (timeEnd - timeStart))
  }
}

object TimeStamp {
  def apply(timeStart: Long): TimeStamp = TimeStampImpl(timeStart)

 private case class TimeStampImpl(timeStart: Long) extends TimeStamp
}
