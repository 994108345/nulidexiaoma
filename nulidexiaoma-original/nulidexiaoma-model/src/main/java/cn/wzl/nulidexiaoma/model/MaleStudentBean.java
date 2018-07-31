package cn.wzl.nulidexiaoma.model;/**
 * Created by wenzailong on 2018/4/26.
 */

import java.util.List;

/**
 * @author wenzailong
 * @create 2018-04-26 10:37
 **/
public class MaleStudentBean extends MaleStudent{
    private List<MaleStudent> maleStudents = null;

    public List<MaleStudent> getMaleStudents() {
        return maleStudents;
    }

    public void setMaleStudents(List<MaleStudent> maleStudents) {
        this.maleStudents = maleStudents;
    }
}
