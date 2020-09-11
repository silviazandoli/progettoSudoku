package prolog

object sudokuProlog extends App {
  import java.io.FileInputStream

  import alice.tuprolog.Prolog
  import alice.tuprolog.Theory

  val engine = new Prolog

  engine.addTheory(new Theory(new FileInputStream("C:/Users/Lorenzo/Documents/UNIBO-Magistrale/ProvaProlog/NuovoSudoku.pl")))

  val info = engine.solve("sudoku(1, 9, 6, 4, 7, 8, 3, 2, 5,\n        3, 8, 5, 2, 6, 1, 7, 4, 9,\n        4, 2, 7, 5, 3, 9, 8, 1, 6,\n        8, 3, 2, 6, 5, 4, 1, 9, 7,\n        6, 1, 9, 8, 2, 7, 5, 3, 4,\n        7, 5, 4, 9, 1, 3, 6, 8, 2,\n        2, 7, 8, 1, 4, 6, 9, 5, 3,\n        9, 4, 3, 7, 8, 5, 2, 6, 1,\n        5, 6, 1, 3, 9, 2, 4, 7, _).")
  println("" + info.getSolution)
}
