package prolog

import alice.tuprolog._
// libraryDependencies += "it.unibo.alice.tuprolog" % "tuprolog" % "3.3.0"


object Test1 {
  @throws[Exception]
  def main(args: Array[String]): Unit = {
    val engine = new Prolog
    val info = engine.solve("append([1],[2,3],X).")
    System.out.println(info.getSolution)
    // "append([1],[2,3],[1,2,3])"
  }
}
