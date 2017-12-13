package cn.wzl.nulidexiaoma.common;

/**
 * Created by 99410 on 2017/12/6.
 * 枚举类
 */
public enum MessageStatus {
    OK(10000,"成功"),
    ERROR(-10000,"失败"),
    NULL(00000,"值为NULL"),
    ;
    private int status;
    private String message;
    MessageStatus(int status, String message) {
      this.setStatus(status);
      this.setMessage(message);
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
