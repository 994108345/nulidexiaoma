package nulidexiaoma.server.test.dataconstruct;

import org.apache.poi.util.StringUtil;
import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * Created by 99410 on 2018/2/5.
 */
public class LinearTable {

    private int size;//线性表数据的长度

    private int length;//线性表的长度

    private String[] linear;//线性表对象

    public LinearTable() {
        linear = new String[]{"1","2","3","4","5","6","7","8",null,""};
        size = linear.length;
    }

    /**
     * 获取数据的长度
     * @return
     */
    int getSize(){
        int j = 0;
        for (String i: linear) {
            if(!StringUtils.isEmpty(i)){
                j++;
            }
        }
        return j;
    }
    void deleteLinear(String str){
        for (int i = 0; i < linear.length; i++) {
            if(str.equals(linear[i])){

            }
        }
    }

    @Test
   public void testDemo(){
        int i = getSize();
        System.out.println(i);
    }
}
