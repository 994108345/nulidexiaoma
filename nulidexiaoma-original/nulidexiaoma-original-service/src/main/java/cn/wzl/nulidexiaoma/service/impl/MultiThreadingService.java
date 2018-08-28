package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.IMultiThreadingService;
import cn.wzl.nulidexiaoma.common.MessageInfo;
import cn.wzl.nulidexiaoma.common.MessageStatus;
import cn.wzl.nulidexiaoma.original.dao.multithreading.IMultiThreadingDao;
import cn.wzl.nulidexiaoma.model.MultiThreading;
import cn.wzl.nulidexiaoma.service.impl.thread.MultiThreadThread;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by wenzailong on 2018/3/4.
 */
@Service("iMultiThreading")
@PropertySource("classpath:other.spring/app.properties")
public class MultiThreadingService implements IMultiThreadingService{
    private static final Logger logger = LoggerFactory.getLogger(MultiThreadingService.class);
    int i = 0;
    int size = 0;
    List <MultiThreading> resultList = new ArrayList<>();
    List<MultiThreading> list = new ArrayList();

    private volatile int beginLimit = 0;
    private int countNum = 1000;
    private List updateList = new ArrayList();

    @Autowired
    IMultiThreadingDao multiThreadingDao;
    @Autowired
    IMultiThreadingService iMultiThreading;

    @Value("${multiThreadgNum}")
    private int multiThreadgNum;

    @Override
    public MessageInfo<String> normalMathod() {
        MessageInfo<String> messageInfo = new MessageInfo<String>();
        List<MultiThreading> dataList = new ArrayList();
        List<MultiThreading> updateList = new ArrayList();

        try {
            dataList = multiThreadingDao.selectAllDate();

            long beginDate = System.currentTimeMillis();
            int i = 1;
            for (MultiThreading multiThreading : dataList) {
                multiThreading.setControlNum("处理过:"+i);
                i++;
                updateList.add(multiThreading);
            }
            multiThreadingDao.updateMultiThreading(updateList);
            long endDate = System.currentTimeMillis();
            long resultDate = endDate - beginDate;
            messageInfo.setData(resultDate+"");
        } catch (Exception e) {
            e.printStackTrace();
            messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"普通方法处理数据出错" + e.getMessage());
        }
        return  messageInfo;
    }

    @Override
    public MessageInfo<String> threadMathod(int threadNum) {
        MessageInfo<String> messageInfo = new MessageInfo<String>();
        try {
            long beginDate = System.currentTimeMillis();
            MultiThreadingService multiThreadingService = new MultiThreadingService();
            multiThreadingService.list = multiThreadingDao.selectAllDate();
            multiThreadingService.size = this.list.size();
            ExecutorService exec = Executors.newFixedThreadPool (multiThreadgNum);
            System.out.println("准备进入:");
            exec.execute(new MultiThread(multiThreadingService,"不清楚"));
            System.out.println("启动线程:"+i);
            exec.shutdown();
            exec.awaitTermination(1, TimeUnit.HOURS);
            System.out.println("线程全部结束了吗");
            if(CollectionUtils.isEmpty(multiThreadingService.resultList)){
                messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),"插入集合为空");
                return messageInfo;
            }
            multiThreadingDao.updateMultiThreading(multiThreadingService.resultList);
            long endDate = System.currentTimeMillis();
            long resultDate = endDate - beginDate;
            messageInfo.setData(resultDate+"");
        }catch(Exception e){
            e.printStackTrace();
        }
        return  messageInfo;
    }


    public void multiThread(MultiThreadingService multiThreadingService){
        synchronized (this){
            System.out.println("看i" + i);
            int i = multiThreadingService.i;
            int size = multiThreadingService.list.size();
            List resultList = multiThreadingService.resultList;
            while (i < size) {
                System.out.println("进入了run........" + i);
                MultiThreading multiThreading = list.get(i);
                multiThreading.setControlNum("多线程继续啊：" + i);
                i++;
                resultList.add(multiThreading);
            }

        }
    }

    /**
     * 内部类
     */
    class MultiThread implements Runnable{
        MultiThreadingService multiThreadingService;
        String threadName;

        public MultiThread(MultiThreadingService multiThreadingService,String threadName) {
            this.multiThreadingService = multiThreadingService;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            multiThreadingService.multiThread(multiThreadingService);
        }
    }

    @Override
    public MessageInfo returnRandom() {
        MessageInfo messageInfo = new MessageInfo();
        try {
            ExecutorService exe = Executors.newFixedThreadPool(10);
            List<Future> returnList = new ArrayList();
            for (int i1 = 0; i1 < 10; i1++) {
                Callable callable = new MultiThreadThread(String.valueOf(i1));
                Future future = exe.submit(callable);
                returnList.add(future);
            }
            exe.shutdown();
            for (Future future : returnList) {
                System.out.println("获得的随机数是"+String.valueOf(future.get()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MessageInfo limitTest() {
        try{
            ExecutorService exe = Executors.newFixedThreadPool(multiThreadgNum);
            List<Future> returnList = new ArrayList();
            for (int i1 = 0; i1 < 10; i1++) {
                Callable callable = new MultiThreadThread(String.valueOf(i1));
                Future future = exe.submit(callable);
                returnList.add(future);
            }
            exe.shutdown();
            for (Future future : returnList) {
                MessageInfo messageInfo = (MessageInfo)future.get();
                System.out.println("有出错吗"+messageInfo.getMessage());
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 测试ilimit的内部类
     */
    class limitThread implements Callable{
        @Override
        public Object call() throws Exception {
            MessageInfo messageInfo = new MessageInfo();
            try {
                List<MultiThreading> result = new ArrayList();
                synchronized (this) {
                    while (true) {
                        result = multiThreadingDao.listMultiThreadByLimit(beginLimit, countNum);
                        beginLimit = beginLimit + countNum;
                        for (MultiThreading multiThreading : result) {
                            int id = multiThreading.getId();
                            if (id % 11 == 3) {
                                multiThreading.setThreadName("除十一余数是3");
                                System.out.println(multiThreading.getId() + ":除十一余数是3");
                            } else {
                                System.out.println(multiThreading.getId() + ":除十一余数不是3");
                            }
                            updateList.add(multiThreading);
                        }
                        if (result.size() != 1000) {
                            break;
                        }
                    }
                }
            }catch (Exception e){
                logger.error(e.getMessage(),e);
                messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),e.getMessage());
            }
            return messageInfo;
        }

        /**
         * 更新
         * @return
         */
        public MessageInfo updateMultiThread(){
            MessageInfo messageInfo = new MessageInfo();
            try{
                int a = multiThreadingDao.updateMultiThreading(updateList);
            }catch (Exception e){
                logger.error(e.getMessage(),e);
                messageInfo.setMessageStatus(MessageStatus.ERROR.getStatus(),e.getMessage());
            }
            return messageInfo;
        }
    }
}
