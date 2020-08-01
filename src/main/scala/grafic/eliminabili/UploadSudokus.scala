package grafic.eliminabili

import grafic.Sudoku.Sudoku
import grafic.setPuzzleResolt
import resolutionAlgorithm.FullExploration
import scalafx.application
import scalafx.application.JFXApp
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.input.{KeyCode, KeyCodeCombination, KeyCombination}
import scalafx.stage.FileChooser
import scalafx.stage.FileChooser.ExtensionFilter
import sudoku.MatListOperation.initList
import sudoku.SudokuLoad.loadPuzzle
import utility.getPuzzle

import scala.io.Source

//by Zandoli
object UploadSudokus extends JFXApp {

  stage=new application.JFXApp.PrimaryStage {
    title="Menu"
    scene=new Scene(600,300) {
      val menuBar = new MenuBar
      val fileMenu = new Menu("Open Sudoku")

      val startItem=new MenuItem("Start Game")
      startItem.accelerator=new KeyCodeCombination(KeyCode.Y,KeyCombination.ControlDown)

      val openItem = new MenuItem("Open File")
      openItem.accelerator = new KeyCodeCombination(KeyCode.Digit0, KeyCombination.ControlDown)

      val saveItem = new MenuItem("Rename File")
      saveItem.accelerator = new KeyCodeCombination(KeyCode.Digit5, KeyCombination.ControlDown)



      val exitItem = new MenuItem("Exit")
      exitItem.accelerator = new KeyCodeCombination(KeyCode.X, KeyCombination.ControlDown)


      fileMenu.items = List( startItem, openItem, saveItem, new SeparatorMenuItem, exitItem)
      val initGame=new Button("Init Game:")


      menuBar.menus  = List(fileMenu)
      menuBar.prefWidth = 800

      /*val checkMenu = new Menu("Check")
      val check1 = new CheckMenuItem("Check1")
      val check2 = new CheckMenuItem("check2")
      checkMenu.items   = List(check1, check2)

      val radioMenu = new Menu("Radio")
      val radio1 = new RadioMenuItem("Radio1")
      val radio2 = new RadioMenuItem("Radio2")
      val group = new ToggleGroup
      group.toggles = List(radio1, radio2)
      radioMenu.items = List(radio1,radio2)


      val typeMenu = new Menu("Types")
      typeMenu.items = List(checkMenu, radioMenu)

      menuBar.menus  = List(fileMenu, typeMenu)
      menuBar.prefWidth = 600
*/
     /* val menuButton = new MenuButton("Menu Button")
      menuButton.items = List(new MenuItem("Start Game"), new MenuItem("Open File"), new MenuItem("Exit"))

      menuButton.layoutX = 20
      menuButton.layoutY = 50*/

     /* val splitMenuButton = new SplitMenuButton(new MenuItem("Split 1"), new MenuItem("Split 2"))
      splitMenuButton.text = "Split Menu Button"
      splitMenuButton.layoutX = 20
      splitMenuButton.layoutY = 100*/

      val label = new Label("File Opened:")
      label.layoutX = 20
      label.layoutY = 150

     // val initGame=new Button("Start Game")

     /* val contextMenu = new ContextMenu(new MenuItem("Context1"), new MenuItem("Context 2"))
      label.contextMenu = contextMenu*/


      content=List(menuBar,label)
      //content=new Button("ciaoWs")
      //defining handles
      exitItem.onAction=(event:ActionEvent) => sys.exit(0)

      startItem.onAction= (event:ActionEvent)=>{

        val fileChooser=new FileChooser{
          title = "Open Resource File"

          //you can open only file txt
          extensionFilters ++= Seq(
            new ExtensionFilter("Text Files", "*.txt"),

          )

        }
        //you can open multiple sudoku
        val selectedFile= fileChooser.showOpenMultipleDialog(stage)


        selectedFile.foreach(i=>{
          //i.toString

          label.text="Open "+ selectedFile
          loadPuzzle(i.toString)
          initList()
          val sudokuSolver = FullExploration(getPuzzle)
          sudokuSolver.solve(0, 0)

          setPuzzleResolt(sudokuSolver.returnPuzzle())

          val sudoku = Sudoku()
          sudoku.create()
        })
        // loadPuzzle(selectedFile.toString)



        //areaText.
      }

      openItem.onAction= (event:ActionEvent)=>{
        val fileChooser=new FileChooser{
          title = "Open Resource File"

          //you can open only file txt
          extensionFilters ++= Seq(
            new ExtensionFilter("Text Files", "*.txt"),

          )

        }
        //you can open multiple sudoku
        val selectedFile= fileChooser.showOpenDialog(stage)
       // val lines = Source.fromFile("selectedFile").getLines.toList
       /* for (line <- Source.fromFile(selectedFile).getLines) {
          println(line)

        }*/
       val fileContents = Source.fromFile(selectedFile).getLines.mkString
        label.text= fileContents
      }

      saveItem.onAction = (event:ActionEvent) => {
          val fileChooser=new FileChooser
          val selectedFile=fileChooser.showSaveDialog(stage)
          label.text="Save "+selectedFile

      }
    }



    /*exitItem.onAction = (e:ActionEvent)=>System.exit(0)
    openItem.onAction = (e:ActionEvent)=>{
      val fileChooser=new FileChooser
      val selectedFile=fileChooser.showOpenDialog(stage)
      label.text= "Open"+selectedFile


    }
*/
    //save item







  }



}
