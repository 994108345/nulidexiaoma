package proxy;/**
 * Created by wenzailong on 2018/5/11.
 */

/**
 * @author wenzailong
 * @create 2018-05-11 9:28
 **/
public class Customer {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService(10000);
        customerService.designWebSite();
    }
}
