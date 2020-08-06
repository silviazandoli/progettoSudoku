package grafic

import grafic.Sudoku.Sudoku
import javax.swing.JFileChooser
import resolutionAlgorithm.FullExploration
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle
import utility.getPuzzle
import javax.swing.filechooser.FileNameExtensionFilter
object FileChooserMain extends App {
//TODO
  /*
  1) Quando runno il file deve per forza entrare nella cartella

  2) Fare in modo che quando chiudo il sudoku rimanga l'interfaccia
  */


 /* private def configureFileChooser(fileChooser: FileChooser): Unit = {
    fileChooser.setTitle("View Sudoku")
    //TODO è obbligatorio accedere alla cartella di input
    fileChooser.setInitialDirectory(new File("input"))
    fileChooser.getExtensionFilters.addAll(new FileChooser.ExtensionFilter("All Files .txt", "*.txt*"), new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"))
  }
}

class FileChooserMain extends Application {

  final private val desktop = Desktop.getDesktop

  override def start(stage: Stage): Unit = {
    stage.setTitle("File Chooser Sample")
    val fileChooser = new FileChooser
    val openButton = new Button("Open File")
    val openMultipleButton = new Button("Open Multiple Files")
    val startGame=new Button("Start Game")
    val saveFile=new Button("Save File")



    openButton.setOnAction((e: ActionEvent) => {
      def foo(e: ActionEvent): Unit = {
        FileChooserMain.configureFileChooser(fileChooser)
        val file = fileChooser.showOpenDialog(stage)
        if (file != null) openFile(file)
      }

      foo(e)
    })
    openMultipleButton.setOnAction((e: ActionEvent) => {
      def foo(e: ActionEvent): Unit = {
        FileChooserMain.configureFileChooser(fileChooser)
        val list = fileChooser.showOpenMultipleDialog(stage)
        if (list != null) list.stream.forEach((file: File) => {
          def foo(file: File): Unit = {
            openFile(file)
          }

          foo(file)
        })
      }

      foo(e)
    })

    startGame.setOnAction((e:ActionEvent)=>{
      def foo(e: ActionEvent): Unit = {
        FileChooserMain.configureFileChooser(fileChooser)
        val list = fileChooser.showOpenMultipleDialog(stage)
        if (list != null) list.stream.forEach((file: File) => {
          def foo(file: File): Unit = {

            loadPuzzle(file.toString)
            initList()
            val sudokuSolver = FullExploration(getPuzzle)
            sudokuSolver.solve(0, 0)

            setPuzzleResolt(sudokuSolver.returnPuzzle())

            val sudoku = Sudoku()
            sudoku.create()
          }

          foo(file)
        })
      }

      foo(e)
    })


   /* saveFile.setOnAction((ActionEvent e) => {
      FileChooser fileChooser1 = new FileChooser();
      fileChooser1.setTitle("Save Image");
     // System.out.println(pic.getId());
      File file = fileChooser1.showSaveDialog(stage);
      if (file != null) {
        try {
          ImageIO.write(fromFXImage(pic.getImage(),
            null), "png", file);
        } catch (IOException ex) {
          System.out.println(ex.getMessage());
        }
      }
    })*/

    val inputGridPane = new GridPane
    GridPane.setConstraints(openButton, 0, 1)
    GridPane.setConstraints(openMultipleButton, 1, 1)
    GridPane.setConstraints(startGame,0,2)
    GridPane.setConstraints(saveFile,1,2)
    inputGridPane.setHgap(10)
    inputGridPane.setVgap(10)
    inputGridPane.getChildren.addAll(startGame, openButton, openMultipleButton, saveFile)
    val rootGroup = new VBox(12)
    rootGroup.getChildren.addAll(inputGridPane)
    rootGroup.setPadding(new Insets(12, 12, 12, 12))
    stage.setScene(new Scene(rootGroup))
    stage.show()
  }

  private def openFile(file: File): Unit = {
    EventQueue.invokeLater(() => {
      def foo(): Unit = {
        try desktop.open(file)
        catch {
          case ex: IOException =>
            Logger.getLogger(classOf[FileChooserMain].getName).log(Level.SEVERE, null, ex)
        }
      }

      foo()
    })
  }*/
 def initAndReUpload(): Unit = {
   //val jfc = new JFileChooser("input")
   val jfc = new JFileChooser("input")
   jfc.setMultiSelectionEnabled(true)

  jfc.setAcceptAllFileFilterUsed(false)
   val filter = new FileNameExtensionFilter("Files txt", "txt")
   jfc.addChoosableFileFilter(filter)
   val retValue = jfc.showOpenDialog(null)
   if (retValue == JFileChooser.APPROVE_OPTION) {
     val file = jfc.getSelectedFiles()
     //open one sudoku or multiple sudokus
     file.foreach(i=>{
       println(i)
       loadPuzzle(i.toString)
       initList()

       val sudokuSolver = FullExploration(getPuzzle)
       sudokuSolver.solve(0, 0)

       setPuzzleResolt(sudokuSolver.returnPuzzle())

       val sudoku = Sudoku()
       sudoku.create()
     })

   }
 }

  initAndReUpload()
}