// Most Common Word

import scala.collection.mutable._

object Solution {
  def toWords(paragraph: String, word: String): List[String] = paragraph match {
    case "" => if (word != "") List(word.toLowerCase) else Nil
    case _ => {
      if (paragraph.head.isLetter) {
        toWords(paragraph.tail, word + paragraph.head)
      } else {
        if (word != "") {
          List(word.toLowerCase) ++ toWords(paragraph.tail, "")
        } else {
          toWords(paragraph.tail, word)
        }
      }
    }
  }

  def mostCommonWord(paragraph: String, banned: Array[String]): String = {
    var memo = new HashMap[String, Int]() {
      override def default(key: String) = 0
    }
    for (word <- banned) {
      memo += (word -> -1)
    }

    val words = toWords(paragraph, "")
    var maxCount = -1
    var maxWord = ""
    for (word <- words) {
      if (memo(word) != -1) {
        val count = memo(word) + 1
        if (count >= maxCount) {
          maxCount = count
          maxWord = word
        }
        memo(word) = count + 1
      }
    }
    maxWord
  }
}