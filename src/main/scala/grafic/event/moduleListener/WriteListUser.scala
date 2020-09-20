package grafic.event.moduleListener

/**
* Made by Pacini
*/
import grafic.event.moduleListener.ControlAndFinish.seeVisionErrors
protected[event] object WriteListUser {
  import grafic.panels.TextOpNumber.TextOpNumber

  /**
   * It tries to insert the number in the cell
   * @param possibleValues of the numbers of the cell
   * @param number to be inserted
   * @param t the cell
   */
  def writePossibileElements(possibleValues: Set[Int], number: Int, t: TextOpNumber): Unit = {
    seeVisionErrors(possibleValues,number,t)
    if (possibleValues.contains(number)) {

        t.addNumber(number)
        t.displayList()
    }
  }
}
