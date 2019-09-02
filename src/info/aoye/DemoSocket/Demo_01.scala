package info.aoye.DemoSocket

import java.io.{DataOutputStream, ObjectOutputStream}
import java.net.{InetAddress, Socket}

object Demo_01 extends App {
  val ia = InetAddress.getByName("localhost")
  val socket = new Socket(ia ,8484)

  val out = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream))
}
