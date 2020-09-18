package grafic.event.moduleListener

/**
* Made by Pacini
*/
import grafic.event.moduleListener.ControlAndFinish.seeVision
protected[event] object WriteListUser {
  import grafic.panels.TextOpNumber.TextOpNumber

  def writePossibileElements(possibleValues: Set[Int], number: Int, t: TextOpNumber): Unit = {
    seeVision(possibleValues,number,t)
    if (possibleValues.contains(number)) {

        t.addNumber(number)
        t.displayList()
    }
  }
}
