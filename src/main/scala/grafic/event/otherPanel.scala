package grafic.event

import java.awt.Dimension
import java.awt.event.{MouseAdapter, MouseEvent}

import grafic.SPanel.SPanelTrait
import javax.swing.{BoxLayout, JButton, JPanel, JTextField}
import utility.{matList, puzzle}

sealed trait otherPanel extends MouseAdapter {
  val row: Int
  val col: Int

  case class SPanel(dim: Dimension) extends SPanelTrait

  //aggiunto evento per cliccare su ogni casella
  override def mousePressed(e: MouseEvent): Unit = {
    val pb = new JPanel()
    val btnPanel = new JButton("ciao")
    val insert = new JButton("Inserisci il valore:")
    val list = new JButton("push me")
    val mylist = new JButton("push me")
    btnPanel.add(insert)
    btnPanel.add(list)
    btnPanel.add(mylist)
    insert.addActionListener(l => {
      println("Hello11")
    })
    list.addActionListener(l => {
      println("Hello22")
    })
    mylist.addActionListener(l => {
      println("Hello33")
    })
    pb.add(btnPanel)
  }
  //println("MatList riga " + row + " colonna " + col + " è " + matList(row)(col))
  //println("Puzzle riga " + row + " colonna " + col + " è " + puzzle(row)(col))
}

object otherPanel {
  def apply(row: Int, col: Int): otherPanel = otherPanelImplements(row: Int, col: Int)

  private case class otherPanelImplements(row: Int, col: Int) extends otherPanel
}


/*

val btnPanel = new JPanel
    btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS))
    val b1 = new JButton("push me")
    val b2 = new JButton("push me")
    val b3 = new JButton("push me")
    btnPanel.add(b1)
    btnPanel.add(b2)
    btnPanel.add(b3)
    b1.addActionListener(l => {
      println("Hello11")
    })
    b2.addActionListener(l => {
      println("Hello22")
    })
    b3.addActionListener(l => {
      println("Hello33")
    })
  }


val b = new JButton("push me")
      pb.add(b)

      b.addActionListener(l => {
        println("Hello!!")
        import javax.swing.JButton
        import javax.swing.JButton
        val str = "ciao"
        def actionPerformed(str: String): Unit = {
          val b1 = new JButton("push me")
          val b2 = new JButton("push me")
          val b3 = new JButton("push me")
          b.add(b1)
          b.add(b2)
          b.add(b3)
          b.add(new JButton(str))
          b.validate
        }
        actionPerformed("ciao")
        import javax.swing.JFrame
        import javax.swing.JPanel
        import java.awt.BorderLayout
        import java.awt.Dimension
        val f: JFrame = new JFrame("Test")
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        f.add(new JPanel() { //arbitrary filler
          override def getPreferredSize: Dimension = {
            return new Dimension(320, 240)
          }
        })
        f.add(createButtonPanel, BorderLayout.EAST)
        f.pack()
        f.setLocationRelativeTo(null)
      })
      private def createButtonPanel = {
        val btnPanel = new JPanel
    btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS))
    val b1 = new JButton("push me")
    val b2 = new JButton("push me")
    val b3 = new JButton("push me")
    btnPanel.add(b1)
    btnPanel.add(b2)
    btnPanel.add(b3)
      }

*/