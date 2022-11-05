package org.example;

import java.io.IOException;
import java.net.*;

public class MainUDP {
    public static void main(String[] args) throws IOException {

                DatagramSocket socket = new DatagramSocket(12345);
                // 2.创建数据报，用于接收客户端发送的数据
                byte[] data = new byte[1024];// 创建字节数组，指定接收的数据包的大小
                DatagramPacket packet = new DatagramPacket(data, data.length);
                System.out.println("****服务器端已经启动，等待客户端发送数据");
                socket.receive(packet);// 此方法在接收到数据报之前会一直阻塞
                // 4.读取数据
                String info = new String(data, 0, packet.getLength());
                System.out.println("我是服务器，客户端说：" + info);

                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                byte[] data2 = "欢迎您!".getBytes();
                // 2.创建数据报，包含响应的数据信息
                DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
                // 3.响应客户端
                socket.send(packet2);
                // 4.关闭资源
                socket.close();
    }
}
