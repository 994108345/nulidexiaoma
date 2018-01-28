package nulidexiaoma.server.test.thinking_in_java.multithreading;

import javax.lang.model.element.ExecutableElement;

/**
 * Created by wenzailong on 2018/1/28.
 */
public class JoinTest {
}

class Sleeper extends Thread{
    int slpperTime;
    String name;
    public Sleeper(int sleeperTime, String name){
        this.slpperTime = sleeperTime;
        this.name = name;
        start();
    }

    @Override
    public void run() {
        try{
            sleep(slpperTime);
        }catch(Exception E){
            E.printStackTrace();
        }
        System.out.println(name +"has awakened");
    }

}
class Joined extends Thread{
    Sleeper sleeper ;
    public Joined(Sleeper sleeper,String name){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try{
            sleeper.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(getName() + "joined complete");
    }
}
class Joing{
    public static void main(String[] args){
        Sleeper sleeper = new Sleeper(1500,"A");
        Sleeper sleeper1 = new Sleeper(1500,"B");
        Joined joined = new Joined(sleeper,"jA");
        Joined joined1 = new Joined(sleeper1,"jB");

    }
}