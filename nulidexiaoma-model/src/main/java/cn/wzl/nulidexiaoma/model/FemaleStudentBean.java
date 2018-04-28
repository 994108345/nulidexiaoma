package cn.wzl.nulidexiaoma.model;/**
 * Created by wenzailong on 2018/4/26.
 */

import java.util.List;

/**
 * @author wenzailong
 * @create 2018-04-26 10:38
 **/
public class FemaleStudentBean extends Student {
    private List<FemaleStudent> femaleStudents = null;

    public List<FemaleStudent> getFemaleStudents() {
        return femaleStudents;
    }

    public void setFemaleStudents(List<FemaleStudent> femaleStudents) {
        this.femaleStudents = femaleStudents;
    }
}
