package pattern.factory;/**
 * Created by wenzailong on 2018/7/19.
 */

import org.junit.Test;

/**
 * @author wenzailong
 * @create 2018-07-19 10:44
 **/
public class Factory {
    @Test
    public void getProduct(){
        IProduct product = new NewProduct();
        product.method1();
        product.method2();
        product.method3();
    }
}
