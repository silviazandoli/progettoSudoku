package grafic.util

object FileWork {
  import java.io.File

  implicit class FileMonads(f: File) {
    def remove(): Unit = if (f.exists()) f.delete()
    def create(): Boolean = f.createNewFile()

  }

  def deleteFile(): Unit =
    println("file deleted = " + new File("temp/tmp.txt").remove())

  def createFile(): Boolean = new File("temp/tmp.txt").create()
}
