package cn.wzl.nulidexiaoma.service.impl;

import cn.wzl.nulidexiaoma.api.TransActionTestService;
import cn.wzl.nulidexiaoma.model.Menu;
import cn.wzl.nulidexiaoma.original.dao.permissions.IMenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**spring事务传播类型（七种）
 * Created by 99410 on 2018/8/27.
 */
@Service
public class TransActionTestServiceImpl implements TransActionTestService {
    @Autowired
    private IMenuDao iMenuDao;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void insertOne(){
        Menu menu = new Menu();
        menu.setMenuId("111");
        menu.setMenuName("此时");
        menu.setParentId(1);
        iMenuDao.insertOne(menu);
        addOne();
        int a = 1/0;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void addOne(){
        Menu menu = new Menu();
        menu.setMenuId("222");
        menu.setMenuName("此时");
        menu.setParentId(1);
        iMenuDao.insertOne(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    public void insertBySupported() {
        Menu menu = new Menu();
        menu.setMenuId("111");
        menu.setMenuName("测试");
        menu.setParentId(1);
        iMenuDao.insertOne(menu);
        addSupported();
        int a = 1/0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void addSupported() {
        Menu menu = new Menu();
        menu.setMenuId("222");
        menu.setMenuName("测试");
        menu.setParentId(1);
        iMenuDao.insertOne(menu);

    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void insertByMandatory() {
        Menu menu = new Menu();
        menu.setMenuId("111");
        menu.setMenuName("测试");
        menu.setParentId(1);
        iMenuDao.insertOne(menu);
        addMandatory();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void addMandatory() {
        Menu menu = new Menu();
        menu.setMenuId("222");
        menu.setMenuName("测试");
        menu.setParentId(1);
        iMenuDao.insertOne(menu);
        throw new NullPointerException();
    }
}
