package grafic.event.moduleListener

import grafic.panels.TextOpNumber.TextOpNumber
import grafic.{setPressed, showNumberList}
protected[event] object MatListVision {

  /**
   * TODO: fare modulo che ha una funzione che scrive i numeri della matlist
   *       nella jTextArea di showNumberList ==> @Antonelli
   */
  def seeVision(possibleValues: Set[Int], t: TextOpNumber) = {
    var textIns : String = ""
    showNumberList.setText("")
    //println(SEE_MATLIST)

    possibleValues.foreach(el => {
      textIns = el + "  "
      showNumberList.append(textIns)
    })

    t.setEditable(true)
    showNumberList.setEditable(false)
    showNumberList.setEnabled(false)
    //setPressed(-1, -1)
  }
}
