package nulidexiaoma.server.test.nulidexioamatest;

import cn.wzl.nulidexiaoma.api.IRoleService;
import cn.wzl.nulidexiaoma.common.pageBean.SearchResult;
import cn.wzl.nulidexiaoma.common.pageBean.bean.RolePageBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by wenzailong on 2018/1/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class RoleServiceTest {
    private Logger logger = LoggerFactory.getLogger(RoleServiceTest.class);
    @Resource
    IRoleService roleService;

    @Test
    public void getPageBeanTest(){
        RolePageBean rolePageBean = new RolePageBean();
        rolePageBean.setCurPage(1);
        SearchResult searchResult = roleService.getPageBean(rolePageBean);
        logger.info(searchResult.toString());
    }

}
