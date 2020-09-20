package grafic.util

/**
 * Made by Pacini
 */
object FileWork {
  import java.io.File

  /**
   * @param f the file to write
   */
  implicit class FileMonads(f: File) {
    def remove(): Unit = if (f.exists()) f.delete()
    def create(): Boolean = f.createNewFile()
  }

  /**
   * delete tmp.txt
   */
  def deleteFile(): Unit =
    println("file deleted = " + new File("temp/tmp.txt").remove())

  /**
   *
   * @return the file to store the game situation
   */
  def createFile(): Boolean = new File("temp/tmp.txt").create()
}
