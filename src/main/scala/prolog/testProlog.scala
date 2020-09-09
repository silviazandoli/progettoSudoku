package prolog

object testProlog extends App {
  import java.io.FileInputStream

  import alice.tuprolog.Prolog
  import alice.tuprolog.Theory

  val engine = new Prolog
  val t = new Theory (
    "search(E,[E|_]). " + // a space is needed here !
    "search(E,[_|L]):-search(E,L)."
  )

  engine.addTheory(new Theory(new FileInputStream("C:/Users/Lorenzo/Documents/UNIBO-Magistrale/ProvaProlog/clpd.pl")))

  engine.setTheory(t)
  val info = engine.solve("search(1,[1 ,2 ,3]).")
  println("" + info.getSolution)
}
