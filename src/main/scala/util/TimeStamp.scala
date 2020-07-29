package util

sealed trait TimeStamp {
  def timeStart: Long

  def calculateDiff(timeEnd: Long): Unit = {
    println("time : " + (timeEnd - timeStart))
  }
}

case class TimeStampImpl(timeStart: Long) extends TimeStamp
