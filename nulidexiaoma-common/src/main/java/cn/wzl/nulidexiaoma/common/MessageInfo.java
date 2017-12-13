package cn.wzl.nulidexiaoma.common;

import java.io.Serializable;

/**
 * Created by 99410 on 2017/12/6.
 */

/**
 * 返回信息对象
 * @param <E>
 */
public class MessageInfo<E> implements Serializable {

    private static final long serialVersionUID = -4249443378793883291L;

    private String message;
    private int status;
    private E data;

    public MessageInfo(){
        this.message = "成功";
        this.status =10000;
    }
    public void setMessageStatus(int status,String message){
        this.message = message;
        this.status = status;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

}
