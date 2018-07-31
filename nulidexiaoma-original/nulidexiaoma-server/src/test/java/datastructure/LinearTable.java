package datastructure;/**
 * Created by wenzailong on 2018/5/29.
 */

import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

/**
 * @author wenzailong
 * @create 2018-05-29 14:08
 **/
public class LinearTable {
    String[] strs = new String[20];

    public LinearTable() {
        strs[0] = "1";
        strs[1] = "2";
        strs[2] = "3";
        strs[3] = "4";
        strs[4] = "5";
    }
    public void  printData(){
        for (String str : strs) {
            if(str!=null) {
                System.out.print(str + ",");
            }
        }
    }

    /**
     * 添加元素
     * @param index 要插入的位置
     * @param value 要插入的值
     */
    public void add(int index,String value){
        String nextValue = strs[index-1];
        strs[index-1] = value;
        for (int i = index; i < strs.length; i++) {
            if(strs[i] == null){
                strs[i] = nextValue;
                break;
            }else{
                String str1 = strs[i];
                strs[i] = nextValue;
                nextValue = str1;
            }
        }

    }

    /**
     * 删除元素
     * @param index 要删除的位置
     */
    public void delete(int index){
        for (int i = index; i < strs.length; i++) {
            if(strs[i] == null){
                /*strs[i-1] = null;*/
                break;
            }else{
                strs[i-1] = strs[i];
                strs[i] = null;
            }
        }
    }

    /**
     * 访问线性表的元素
     * @param index 要访问元素的位置
     * @return
     */
    public String getValur(int index){
        return strs[index-1];
    }

    @Test
    public  void addTest(){
        add(2,"10");
        this.printData();
    }
    @Test
    public void deleteTest(){
        delete(5);
        this.printData();
    }
    @Test
    public void getValueTest(){
        System.out.println("访问的值为："+getValur(2));
    }
}
