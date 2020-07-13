package grafic

import java.awt.Button

/*
class ButtonWithCallbacks(val label: String,
                                  val clickedCallbacks: List[() => Unit]) extends Button { // extends Widget {

  require(clickedCallbacks != null, "La lista di callback non può essere nulla!")

  def this(label: String, clickedCallback: () => Unit) =
    this(label, List(clickedCallback))

  def this(label: String) = {
    this(label, Nil)
    println("Attenzione: il pulsante non ha callback per i clic!")
  }

  def click() = {
    // ... logica per mostrare visivamente il clic sul pulsante ...
    clickedCallbacks.foreach(f => f())
  }
}

object ButtonApply extends App {
  //ButtonWithCallbacks("", Nil)
}
 */
