package nulidexiaoma.server.test.Thread_book;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by wenzailong on 2018/1/31.
 */
public class PipedTest {

}
class WriteData{
    public void writeMethod(PipedOutputStream out){
        try {
            System.out.println("write :");
            for (int i = 0; i < 300 ; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.println(outData);
            }
            System.out.println();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReadData{
    public void readMethod (PipedInputStream input){
        try {
            System.out.println("read :");
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while(readLength != -1){
                String newData = new String(byteArray,0,readLength);
                System.out.println(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
class ThreadWrite extends Thread{
    private WriteData  write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}