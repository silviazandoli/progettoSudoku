package grafic.panels

/**
 * Made by Pacini
 */
object TextOpNumber {
  import javax.swing.JTextArea

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
      setText("")
      for (elem <- setNumber) {
        append(elem + ",")
      }

      val text = this.getText
      setText(text)

      if (!text.isEmpty) {
        val len = this.getText.length
        this.replaceRange(" ", len - 1, len)
      }
      setVisible(true)
    }

    /*
    def removeFromList(num:Int):Unit={
      removeNumber(num)
      val text = this.getText
      text.replace(num+",","")
    }
     */
  }
  case class TextOpNumber() extends TextOpNumberTrait
}
