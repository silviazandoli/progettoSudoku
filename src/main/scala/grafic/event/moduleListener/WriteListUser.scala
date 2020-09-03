package grafic.event.moduleListener

/**
* Made by Pacini
*/
protected[event] object WriteListUser {
  import grafic.panels.TextOpNumber.TextOpNumber

  def writePossibileElements(possibleValues: Set[Int], number: Int, t: TextOpNumber): Unit = {
    if (possibleValues.contains(number)) {
        t.addNumber(number)
        t.displayList()
    }
  }
}
