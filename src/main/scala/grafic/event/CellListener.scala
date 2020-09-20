package grafic.event

import grafic.panels.TextOpNumber.TextOpNumber

/**
 * Template Method Made by Pacini
 */
trait CellListener {
  val row: Int
  val col: Int

  /**
   * template method
   * @param t the cell
   * @return the user's action
   */
  protected def actionCell(t: TextOpNumber): Int
}
