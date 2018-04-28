package nulidexiaoma.server.test.other.dataconstruct;

import org.junit.Test;

/**
 * 栈
 */
public class Stack {
    private int top =0;//top等于0说明是空栈！
    private int bottom = 1;
    private String[] stacks = new String[10];
    private int length;

    public Stack() {
        stacks[0] = null;
        stacks[1] = "1";
        stacks[2] = "2";
        stacks[3] = "3";
        stacks[4] = "4";
        stacks[5] = "5";
        top = getTop(stacks);
        length = stacks.length-1;
    }
    /**返回栈顶*/
    int getTop(String[] stscks){
        for (int i = 1; i < stacks.length; i++) {
            if(null == stacks[i] ){
                return i-1;
            }
        }
        return stacks.length-1;
    }
    /**压栈，进栈*/
    void push(String str) throws Exception {
        if(top == length-1 ){
            throw new Exception("该栈储存空间已经满了！");
        }
        stacks[top+1] = str;
        printStack(stacks);
    }
    /**出栈*/
    void pop(int index) throws Exception {
        if(index>=bottom && index<= top){
            stacks[index]=null;
            for (int i = index; i < top+1; i++) {
                if(i == top){
                    stacks[top]=null;
                    printStack(stacks);
                    return ;
                }
                stacks[i] = stacks[i+1];
            }
        }else{
            throw new Exception("输入的地址不存在");
        }
    }
    @Test
    public void popTest() throws Exception {
        pop(6);
    }


    /**打印栈*/
    void printStack(String[] stacks){
        for (int i = 1; i < length+1; i++) {
            System.out.print(stacks[i]+",");
        }
    }
    @Test
    public void pushTest() throws Exception {
        push("压栈");
    }
}
