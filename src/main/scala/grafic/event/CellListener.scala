package grafic.event

import grafic.panels.TextOpNumber.TextOpNumber

/**
 * Template Method Made by Pacini
 */
trait CellListener {
  val row: Int
  val col: Int

  protected def actionCell(t: TextOpNumber): Int
}
