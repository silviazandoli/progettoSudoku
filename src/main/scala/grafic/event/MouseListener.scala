package grafic.event

import java.awt.Container
import java.awt.event.{MouseAdapter, MouseEvent}

import javax.swing.{JOptionPane, JTextField}
import utility.{matList, puzzle, tfCells}

sealed trait MouseListener extends MouseAdapter {
  val row: Int
  val col: Int
  val container: Container
  val puzzleResolt: Array[Array[Int]]

  //aggiunto evento per cliccare su ogni casella
  override def mousePressed(e: MouseEvent): Unit = {
    selectNumber() //the called method on mouse click
  }

  def selectNumber(): Unit = {
    //println("MatList riga " + row + " colonna " + col + " è " + matList(row)(col))
    println("Puzzle riga " + row + " colonna " + col + " è " + puzzle(row)(col))

    val options = Array[AnyRef]("Insert numbers", "Insert list of numbers", "see matlist")
    val n = JOptionPane.showOptionDialog(null, "How to proceed?", "User mode", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options(2))
    println("n: " + n)
    n match {
      case 0 => {
        val number = JOptionPane.showInputDialog("Inserisci il numero per la riga: " + row + " e la colonna: " + col)
        tfCells(row)(col).addActionListener(WriteOnCell(row, col, container, puzzleResolt, number))
      }
      case 1 => {
        val mylist = JOptionPane.showInputDialog("inserisci la lista di numeri: ")
        println(mylist)
        var myList:Array[String] = new Array[String](9)
        myList= mylist.split(",")
        //myList(row)(col) = mylist.split(",")
      }
      case _ => JOptionPane.showMessageDialog(null,"MatList per la riga: " + row + " e la colonna: " + col + " è " + matList(row)(col))
    }
  }
}

object MouseListener {
  def apply(row: Int, col: Int, cp: Container, puzzleResolt: Array[Array[Int]]): MouseListener = MouseListenerImplements(row, col, cp, puzzleResolt)

  private case class MouseListenerImplements(row: Int, col: Int, cp: Container, puzzleResolt: Array[Array[Int]]) extends MouseListener{
    val container: Container = cp
  }
}
