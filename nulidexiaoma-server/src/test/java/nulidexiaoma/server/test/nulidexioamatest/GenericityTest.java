package nulidexiaoma.server.test.nulidexioamatest;


/**
 * Created by wenzailong on 2018/3/1.
 */
public class GenericityTest {

}

//Lev 1
class Food{}

//Lev 2
class Fruit extends Food{}
class Meat extends Food{}

//Lev 3
class Apple extends Fruit{}
class Banana extends Fruit{}
class Pork extends Meat{}
class Beef extends Meat{}

//Lev 4
class RedApple extends Apple{}
class GreenApple extends Apple{}

class Plate<T>{
    private T item;
    public  Plate(T t){
        item = t;
    };
    public void set(T t){
        item = t;
    }
    public T get(){
        return item;
    }

}
class mainFruit{
    public static void main(String[] args) {
        Plate<? extends Fruit> plate1 = new Plate<Apple>(new Apple());
//        plate1.set(new Apple());
        plate1.get();
        Plate<? super Fruit> plate2 = new Plate<Food>(new Food());
        plate2.set(new Apple());
        plate2.get();
    }
}