package other.nio;

import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.ShortBuffer;
import java.nio.channels.*;

/**
 * Created by 99410 on 2018/8/28.
 */
public class Nio {
    @Test
    public void bufferTest() throws IOException, InterruptedException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        FileInputStream input = new FileInputStream("FileTest.java");
        FileChannel channel = input.getChannel();
        MappedByteBuffer mapBuffer = channel.map (FileChannel.MapMode.READ_ONLY, 0, channel.size());
        //mapBuffer.load();
        Thread.sleep(1000*1);
        for (int i = 0;i<mapBuffer.limit(); i++) {
            System.out.println(mapBuffer.get(i));
        }
    }

    @Test
    public void testDemo(){
        int a = 1&8;
        if(a!=0){
            System.out.println("ok");
        }else{
            System.out.println("false");
        }
    }
    @Test
    public void createBuffer(){
        //我创建了一个容量为100的穿冲区，此时psition为0，limit为100.mark还没定义，默认为-1
        CharBuffer charBuffer = CharBuffer.allocate(100);
        charBuffer.put('1');
        charBuffer.put('2');
        charBuffer.put('3');

        System.out.println("容量:"+charBuffer.capacity());
        System.out.println("上限:" + charBuffer.limit());
        System.out.println("标记:" + charBuffer.mark());
        System.out.println("位置:" + charBuffer.position());


    }
    @Test
    public void flipTest(){
        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.put('1');
        charBuffer.put('2');
        charBuffer.put('3');
        charBuffer.flip();
        for (int i = 0; i < charBuffer.limit() ;i++) {
            System.out.println(charBuffer.get());
        }
    }
    @Test
    public void rewindTest(){
        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.put('1');
        charBuffer.put('2');
        charBuffer.put('3');
        System.out.println("rewind()前-上限:" + charBuffer.limit());
        System.out.println("rewind()前-位置:" + charBuffer.position());
        charBuffer.rewind();
        System.out.println("rewind()后-上限:" + charBuffer.limit());
        System.out.println("rewind()后-位置:" + charBuffer.position());
    }
    @Test
    public void remainingTest(){
        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.put('1');
        charBuffer.put('2');
        charBuffer.put('3');
        charBuffer.mark();
        System.out.println("前容量:"+charBuffer.capacity());
        System.out.println("前上界:" + charBuffer.limit());
        System.out.println("前标记:" + charBuffer.mark());
        System.out.println("前位置:" + charBuffer.position());
        charBuffer.clear();
        System.out.println("容量:"+charBuffer.capacity());
        System.out.println("上限:" + charBuffer.limit());
        System.out.println("标记:" + charBuffer.mark());
        System.out.println("位置:" + charBuffer.position());
        CharBuffer buffer = (CharBuffer) charBuffer.mark();
        System.out.println(buffer);
    }

    @Test
    public void compactTest(){
        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.put('1');
        charBuffer.put('2');
        charBuffer.put('3');
        charBuffer.put(7,'7');
        System.out.println("前容量:"+charBuffer.capacity());
        System.out.println("前上界:" + charBuffer.limit());
        System.out.println("前位置:" + charBuffer.position());
        charBuffer.compact();
        System.out.println("容量:"+charBuffer.capacity());
        System.out.println("上限:" + charBuffer.limit());
        System.out.println("位置:" + charBuffer.position());
    }
    @Test
    public void equalsTest(){
        CharBuffer charBuffer1 = CharBuffer.allocate(10);
        charBuffer1.put('1');
        charBuffer1.put('2');
        charBuffer1.put('9');
        charBuffer1.put(4,'6');
        CharBuffer charBuffer2 = CharBuffer.allocate(9);
        charBuffer2.put('1');
        charBuffer2.put('2');
        charBuffer2.put(8,'6');
        charBuffer2.put(7,'6');
        charBuffer2.put(6,'9');
        System.out.println(charBuffer1.equals(charBuffer2));
        System.out.println(charBuffer1.compareTo(charBuffer2));
    }
    @Test
    public void getBatchTest(){
        CharBuffer charBuffer1 = CharBuffer.allocate(4);
        charBuffer1.put('1');
        charBuffer1.put('2');
        int remain = charBuffer1.remaining();

        char[] charArr = {'1'};
        int length = charArr.length;
        if(remain > length){
            charBuffer1.put(charArr);
        }else{
            System.out.println(charBuffer1);
        }
        System.out.println(charBuffer1);
    }
    @Test
    public void copyTest(){
        char[] charArr = {'1','2','3',0,0};
        CharBuffer charBuffer1 = CharBuffer.wrap(charArr);
        charBuffer1.position(3);
        CharBuffer charBuffer2 = charBuffer1.slice();
        charBuffer2.put('a');
        charBuffer2.put('b');
        charBuffer2.put('c');
        System.out.println("");
    }
    @Test
    public void direcTest(){
        byte[] byteArr =new byte[10];
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArr);
        System.out.println(byteBuffer1.isDirect());

        ByteBuffer byteBuffer2 = ByteBuffer.allocate(10);
        System.out.println(byteBuffer2.isDirect());

        ByteBuffer byteBuffer4 = ByteBuffer.allocateDirect(10);
        System.out.println(byteBuffer4.isDirect());

        ByteBuffer byteBuffer3 = byteBuffer4.slice();
        System.out.println(byteBuffer3.isDirect());
    }
    @Test
    public void createTest1(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        byte[] b ={1,2,3,12,5,4};
        byteBuffer.put(b);
        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        shortBuffer.put((short) 122);
        System.out.println(shortBuffer);
    }
    @Test
    public void get1(){
        byte[] b ={1,2,3,12,5,4};
        ByteBuffer byteBuffer = ByteBuffer.wrap(b);
        byteBuffer.put(b);
    }
    @Test
    public void demo1(){
        byte[] b ={1,2,3,12,5,4,12,12,45,78};
        ByteBuffer byteBuffer = ByteBuffer.wrap(b);
        byte[] c = new byte[5];
        byteBuffer.get(c);
        System.out.println();
    }

    @Test
    public void createChannelTest() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("F:\\message\\测试io文件\\read-channel.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\message\\测试io文件\\write-cahnnel.txt");
        /*读通道*/
        ReadableByteChannel source = Channels.newChannel (fileInputStream);
        /*写通道*/
        WritableByteChannel dest = Channels.newChannel (fileOutputStream);
        /*创建直接字节缓冲区*/
        ByteBuffer buffer = ByteBuffer.allocateDirect (16);
        /*每次从通道里读出数据，存到缓冲区里*/
        while (source.read (buffer) != -1) {
            /*翻转*/
            buffer.flip( );
            /*将缓冲区的数据写入写通道里*/
            dest.write (buffer);
            /*压缩*/
            buffer.compact( );
        }
        /*翻转*/
        buffer.flip( );
        /*这里是为了确定缓冲区的数据是否全部已经写入通道*/
        while (buffer.hasRemaining( )) {
            dest.write (buffer);
        }

    }
    @Test
    public void copyChannelTest()throws IOException{
        FileInputStream fileInputStream = new FileInputStream("F:\\message\\测试io文件\\read-channel.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\message\\测试io文件\\write-cahnnel.txt");
        /*读通道*/
        ReadableByteChannel source = Channels.newChannel (fileInputStream);
        /*写通道*/
        WritableByteChannel dest = Channels.newChannel (fileOutputStream);
        /*创建直接字节缓冲区*/
        ByteBuffer buffer = ByteBuffer.allocateDirect (16);
        while (source.read (buffer) != -1) {
            /*翻转，准备被填充*/
            buffer.flip( );
            /*确定缓冲区是否被排干*/
            while (buffer.hasRemaining( )) {
                dest.write (buffer);
            }
            /*清空缓冲区，让其准备被填充*/
            buffer.clear( );
        }

    }
    @Test
    public void scatterTest() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("F:\\message\\测试io文件\\read-channel.txt");
        ScatteringByteChannel read = (ScatteringByteChannel) Channels.newChannel(fileInputStream);
        ByteBuffer header = ByteBuffer.allocateDirect(10);
        ByteBuffer body = ByteBuffer.allocateDirect(60);
        ByteBuffer[] buffers = {header,body};
        int bytesRead = (int) read.read(buffers);
    }
    @Test
    public void gatherTest() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\message\\测试io文件\\write-cahnnel.txt");
        GatheringByteChannel gather = (GatheringByteChannel) Channels.newChannel(fileOutputStream);
        ByteBuffer header = ByteBuffer.allocateDirect(10);
        header.put((byte) 1).put((byte) 1).put((byte) 1);
        ByteBuffer body = ByteBuffer.allocateDirect(60);
        body.put((byte) 2).put((byte) 2).put((byte) 2);
        ByteBuffer[] buffers = {header,body};
        long byteWrite =  gather.write(buffers);
        System.out.println(byteWrite);
    }
    @Test
    public void bidDecimalTest(){
        BigDecimal big = new BigDecimal(Math.abs(1));
        BigDecimal big1 = new BigDecimal(Math.abs(0));
        big1 = null;
        boolean b = big.equals(null);
        big.compareTo(big1);
        System.out.println(big);

    }
    @Test
    public void fileChannelTest() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("F:\\message\\测试io文件\\read-channel.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        int size =(int) fileChannel.size();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(size);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        while(byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.get());
        }
        System.out.println(size);

    }
    @Test
    public void lockTest() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("F:\\message\\测试io文件\\read-channel.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        FileLock try1 = fileChannel.tryLock(0L, Long.MAX_VALUE,true);
        /*FileLock lock1 = fileChannel.lock(0L, Long.MAX_VALUE,true);*/
        FileLock try2 = fileChannel.tryLock(0L, Long.MAX_VALUE,true);
        /*FileLock lock2 = fileChannel.lock(0L, Long.MAX_VALUE,true);*/
        /*lock1.isValid();*/
        System.out.println("锁住了");
    }

    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
    @Test
    public void lockReadAndWriteTest(){
        Nio nio = new Nio();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new FileThread(nio));
            thread.start();
        }
    }
    void readLock(String name) throws IOException, InterruptedException {
        System.out.println(name);
        FileInputStream fileInputStream = new FileInputStream("F:\\message\\测试io文件\\read-channel.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        fileChannel.lock(0,Long.MAX_VALUE,true);
        Thread.sleep(1000*1);
        fileChannel.read(byteBuffer);
    }
    class FileThread implements Runnable{
        Nio nio;

        public FileThread(Nio nio) {
            this.nio = nio;
        }

        @Override
        public void run() {
            System.out.println("进来了");
            try {
                nio.readLock(Thread.currentThread().getName());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void doubleTeST(){
        double a = 1.111;
        BigDecimal bigDecimal = BigDecimal.valueOf(1.33333335);
        System.out.println(bigDecimal.toString());
    }
    @Test
    public void mapTest() throws IOException {
       /* FileOutputStream fileOutputStream = new FileOutputStream("F:\\message\\测试io文件\\write-cahnnel.txt");*/
        /*FileInputStream fileInputStream = new FileInputStream("F:\\message\\测试io文件\\read-channel.txt");*/
        File file = new File("F:\\message\\测试io文件\\read-channel.txt");
        RandomAccessFile randomFile = new RandomAccessFile (file, "rw");
        FileChannel fileChannel = randomFile.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.PRIVATE,0,fileChannel.size());
        mappedByteBuffer.put((byte)2).put((byte)2).put((byte)2).put((byte)2).put((byte)2).put((byte)2).put((byte)2).put((byte)2).put((byte)2);
        System.out.println();
    }
    @Test
    public void chanelToChanelTest() throws IOException {
        File file = new File("F:\\message\\测试io文件\\read-channel.txt");
        RandomAccessFile randomFile = new RandomAccessFile (file, "rw");
        File targetFile = new File("F:\\message\\测试io文件\\write-cahnnel.txt");
        RandomAccessFile randomTargetFile = new RandomAccessFile (targetFile, "rw");
        FileChannel channel = randomFile.getChannel( );
        FileChannel targetChannel = randomTargetFile.getChannel( );
        channel.transferTo (0, channel.size( ),targetChannel);
        channel.close( );
        targetChannel.close();
        randomFile.close( );
        randomTargetFile.close();
    }
    @Test
    public void socketTest() throws IOException {
        SocketChannel sc = SocketChannel.open( );
        Socket socket = null;
        Object lockObj = sc.blockingLock( );
        synchronized (lockObj) {
            boolean prevState = sc.isBlocking( );
            sc.configureBlocking (false);
            sc.configureBlocking (prevState);
        }

    }

    @Test
    public void serverSocketChannelTest() throws IOException {
        byte[] b = new byte[10];
        ByteBuffer buffer = ByteBuffer.wrap (b);
        ServerSocketChannel ssc = ServerSocketChannel.open( );
        ssc.socket( ).bind (new InetSocketAddress (1234));//绑定端口，监听通道
        ssc.configureBlocking (false);//设置成非阻塞

    }




}
