package cn.wzl.nulidexiaoma.common.enums;/**
 * Created by wenzailong on 2018/4/25.
 */

/**
 * @author wenzailong
 * @create 2018-04-25 9:53
 **/
public enum SexEnum {
    male(1,"男"),
    female(0,"女");
    private int status;
    private String Message;

    SexEnum(int status, String message) {
        this.status = status;
        Message = message;
    }
    public static SexEnum getSex(int id){
        if(id == 1){
            return male;
        }else if(id == 2){
            return female;
        }
        return null;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
