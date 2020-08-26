package grafic.panels

import javax.swing.JTextArea

object TextOpNumber {
  sealed trait TextOpNumberTrait extends JTextArea {
    private var setNumber: Set[Int] = Set()

    def addNumber(number: Int): Unit = {
      setNumber += number
    }
    def removeNumber(number: Int): Unit = {
      setNumber -= number
    }
    def getList: Set[Int] = setNumber
    def displayList(): Unit = {
      setText(" ")
      for (elem <- setNumber) {
        append(elem+",")
      }

      val text = this.getText

      if (!text.isEmpty) {
        val len = this.getText.length
        this.replaceRange(" ", len - 1, len)
      }
    }
  }
  case class TextOpNumber() extends TextOpNumberTrait
}
