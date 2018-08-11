package cn.wzl.nulidexiaoma.service.impl;/**
 * Created by wenzailong on 2018/5/11.
 */

import cn.wzl.nulidexiaoma.api.IFileStreamService;

import java.io.File;

/**
 * @author wenzailong
 * @create 2018-05-11 9:02
 **/
public class FileStreamServiceImpl implements IFileStreamService{

    @Override
    public void getFiles(String filePath) {
        File file = new File(filePath);
        file.list();
    }
}
