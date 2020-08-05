package grafic.panels

import javax.swing.JTextField

object TextOpNumber {
  sealed trait TextOpNumberTrait extends JTextField {
    private var setNumber: Set[Int] = Set()

    def addNumber(number: Int): Unit = {setNumber += number}
    def getList: Set[Int] = setNumber
    def displayList(): Unit = {
      for (elem <- setNumber) {
        setText(""+elem)
        setText(",")
    }}
  }
  case class TextOpNumber() extends TextOpNumberTrait
}
