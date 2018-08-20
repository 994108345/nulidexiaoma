package nulidexiaoma.server.test.nulidexioamatest;/**
 * Created by wenzailong on 2018/8/14.
 */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wenzailong
 * @create 2018-08-14 14:02
 **/
public class BufferTest {
    @Test
    public void bufferTestDemo1(){
        CharBuffer charBuffer = CharBuffer.allocate(100);
        charBuffer.put('w');
        charBuffer.put('z');
        charBuffer.put('l');

        System.out.println("翻转前：position:"+charBuffer.position()+"limit:"+charBuffer.limit());
        charBuffer.rewind();
        System.out.println("翻转后：position:"+charBuffer.position()+"limit:"+charBuffer.limit());
    }

    @Test
    public void befferDemoTest(){
        CharBuffer charBuffer = CharBuffer.allocate(100);
        charBuffer.put('w');
        charBuffer.put('z');
        charBuffer.put('l');
        int count = charBuffer.remaining();
        System.out.println(count);

        charBuffer.clear();
        System.out.println(charBuffer.position());
        System.out.println(charBuffer.get(0));

        charBuffer.compact();
        System.out.println(charBuffer.position());
    }
    @Test
    public void compactTest(){
        CharBuffer charBuffer = CharBuffer.allocate(100);
        charBuffer.put('w');
        charBuffer.put('z');
        charBuffer.put('l');
        charBuffer.position(1);
        charBuffer.compact();
        System.out.println(charBuffer.position());
    }

    @Test
    public void resetTest(){
        CharBuffer charBuffer = CharBuffer.allocate(100);
        charBuffer.put('w');
        charBuffer.put('z');
        charBuffer.mark();
        charBuffer.put('l');
//        charBuffer.reset();
        charBuffer.limit(1);
        System.out.println();
    }

    @Test
    public void getTest(){
        CharBuffer charBuffer = CharBuffer.allocate(100);
        charBuffer.put('w');
        charBuffer.put('z');
        charBuffer.put('l');
        char[] bs = new char[50];
        CharBuffer charBuffer2 = charBuffer.get(bs);
        System.out.println();
    }

    @Test
    public void bufferArrayTest(){
        char [] myArray = new char [100];
        CharBuffer charbuffer = CharBuffer.wrap (myArray);
        myArray[0]='1';
        myArray[0]='2';
    }

    @Test
    public void copyBufferTest(){
        CharBuffer charBuffer = CharBuffer.allocate(100);
        charBuffer.put('w');
        charBuffer.put('z');
        charBuffer.put('l');
        CharBuffer copyCharBuffer = charBuffer.duplicate();
        System.out.println(copyCharBuffer);
    }

    @Test
    public void allocateDirect(){
        CharBuffer charBuffer = CharBuffer.allocate(100);
        CharBuffer buffer = charBuffer.allocate(100);
    }

    @Test
    public void demo1(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(7).order(ByteOrder.BIG_ENDIAN);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        byteBuffer.put(0, (byte) 0);
        byteBuffer.put(1, (byte) 1);
        byteBuffer.put(2, (byte) 2);
        byteBuffer.put(3, (byte) 3);
        System.out.println(byteBuffer);
        System.out.println(charBuffer);
    }

    @Test
    public void channelMapTest() throws FileNotFoundException {
        File file = new File("FileTest.java");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        
    }
}
