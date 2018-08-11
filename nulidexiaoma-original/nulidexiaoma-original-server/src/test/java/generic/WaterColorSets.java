package generic;/**
 * Created by wenzailong on 2018/6/4.
 */


import java.util.EnumSet;
import java.util.Set;

/**
 * @author wenzailong
 * @create 2018-06-04 14:57
 **/
public class WaterColorSets {
    public static void main(String[] args){
        Set<WaterColors> set1 = EnumSet.range(WaterColors.BRILLIANT_RED,WaterColors.VIRIDIAN_HUE);
        Set<WaterColors> set2 = EnumSet.range(WaterColors.CERULEAN_BLUE_HUE,WaterColors.BURNT_UMBER);
        System.out.println("set1:"+set1);
        System.out.println("set2:" + set2);
        System.out.println("union(set1,set2):" + Sets.union(set1,set2));
        Set<WaterColors> subSet = Sets.intersection(set1,set2);
        System.out.println("intersection(set1,set2):" +subSet);
        System.out.println("different(set1,subSet):" +Sets.difference(set1,subSet));
        System.out.println("different(set2,subSet):" +Sets.difference(set2,subSet));
        System.out.println("complement(set1,set2):" +Sets.complement(set1,set2));
    }
}
