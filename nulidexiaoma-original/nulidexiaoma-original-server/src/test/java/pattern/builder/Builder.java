package pattern.builder;/**
 * Created by wenzailong on 2018/5/24.
 */

/**抽象建造者类
 * @author wenzailong
 * @create 2018-05-24 14:53
 **/
public abstract class Builder {
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract Product GetResult();
}
