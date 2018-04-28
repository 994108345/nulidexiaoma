package nulidexiaoma.server.test.other.Thread_book;

import org.junit.Test;

import java.io.*;

/**
 * Created by wenzailong on 2018/1/30.
 */
public class VolatitleTest {
    String temp = "";
    FileInputStream fis;
    InputStreamReader isr;
    BufferedReader br;
    FileOutputStream fos;
    PrintWriter pw;

    @Test
    public void Demo1Test() throws InterruptedException {
        DemoThreadA demoThreadA = new DemoThreadA();
        DemoThreadA demoThread2 = new DemoThreadA();
        demoThreadA.start();
        demoThreadA.sleep(100);
        demoThread2.setOpen(false);
        System.out.println("该出去了吧");
    }



    class DemoThreadA extends Thread{
        boolean isOpen = true;

        public boolean isOpen() {
            return isOpen;
        }
        public void setOpen(boolean open) {
            isOpen = open;
        }
        @Override
        public void run() {
            super.run();
            System.out.println("进来了 "+isOpen);
            while(isOpen==true){
            }
            System.out.println("出去了 "+isOpen);
        }
    }

    @Test
    public void DemoTest2() throws InterruptedException {
        System.out.println(Thread.currentThread().isDaemon());
        DemoThreadB a = new DemoThreadB();
        DemoThreadB b = new DemoThreadB();
        a.setName("A");
        a.start();

        b.setName("B");
        b.start();
    }
    class DemoThreadB extends Thread{
        int i = 0;
        @Override
        public void run() {
            System.out.println(Thread.currentThread().isDaemon());
            System.out.println(Thread.currentThread().getName()+"进来了");
            for(int j = 0; j<1000;j++){
                System.out.println(Thread.currentThread().getName()+":"+i);
                i++;
            }
        }
    }

    @Test
    public void writeTest() throws InterruptedException {
        WriteFile a = new WriteFile();
        WriteFile b = new WriteFile();
        a.setName("A");
        a.start();
        a.sleep(500);
        b.setName("B");
        b.start();
    }
    class WriteFile extends Thread{
        @Override
        public void run() {
            for(int i = 0 ;i < 1000;i++){

                String message = Thread.currentThread().getName()+":"+i;
                System.out.println(message);
                write(message);
            }
        }
    }

    /**
     * 写文件
     */
    public void write(String message){
        String temp = "";
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        PrintWriter pw = null;

        String filePath = "C:\\Users\\wenzailong\\Desktop\\write.txt";
        File file = new File(filePath);
        try {
            if (!file.exists()){
                file.createNewFile();
                fis = new FileInputStream(file);
                isr = new InputStreamReader(fis);
                br = new BufferedReader(isr);
                StringBuffer buffer = new StringBuffer();
                for(int i = 0;(temp = br.readLine()) != null; i++){
                    buffer.append(temp);
                    buffer = buffer.append(System.getProperty("line.separator"));
                }
                buffer.append(message);
                fos = new FileOutputStream(file);
                pw = new PrintWriter(fos);
                pw.write(buffer.toString().toCharArray());
                pw.flush();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(fis!= null){
                    fis.close();
                }
                if(isr!= null){
                    isr.close();
                }
                if(br!= null){
                    br.close();
                }
                if(fos!= null){
                    fos.close();
                }
                if(pw!= null){
                    pw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void close(){
        try {
            if(fis!= null){
                fis.close();
            }
            if(isr!= null){
                isr.close();
            }
            if(br!= null){
                br.close();
            }
            if(fos!= null){
                fos.close();
            }
            if(pw!= null){
                pw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

