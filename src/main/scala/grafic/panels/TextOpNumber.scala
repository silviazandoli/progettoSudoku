package grafic.panels

import javax.swing.JTextField

object TextOpNumber {
  sealed trait TextOpNumberTrait extends JTextField {
    private var listNumber: List[Int] = List()

    def addNumber(number: Int): Unit = {listNumber :+= number}
    def getList: List[Int] = listNumber
    def displayList(): Unit = {
      for (elem <- listNumber) {
        setText(""+elem)
        setText(",")
    }}
  }
  case class TextOpNumber() extends TextOpNumberTrait
}
