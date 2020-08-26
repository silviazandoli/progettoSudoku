package grafic.event.moduleListener

/**
* TODO: fare modulo che ha una funzione per aiutare
*  l'utente a scrivere i numeri ==> @Pacini
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
