package other.nio;

import org.bson.ByteBuf;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

import static other.jvm.Overload.sayHello;

/**
 * Created by 99410 on 2018/9/4.
 */
public class SelectKeyTest {
    public static int PORT_NUMBER = 1234;
    public static void main(String[] argv) throws Exception {
        new SelectSockets().go(argv);
    }
    public void go(String[] argv) throws Exception {
        int port = PORT_NUMBER;
        System.out.println("Listening on port" + port);
        // 创建一个新的选择通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        // Get the associated ServerSocket to bind it with  获得相关的socket对象
        ServerSocket serverSocket = serverChannel.socket();
        // Create a new Selector for use below 创建一个新的选择器
        Selector selector = Selector.open();
        // Set the port the server channel will listen to 将端口与socket对象绑定起来
        serverSocket.bind(new InetSocketAddress(port));
        // Set nonblocking mode for the listening socket  设定成非阻塞模式
        serverChannel.configureBlocking(false);
        // Register the ServerSocketChannel with the Selector 将通道注册到选择器上
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            // This may block for a long time. Upon returning, the这个可能阻塞很长时间
            // selected set contains keys of the ready channels. 选择器包含通道已经准备就绪的集合
            int n = selector.select();
            if (n == 0) {
                continue; // nothing to do没有准备就绪的通道，继续
            }
            // Get an iterator over the set of selected keys 获取一个选择键集合的迭代器
            Iterator it = selector.selectedKeys().iterator();
            // Look at each key in the selected set 查看已选择集合中的每一个键
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                // Is a new connection coming in?  键是否就绪
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();//若通道就绪，调用accept会返回就绪的通道
                    /*serverChannel.register(selector, channel, SelectionKey.OP_READ);
                    sayHello(channel);*/
                }
                // Is there data to read on this channel? //在通道上是否有数据可以读取
                if (key.isReadable()) {
                   /* readDataFromSocket(key);*/
                }
                // Remove key from selected set; it's been handled  //从已选择键的集合上移除该键，他已经被注销。
                it.remove();
            }
        }
    }
}
