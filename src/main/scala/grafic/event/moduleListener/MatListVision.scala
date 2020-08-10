package grafic.event.moduleListener

import grafic.panels.TextOpNumber.TextOpNumber
import grafic.util.{FONT_MINILIST, NUMBER}
import grafic.{setPressed, setWrite, showNumberList}
protected[event] object MatListVision {

 /*@Antonelli*/
  def seeVision(possibleValues: Set[Int], t: TextOpNumber) = {
    var textIns : String = ""
    showNumberList.setText("")
    //println(SEE_MATLIST)

    possibleValues.foreach(el => {
      textIns = el + "  "
      showNumberList.append(textIns)
    })
    setPressed(-1, -1)
    t.setFont(FONT_MINILIST);
    setWrite(NUMBER)
    t.setEditable(true)
    //setPressed(-1, -1)

    showNumberList.setEditable(false)
    showNumberList.setEnabled(false)
  }
}
