package jvm;/**
 * Created by wenzailong on 2018/6/25.
 */

import org.junit.Test;

/**
 * @author wenzailong
 * @create 2018-06-25 9:11
 **/
public class SlotTest {
    int i;
    /*
    public static void main(String[] args) {
        byte[] b = new byte[644*1024*1024];
        System.gc();
    }
    输出结果：
    * [GC 660432K->660008K(846336K), 0.0024178 secs]
    [Full GC 660008K->659927K(846336K), 0.0261979 secs]
    *
    *
    * */
    /*
    public static void main(String[] args) {
        {
            byte[] b = new byte[644 * 1024 * 1024];
        }
        System.gc();
    }
    输出结果：
    *[GC 660432K->660056K(846336K), 0.0021121 secs]
    [Full GC 660056K->659927K(846336K), 0.0304845 secs]
    *
    *
    * */
    public static void main(String[] args) {
        {
            byte[] b = new byte[644 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
    //输出结果：
    // [GC 660432K->660008K(846336K), 0.0024151 secs]
    //Full GC 660008K->471K(846336K), 0.0212659 secs]

    @Test
    public void test1(){
        System.out.println(i);
    }
}
