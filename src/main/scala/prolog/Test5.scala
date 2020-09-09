package prolog

import alice.tuprolog._


object Test5 {
  @throws[Exception]
  def main(args: Array[String]): Unit = {
    val engine = new Prolog
    val t = new Theory("search(E,[E|_]). " + // a space is needed here!
      "search(E,[_|L]):-search(E,L).")
    // engine.setTheory(new FileInputStream("file.pl"));
    engine.setTheory(t)
    val info = engine.solve("search(1,[1,2,3]).")
    System.out.println("" + info.getSolution) // search(1,[1,2,3])

  }
}

