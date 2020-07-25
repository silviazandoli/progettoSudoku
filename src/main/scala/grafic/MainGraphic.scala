package grafic

import javax.swing.JFileChooser
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle

object MainGraphic extends App {
  /**uploading multiple Sudoku by Zandoli
   *
   */
  val jfc = new JFileChooser("input")
  val retValue = jfc.showOpenDialog(null)
  if (retValue == JFileChooser.APPROVE_OPTION) {
    val file = jfc.getSelectedFile()
    println(file.getAbsolutePath)
    loadPuzzle(file.getAbsolutePath)
    initList()
    val sudoku = new Sudoku()
    sudoku.create()
  }
  /*JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
		}
*/

}
