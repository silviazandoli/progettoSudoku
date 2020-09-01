package grafic

object FileChooser extends App {

 /* def uploadLoad():Unit={
   /* import grafic.HelpersFile._
    val jfl="temp".filechooser()
    val retValue=jfl.open()

    if (retValue == JFileChooser.APPROVE_OPTION) {
      val file = jfc.multipleFiles()
      file.foreach(processFile)*/
  }

  def initAndReUpload(modality:String): Unit = {
    import grafic.HelpersFile._
    //val jfc = new JFileChooser("input")
    val jfc=modality.filechooser()
    val retValue=jfc.open()

    if (retValue == JFileChooser.APPROVE_OPTION) {
      val file = jfc.multipleFiles()
      file.foreach(processFile)
      //open one sudoku or multiple sudokus


    }
    def processFile(f: File) = {
      println(f)
      loadPuzzle(f.toString)
      initList()

      val sudokuSolver = FullExploration(getPuzzle)
      sudokuSolver.solve(0, 0)

      setPuzzleResolt(sudokuSolver.returnPuzzle())

      val sudoku = Sudoku()
      sudoku.create()

    }
  }
  
  initAndReUpload("input")
}

//using of the pattern implicit
object HelpersFile {

  implicit class MyStringHelper(str: String) {
    def filechooser() = {
      val jfc = new JFileChooser(str)
      jfc.setMultiSelectionEnabled(true)

      jfc.setAcceptAllFileFilterUsed(false)
      val filter = new FileNameExtensionFilter("Files txt", "txt")
      jfc.addChoosableFileFilter(filter)
      jfc

    }
  }

  implicit class MyFileChooserHelper(jfc: JFileChooser) {
    def open() = jfc.showOpenDialog(null)

    //def multipleFiles() = jfc.getSelectedFiles()
    def multipleFiles() = jfc.getSelectedFiles()
  }*/

}
