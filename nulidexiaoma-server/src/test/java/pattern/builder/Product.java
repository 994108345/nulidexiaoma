package pattern.builder;/**
 * Created by wenzailong on 2018/5/24.
 */

import java.util.ArrayList;
import java.util.List;

/**产品类
 * @author wenzailong
 * @create 2018-05-24 14:51
 **/
public class Product {
    List parts = new ArrayList();

    public void add(String part){
        parts.add(part);
    }

    public void show(){
        System.out.println("产品创建----");
        for (Object part : parts) {
            System.out.println(part);
        }
    }
}
