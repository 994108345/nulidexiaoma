package nulidexiaoma.server.test.other.dataconstruct;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 线性表
 */
public class LinearTable {
    private Logger logger = LoggerFactory.getLogger(LinearTable.class);

    private int size;//线性表数据储存的长度

    private int length;//线性表的长度

    private String[] linear;//线性表对象

    public LinearTable() {
        linear = new String[]{"1","2","3","4","5","6","","","",""};
        length = linear.length;
        size = getSize();
    }

    /**
     * 获取数据的长度
     * @return
     */
    int getSize(){
        int j = linear.length;
        for (int i = j-1; i < j; i--) {
            if(StringUtils.isEmpty(linear[i])){
                j--;
            }else{
                return j;
            }
        }
        return j;
    }

    /**
     * 打印线性表
     * @param linear
     */
    void printLinear(String[] linear){
        for (String s : linear) {
            System.out.print(s+",");
        }
    }

    /**
     * 删除线性表的一个结点
     * @param i  删除第几个元素，从1开始算，所以要i-1
     * @throws Exception
     */
    void deleteLinear(int i) throws Exception {
        if(StringUtils.isEmpty(linear[i-1])){
            throw new Exception("删除的信息为空");
        }
        for (int j = i-1; j < size; j++) {
            if(linear.length == j+1){
                linear[j] = null;
            }else{
                linear[j] = linear[j+1];
            }
        }
        printLinear(linear);
    }

    /**
     * 插入线性表(如果插入值插在线性表的最后，所以循环哟啊从线性表数据长度+1开始循环)
     * @param i
     * @param str
     * @throws Exception
     */
    void insertLinear(int i,String str) throws Exception {
        if(i>length && i<0 ){
            throw new Exception("插入的位置不合理");
        }
        if(size==length){
            throw new Exception("线性表空间已经占满，请联系管理员增加长度");
        }
        int index = i -1 ;
        for (int j = size; j >= 0; j--) {
            if(j == index){
                linear[j]=str;
                break;
            }
            linear[j+1] = linear[j];
        }
        printLinear(linear);
    }


    @Test
   public void deleteDemo(){
        try {
            deleteLinear(2);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }
    }
    @Test
    public void insertDemo(){
        try {
            insertLinear(7,"插入值");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
