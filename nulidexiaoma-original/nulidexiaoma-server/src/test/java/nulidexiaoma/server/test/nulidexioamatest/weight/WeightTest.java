package nulidexiaoma.server.test.nulidexioamatest.weight;/**
 * Created by wenzailong on 2018/8/2.
 */

import java.util.List;
import java.util.Random;

/**
 * @author wenzailong
 * @create 2018-08-02 13:56
 **/
public class WeightTest {

    private int getServerByWeight(int[] weightArr) {
        int[][] randArr = new int[weightArr.length][2];
        int totalRank = 0;
        int index = 0;
        for(int i=0;i<weightArr.length;i++) {
            if (weightArr[i] <= 0) {
                continue;
            }

            totalRank += weightArr[i];
            randArr[i][0] = i;
            randArr[i][1] = totalRank;
        }

        int hitRank = new Random().nextInt(totalRank) + 1;//[1, totalRand]
        for (int i = 0; i < randArr.length; i++) {
            if (hitRank <= randArr[i][1]) {
                return randArr[i][0];
            }
        }

        return randArr[0][0];
    }

    public Server choose(List<Server> serverList) {
        if (null == serverList) {
            return null;
        }

        int[] weightArr = new int[serverList.size()];

        for(int i = 0; i < serverList.size(); i++) {
            if (serverList.get(i).getWeight() > 0) {
                weightArr[i] = serverList.get(i).getWeight();
            }
        }

        if (weightArr.length == 0) {
            return null;
        }

        int chosenIndex = getServerByWeight(weightArr);
        return serverList.get(chosenIndex);
    }

}
