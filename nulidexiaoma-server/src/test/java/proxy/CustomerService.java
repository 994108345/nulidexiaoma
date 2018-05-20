package proxy;/**
 * Created by wenzailong on 2018/5/11.
 */

/**
 * @author wenzailong
 * @create 2018-05-11 9:28
 **/
public class CustomerService implements Proxy {
    private Programmer programmer = new Programmer();
    private int money;

    public CustomerService(int money) {
        this.money = money;
    }

    @Override
    public void designWebSite() {
        if(money<50000){
            System.out.println("不好意思你的开价太低，我们公司不接受这个交易");
        }else{
            System.out.println("我是客服，我会把需求告诉程序员！");
            programmer.designWebSite();
        }
    }
}
