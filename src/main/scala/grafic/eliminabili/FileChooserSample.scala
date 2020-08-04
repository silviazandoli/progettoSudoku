package grafic.eliminabili



import java.awt.{Desktop, EventQueue}
import java.io.{File, IOException}
import java.util.logging.{Level, Logger}

import grafic.Sudoku.Sudoku
import grafic.setPuzzleResolt
import javafx.application.Application
import javafx.event.ActionEvent
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.{GridPane, VBox}
import javafx.stage.{FileChooser, Stage}
import resolutionAlgorithm.FullExploration
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle
import utility.getPuzzle

object FileChooserSample {


  private def configureFileChooser(fileChooser: FileChooser): Unit = {
    fileChooser.setTitle("View Sudokus")
    fileChooser.setInitialDirectory(new File("input"))
    fileChooser.getExtensionFilters.addAll(new FileChooser.ExtensionFilter("All Files .txt", "*.txt*"), new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"))
  }
}

final class FileChooserSample extends Application {
  final private val desktop = Desktop.getDesktop

  override def start(stage: Stage): Unit = {
    stage.setTitle("File Chooser Sample")
    val fileChooser = new FileChooser
    val openButton = new Button("Open File")
    val openMultipleButton = new Button("Open Multiple Files")
    val startGame=new Button("Start Game")
    val saveFile=new Button("Save File")
    openButton.setOnAction((e: ActionEvent) => {
      def foo(e: ActionEvent) = {
        FileChooserSample.configureFileChooser(fileChooser)
        val file = fileChooser.showOpenDialog(stage)
        if (file != null) openFile(file)
      }

      foo(e)
    })
    openMultipleButton.setOnAction((e: ActionEvent) => {
      def foo(e: ActionEvent) = {
        FileChooserSample.configureFileChooser(fileChooser)
        val list = fileChooser.showOpenMultipleDialog(stage)
        if (list != null) list.stream.forEach((file: File) => {
          def foo(file: File) = {
            openFile(file)
          }

          foo(file)
        })
      }

      foo(e)
    })

    startGame.setOnAction((e:ActionEvent)=>{
      def foo(e: ActionEvent) = {
        FileChooserSample.configureFileChooser(fileChooser)
        val list = fileChooser.showOpenMultipleDialog(stage)
        if (list != null) list.stream.forEach((file: File) => {
          def foo(file: File) = {

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
      def foo() = {
        try desktop.open(file)
        catch {
          case ex: IOException =>
            Logger.getLogger(classOf[FileChooserSample].getName).log(Level.SEVERE, null, ex)
        }
      }

      foo()
    })
  }
}