package wru_service.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lld.wru.dao.DaoConfig;
import lld.wru.dao.interfaces.FriendDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DaoConfig.class)
public class FriendDaoTest {
    @Autowired
    private FriendDao friendDao;
    
    @Test
    public void hasFriend() {
        String phoneNum1 = "13817024379";
        String phoneNum2 = "13916253764";
        testHasFriend(phoneNum1, phoneNum2);
        testHasFriend(phoneNum2, phoneNum1);
        testHasFriend(phoneNum2 + "a", phoneNum1);
    }
    
    private void testHasFriend(String phoneNum1, String phoneNum2) {
        boolean hasFriendResult =  friendDao.hasFriend(phoneNum1, phoneNum2);
        
        if (hasFriendResult) {
            System.out.println(String.format("%s is %s's friend.", phoneNum1, phoneNum2));
        } else {
            System.out.println(String.format("%s is not %s's friend.", phoneNum1, phoneNum2));
        }
    }
}
