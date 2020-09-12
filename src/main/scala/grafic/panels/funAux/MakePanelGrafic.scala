package grafic.panels.funAux

/**
 *  Made by Pacini
 *  set dimension, color and coordinates of each component
 *  of panel of the graphic (left panel)
 */
private[panels] object MakePanelGrafic {
  import java.awt.event.ActionEvent
  import java.awt.{Color, Dimension}

  import grafic.panels._
  import grafic.util.FONT_MATLIST
  import grafic.{cp, showNumberList, textTime}

  def setDimension(): Unit = {
    pb.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight)) // dim
    pb.setBackground(WS)

    FL.setVgap(55)
    FL.setHgap(100) //set the flow layout to give  symmetric display
    pb.setLayout(FL)
  }

  def showNumberListMake(): Unit = {
    showNumberList.setForeground(Color.WHITE)
    showNumberList.setBackground(Color.BLUE)
    showNumberList.setFont(FONT_MATLIST)
    showNumberList.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight))

    pb.add(showNumberList)
  }

  def startStopButtonMake(): Unit = {
    startStopButton.setBackground(Color.green)
    startStopButton.addActionListener((_: ActionEvent) => AuxFunctSPanel.startStop())

    pb.add(startStopButton)
  }

  def addButtons(): Unit = {
    pb.add(refreshList)
    textTime.setPreferredSize(new Dimension(ButtonsWidth, ButtonsHeight*2)) // dim
    pb.add(textTime)
    saveButton.addActionListener((_: ActionEvent) => SaveLoad.save())
    pb.add(saveButton)

    puzzleResolve.addActionListener((_: ActionEvent) => Resolve.resolve(cp))
    pb.add(puzzleResolve)

    /*adviceButton.addActionListener((_: ActionEvent) => Advice.suggerisci())
    pb.add(adviceButton)*/
  }
}
