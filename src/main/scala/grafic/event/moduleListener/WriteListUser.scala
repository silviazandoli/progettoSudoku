package grafic.event.moduleListener

import grafic.panels.TextOpNumber.TextOpNumber

/**
* TODO: fare modulo che ha una funzione per aiutare
*  l'utente a scrivere i numeri ==> @Pacini
*/
protected[event] object WriteListUser {
  //val listNumber: List[Int]

  def writePossibileElements(possibleValues: Set[Int], number: Int, t: TextOpNumber): Unit = {
    if (possibleValues.contains(number)) {
        t.addNumber(number)
        t.setText("")
      }
  }
}
