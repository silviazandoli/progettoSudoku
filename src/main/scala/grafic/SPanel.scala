package grafic

import java.awt.{Dimension, FlowLayout}

import javax.swing.{JButton, JPanel}

import scala.swing.Color

/**
 * This class creates the panels used for the border on the main window.
 */
class SPanel() //construct the sudoku display panel
{
  val pb = new JPanel(); //create the button panel
  val FL = new FlowLayout();
  val SS = new JButton("show list");
  val GBS = new JButton(" Undo ");
  val ES = new JButton(" Easy ");
  val MS = new JButton(" Medium ");

  // this.setLayout(new BorderLayout());
  val HS = new JButton(" Hard ");
  pb.setPreferredSize(new Dimension(ButtonsWidth, DisplayHeight));
  pb.setBackground(WS);
  val CS = new JButton(" Custom Sudoku");
  FL.setVgap(55);
  FL.setHgap(100); //set the flow layout to give  symmetric display
  pb.setLayout(FL);
  private val DisplayWidth = 557 //sudoku display its 557 pixels wide
  //SS.setText()
  //SS.addActionListener(this);
  pb.add(SS);
  private val DisplayHeight = 580 //sudoku display its 580 pixels high
  //GBS.addActionListener(this);
  pb.add(GBS);
  private val ButtonsWidth = 200 //button panel its 200 pixels wide
  // ES.addActionListener(this);
  pb.add(ES);
  private val WS = new Color(0xf5, 0xf5, 0xf5) //White Smoke
  //  MS.addActionListener(this);
  pb.add(MS);
  private val MB = new Color(0x00, 0x00, 0xcd) //Medium blue
  // HS.addActionListener(this);
  pb.add(HS);
  private val P = new Color(0x80, 0, 0x80) //purple blank number
  //CS.addActionListener(this);
  pb.add(CS);
 // FL.add(pb, BorderLayout.WEST);
  //add the push button panel to the display panel

}