package jvm;/**
 * Created by wenzailong on 2018/6/25.
 */

/**
 * @author wenzailong
 * @create 2018-06-25 14:10
 **/
public class Dispatch {
    static class QQ{}
    static class _360{}
    public static class Father{
        public void hardChoice(QQ arg){
            System.out.println("father chose qq");
        }
        public void hardChoice(_360 arg){
            System.out.println("father chose 360");
        }
    }
    public static class Son extends Father{
        public void hardChoice(QQ arg){
            System.out.println("son chose qq");
        }
        public void hardChoice(_360 arg){
            System.out.println("son chose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
