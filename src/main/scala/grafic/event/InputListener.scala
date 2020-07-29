package grafic.event

import java.awt.event.{ActionEvent, ActionListener}

import javax.swing.JTextField
import utility.{dimSudoku, tfCells}

// The game board composes of 9x9 JTextFields,
// each containing String "1" to "9", or empty String
//private JTextField[][] tfCells = new JTextField[GRID_SIZE][GRID_SIZE];
class InputListener extends ActionListener {
  override def actionPerformed(e: ActionEvent): Unit = { // All the 9*9 JTextFileds invoke this handler. We need to determine
    // which JTextField (which row and column) is the source for this invocation.
    var rowSelected = -1
    var colSelected = -1
    // Get the source object that fired the event
    val source = e.getSource.asInstanceOf[JTextField]
    // Scan JTextFileds for all rows and columns, and match with the source object
    var found = false
    var row = 0
    while ( {
      row < dimSudoku && !found
    }) {
      var col = 0
      while ( {
        col < dimSudoku && !found
      }) {
        if (tfCells(row)(col) eq source) {
          rowSelected = row
          colSelected = col
          found = true // break the inner/outer loops

        }

        col += 1
      }

      row += 1
    }
    /*
                 * [TODO 5]
                 * 1. Get the input String via tfCells[rowSelected][colSelected].getText()
                 * 2. Convert the String to int via Integer.parseInt().
                 * 3. Assume that the solution is unique. Compare the input number with
                 *    the number in the puzzle[rowSelected][colSelected].  If they are the same,
                 *    set the background to green (Color.GREEN); otherwise, set to red (Color.RED).
                 *//*
                 * [TODO 6] Check if the player has solved the puzzle after this move.
                 * You could update the masks[][] on correct guess, and check the masks[][] if
                 * any input cell pending.
                 */
  }
}
