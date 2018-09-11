package other.initialize;/**
 * Created by wenzailong on 2018/5/31.
 */

import java.util.Random;

/**
 * @author wenzailong
 * @create 2018-05-31 14:09
 **/
public class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = 10;
    static {
        System.out.println("Initializing Initable");
    }

}
class Initable2{
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing  Initable2");
    }
}
class Initable3{
    static int staticNonFinal = 74;
    static{
        System.out.println("Initializing Initable3");
    }
}
class ClassInitialization{
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("other.initialize.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);

        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}

class FancyToy extends Toy{

}
class Toy{

}
class GenericToyTest{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        System.out.println(up.getSimpleName());
        Object obj = up.newInstance();

    }
}

class Building{}
class House extends Building{}
class ClassCasts{
    public static void main(String[] args) {
        Building building = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(building);
        //等价于
        h = (House)building;
    }
}

