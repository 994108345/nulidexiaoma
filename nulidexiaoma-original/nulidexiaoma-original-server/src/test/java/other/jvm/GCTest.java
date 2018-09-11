package other.jvm;/**
 * Created by wenzailong on 2018/6/8.
 */

import org.junit.Test;

/**
 * @author wenzailong
 * @create 2018-06-08 15:07
 **/
public class GCTest {
    class ReferenceCountingGc{
        public Object instance = null;
        private static final int _1MB = 1024*1024;
        private byte[] bigSize = new byte[2*_1MB];
    }
    @Test
    public void sortNumTest(){
        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
    }
}
