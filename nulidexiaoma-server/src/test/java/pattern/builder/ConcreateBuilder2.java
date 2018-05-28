package pattern.builder;/**
 * Created by wenzailong on 2018/5/24.
 */

/**
 * @author wenzailong
 * @create 2018-05-24 14:58
 **/
public class ConcreateBuilder2 extends Builder {
    private Product product = new Product();
    @Override
    public void buildPartA() {
        product.add("部件x");
    }

    @Override
    public void buildPartB() {
        product.add("部件y");
    }

    @Override
    public Product GetResult() {
        return product;
    }
}
