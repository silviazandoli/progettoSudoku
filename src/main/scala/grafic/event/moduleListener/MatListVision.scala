package grafic.event.moduleListener

import grafic.showNumberList
import grafic.util.SEE_MATLIST
protected[event] object MatListVision {

  /**
   * TODO: fare modulo che ha una funzione che scrive i numeri della matlist
   *       nella jTextArea di showNumberList ==> @Antonelli
   */
  def seeVision(possibleValues: Set[Int]) = {
    println(SEE_MATLIST)
    showNumberList.setEditable(true)
    showNumberList.setEnabled(true)

    possibleValues.foreach(el => {
      val textIns = el + ","
      showNumberList.append(textIns)
    })

    showNumberList.setEditable(false)
    showNumberList.setEnabled(false)
  }
}
