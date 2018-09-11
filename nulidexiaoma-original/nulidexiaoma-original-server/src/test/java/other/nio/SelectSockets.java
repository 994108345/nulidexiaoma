package other.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

import static other.jvm.Overload.sayHello;

/**
 * Created by 99410 on 2018/8/30.
 */
public class SelectSockets {
    public static int PORT_NUMBER = 1234;
    public static void main(String[] argv) throws Exception {
        new SelectSockets().go(argv);
    }
    public void go(String[] argv) throws Exception {
        int port = PORT_NUMBER;
        if (argv.length > 0) { // Override default listen port
            port = Integer.parseInt(argv[0]);
        }
        System.out.println("Listening on port" + port);
        // Allocate an unbound server socket channel 创建一个新的选择通道
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
                    ServerSocketChannel server =
                            (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();//若通道就绪，调用accept会返回就绪的通道
                    registerChannel(selector, channel,
                            SelectionKey.OP_READ);
                    sayHello(channel);
                }
                // Is there data to read on this channel? //在通道上是否有数据可以读取
                if (key.isReadable()) {
                    readDataFromSocket(key);
                }
                // Remove key from selected set; it's been handled  //从已选择键的集合上移除该键，他已经被注销。
                it.remove();
            }
        }
    }
// ----------------------------------------------------------
    /** 将通道注册在选择器上和操作
     * Register the given channel with the given selector for the given
     * operations of interest
     */
    protected void registerChannel(Selector selector,
                                   SelectableChannel channel, int ops) throws Exception {
        if (channel == null) {
            return; // could happen 可能发生
        }
        // Set the new channel nonblocking 设置新通道为非阻塞模式
        channel.configureBlocking(false);
        // Register it with the selector 注册到选择器上
        channel.register(selector, ops);
    }
    // ----------------------------------------------------------
    // Use the same byte buffer for all channels. A single thread is
    // servicing all the channels, so no danger of concurrent acccess.
    // 所有的通道用一样的字节流，一个单线程服务于所有的通道，所以对于并发请求的是无危险。
    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
    /**
     * Sample data handler method for a channel with data ready to read.
     * 带有准备被读取数据的一个通道的样本数据处理方法
     * @param key
     * A SelectionKey object associated with a channel determined by
     * the selector to be ready for reading. If the channel returns
        一个已选择键集合对象与一个由选择器去读和被读的通道之间有关系
     * an EOF condition, it is closed here, which automatically
     * invalidates the associated key. The selector will then
     * de-register the channel on the next select call.
     */
//    如果通道返回一个EOF条件，他是关闭的，而且是自动的。验证和有关系的键，这个选择器然后回注册通道给下一个请求的选择器
    protected void readDataFromSocket(SelectionKey key) throws Exception {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        buffer.clear(); // Empty buffer
        // Loop while data is available; channel is nonblocking
        while ((count = socketChannel.read(buffer)) > 0) {
            buffer.flip(); // Make buffer readable
            // Send the data; don't assume it goes all at once
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            // WARNING: the above loop is evil. Because
            // it's writing back to the same nonblocking
            // channel it read the data from, this code can
            // potentially spin in a busy loop. In real life
            // you'd do something more useful than this.
            buffer.clear(); // Empty buffer
        }
        if (count < 0) {
            // Close channel on EOF, invalidates the key
            socketChannel.close();
        }
    }
}
