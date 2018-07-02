package generic;/**
 * Created by wenzailong on 2018/6/4.
 */

import pattern.builder.Builder;

/**
 * @author wenzailong
 * @create 2018-06-04 16:43
 **/
public class Building {
}
class House extends Building{}
class ClassTypeCapture<T>{
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }
    public boolean f(Object arg){
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}
