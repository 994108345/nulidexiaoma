package nulidexiaoma.server.test.Thread_book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wenzailong on 2018/2/2.
 */
public class SimpleDataFormat {
}
class SimThread extends Thread{
    private SimpleDateFormat sdf;
    private  String dateString;

    public SimThread(SimpleDateFormat sdf, String dateString) {
        this.sdf = sdf;
        this.dateString = dateString;
    }

    @Override
    public void run() {
        try {
            Date dateRef = sdf.parse(dateString);
            String newDateString = sdf.format(dateRef).toString();
            if (!newDateString.equals(dateString)){
                System.out.println("ThraedName= " + this.getName()
                + "报错了  日期字符串：" + dateString
                        + "转换成的日期为：" + newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
class TestThread{
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateStringArray= new String[]{
                "2000-01-01","2000-01-02","2000-01-03","2000-01-04","2000-01-05",
                "2000-01-06","2000-01-07","2000-01-08","2000-01-09","2000-01-10"
        };
        SimThread[] threadArray = new SimThread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new SimThread(sdf,dateStringArray[i]);
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {

                }
            });
            threadArray[i].start();
        }
    }
}