package grafic.panels

object TextOpNumber {
  import javax.swing.JTextArea

  sealed trait TextOpNumberTrait extends JTextArea {
    private var setNumber: Set[Int] = Set()

    def addNumber(number: Int): Unit = {
      setNumber += number
    }
    def removeNumber(number: Int): Unit = {
      System.out.println("-- elimino il numero "+ number)
      setNumber -= number
      System.out.println("-- rimane "+ setNumber)
    }
    def getList: Set[Int] = setNumber

    def displayList(): Unit = {
      setText("")
      System.out.println("LA SETNUMBER prima del for È "+ setNumber)
      for (elem <- setNumber) {
        append(elem + ",")
      }

      val text = this.getText
      setText(text)
      System.out.println("text "+ text)

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
