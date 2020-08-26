package grafic

package object util {
  import java.awt.{Color, Font}
  import utility.dimSudoku

  val SUBGRID_SIZE = 3 // Size of the sub-grid

  val MATRIX_CELL_SIZE = 30 // Cell width/height in pixels
  val CELL_SIZE = 70 // Cell width/height in pixels

  val MATRIX_WIDTH: Int = MATRIX_CELL_SIZE * dimSudoku // 60 x 9 = 540
  val MATRIX_HEIGHT: Int = MATRIX_CELL_SIZE * dimSudoku

  val CANVAS_WIDTH: Int = CELL_SIZE * dimSudoku // 70 x 9 = 630
  val CANVAS_HEIGHT: Int = CELL_SIZE * dimSudoku

  val OPEN_CELL_BGCOLOR: Color = Color.YELLOW
  val OPEN_CELL_TEXT_YES = new Color(0, 255, 0) // RGB

  val OPEN_CELL_TEXT_NO: Color = Color.RED
  val CLOSED_CELL_BGCOLOR: Color = Color.LIGHT_GRAY
  val CLOSED_CELL_TEXT: Color = Color.BLACK
  val FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20)
  val FONT_MATLIST = new Font("Monospaced", Font.ITALIC, 10)

  val FONT_MINILIST = new Font("Monospaced", Font.ITALIC, 9)

  val NUMBER = "Insert numbers"
  val NUMBER_LIST = "Insert list of numbers"

  val factSecond = 1000

  var score = 0
}