package grafic.event.moduleListener

protected[event] object MatListVision {
  import grafic.panels.TextOpNumber.TextOpNumber
  import grafic.util.FONT_MINILIST
  import grafic.{showNumberList, set}

 /*@Antonelli*/
  def seeVision(possibleValues: Set[Int], t: TextOpNumber): Unit = {
    var textIns : String = ""
    showNumberList.setText("")

    possibleValues.foreach(el => {
      textIns = el + "  "
      showNumberList.append(textIns)
    })

    set[(Int, Int)](-1, -1)
    t.setFont(FONT_MINILIST)
    t.setEditable(true)

    showNumberList.setEditable(false)
    showNumberList.setEnabled(false)
  }
}
