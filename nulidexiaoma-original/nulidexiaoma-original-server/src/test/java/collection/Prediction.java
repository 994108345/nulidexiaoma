package collection;/**
 * Created by wenzailong on 2018/7/23.
 */

import java.util.Random;

/**
 * @author wenzailong
 * @create 2018-07-23 10:29
 **/
public class Prediction {
    private static Random random = new Random(47);
    private boolean shadow = random.nextDouble()>0.5;
    public String toString(){
        if(shadow){
            return "Six more weeks of Winter";
        }else{
            return "Early Spring";
        }
    }
}
