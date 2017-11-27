package wru_service;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lld.wru.dao.UserMapper;
import lld.wru.model.User;
import lld.wru.model.UserExample;
import lld.wru.model.UserExample.Criteria;

public class UserDaoTest {
    private static final Logger logger = LogManager.getLogger(UserDaoTest.class);

    @Test
    public void firstTest() throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userDao = (UserMapper) ctx.getBean("userDao");
        UserExample userExample = new UserExample();
        Criteria userCriteria = userExample.createCriteria();
        userCriteria.andPhoneNumEqualTo("13817024379");
        List<User> users = userDao.selectByExample(userExample);
        
        for (User user : users) {
            Assert.assertNotNull(user);
            logger.info(user.toString());
        }

        ((ConfigurableApplicationContext) ctx).close();
}

}
