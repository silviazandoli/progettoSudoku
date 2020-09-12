package prolog

object sudokuProlog extends App {
  import java.io.FileInputStream

  import alice.tuprolog.Prolog
  import alice.tuprolog.Theory

  val engine = new Prolog

  // add theory from a file
  engine.addTheory(new Theory(new FileInputStream("prolog/sudokuProlog.pl")))

  val info = engine.solve("sudoku(1, 9, 6, 4, 7, 8, 3, 2, 5,3, 8, 5, 2, 6, 1, 7, 4, 9,4, 2, 7, 5, 3, 9, 8, 1, 6,8, 3, 2, 6, 5, 4, 1, 9, 7,6, 1, 9, 8, 2, 7, 5, 3, 4,7, 5, 4, 9, 1, 3, 6, 8, 2,2, 7, 8, 1, 4, 6, 9, 5, 3,9, 4, 3, 7, 8, 5, 2, 6, 1,5, 6, 1, 3, 9, 2, 4, 7,_).")
  println("" + info.getSolution)
}
