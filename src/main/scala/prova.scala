object prova extends App {

  final def printList[T](f: T => Unit, list: List[T]): Unit = list match {
    case h :: t => (f(h), printList(f, t))
    case _ =>
  }

  printList(print, List(1,2,3,4))
}
