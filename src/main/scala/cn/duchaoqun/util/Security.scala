package cn.duchaoqun.util

import java.io.{File, FileInputStream}
import java.math.BigInteger
import java.security.{DigestInputStream, MessageDigest}

object Security {
  /**
    * 计算文件的 MD5 值
    * @param path 文件的路径
    */
  def computeFileMD5Hash(path: String): String ={
    val buffer = new Array[Byte](8192)
    val md5 = MessageDigest.getInstance("MD5")
    val dis = new DigestInputStream(new FileInputStream(new File(path)), md5)
    try {
      while (dis.read(buffer) != -1)
      {}
    }
    finally {
      dis.close()
    }
    md5.digest.map("%02x".format(_)).mkString
  }

  /**
    * 计算字符串的 MD5 值
    * @param str 待计算的字符串
    * @return
    */
  def computeStringMD5Hash(str:String): String = {
    val md5 = MessageDigest.getInstance("MD5")
    val digest = md5.digest(str.getBytes())
    val bigInt = new BigInteger(1, digest)
    val hashedString = bigInt.toString(16)
    hashedString
  }
}
