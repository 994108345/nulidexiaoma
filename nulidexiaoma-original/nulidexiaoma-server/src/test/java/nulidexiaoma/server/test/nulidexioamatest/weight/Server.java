package nulidexiaoma.server.test.nulidexioamatest.weight;/**
 * Created by wenzailong on 2018/8/2.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wenzailong
 * @create 2018-08-02 13:57
 **/

class Server {
    private String ip;

    private int port;

    private int weight;

    public Server(String ip, int port, int weight) {
        this.ip = ip;
        this.port = port;
        this.weight = weight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "ip : " + ip + ", port : " + port + ", weight : " + weight;
    }
}

