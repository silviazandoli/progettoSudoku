package grafic.panels

import javax.swing.JTextArea

object TextOpNumber {
  sealed trait TextOpNumberTrait extends JTextArea {
    private var setNumber: Set[Int] = Set()

    def addNumber(number: Int): Unit = {
      setNumber += number
    }
    def getList: Set[Int] = setNumber
    def displayList(): Unit = {
      for (elem <- setNumber) {
        append(elem+",")
    }}
  }
  case class TextOpNumber() extends TextOpNumberTrait
}
