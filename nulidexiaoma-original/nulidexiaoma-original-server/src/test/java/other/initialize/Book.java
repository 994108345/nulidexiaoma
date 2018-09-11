package other.initialize;/**
 * Created by wenzailong on 2018/5/31.
 */

/**
 * @author wenzailong
 * @create 2018-05-31 10:31
 **/
public class Book {
    boolean checkedOut = false;
    Book(boolean checkOut){
        checkedOut = checkOut;
    }
    void  checkIn(){
        checkedOut = false;
    }
    protected void finalize(){
        if(checkedOut){
            System.out.println("Error checked out");
        }
    }

    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        new Book(true);
        System.gc();
    }
}

