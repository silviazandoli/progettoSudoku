package grafic.event.moduleListener

import java.awt.Color

import grafic.showNumberList
import grafic.util.SEE_MATLIST
protected[event] object MatListVision {

  /**
   * TODO: fare modulo che ha una funzione che scrive i numeri della matlist
   *       nella jTextArea di showNumberList ==> @Antonelli
   */
  def seeVision(possibleValues: Set[Int]) = {
    var textIns : String = ""
    //showNumberList.setVisible(true)
    showNumberList.setText("")
    println(SEE_MATLIST)
    //showNumberList.setEditable(true)
    //showNumberList.setEnabled(true)

    println("Possible values: "+ possibleValues)

    possibleValues.foreach(el => {
      println("el: " +el)
      textIns = el + "  "
      showNumberList.append(textIns)
    })

    showNumberList.setEditable(false)
    showNumberList.setEnabled(false)
    //showNumberList.setVisible(true)
  }
}
