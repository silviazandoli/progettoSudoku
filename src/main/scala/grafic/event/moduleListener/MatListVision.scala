package grafic.event.moduleListener

import grafic.showNumberList
protected[event] object MatListVision {

  /**
   * TODO: fare modulo che ha una funzione che scrive i numeri della matlist
   *       nella jTextArea di showNumberList ==> @Antonelli
   */
  def seeVision(possibleValues: Set[Int]) = {
    var textIns : String = ""
    showNumberList.setText("")
    //println(SEE_MATLIST)

    possibleValues.foreach(el => {
      textIns = el + "  "
      showNumberList.append(textIns)
    })

    showNumberList.setEditable(false)
    showNumberList.setEnabled(false)
  }
}
