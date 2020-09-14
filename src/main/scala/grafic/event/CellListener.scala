package grafic.event

import grafic.panels.TextOpNumber.TextOpNumber

trait CellListener {
  val row: Int
  val col: Int

  protected def actionCell(t: TextOpNumber): Int
}
