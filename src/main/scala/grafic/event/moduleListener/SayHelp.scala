package grafic.event.moduleListener

/**
 * Made by Antonelli
 */

protected[event] object SayHelp {
  import grafic.panels.TextOpNumber.TextOpNumber
  import resolutionAlgorithm.FullExploration
  import utility.getPuzzle

  /**
   * @param row of the cell
   * @param col of the cell
   * @param t the cell
   * */

  def sayHelp(row: Int,col: Int, t: TextOpNumber): Unit = {
    val solver = FullExploration(getPuzzle)
    solver.solve(0, 0)
    val finish = solver.returnPuzzle()
    val number = finish(row)(col)
    t.setEditable(true)
    //println(number)
    InsertNumber.writeNumber(row, col, number, t)
  }
}
