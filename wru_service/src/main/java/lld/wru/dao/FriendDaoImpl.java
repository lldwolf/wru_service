package lld.wru.dao;

import org.springframework.stereotype.Component;

import lld.wru.dao.interfaces.FriendDao;
import lld.wru.model.FriendExample;
import lld.wru.model.FriendExample.Criteria;

@Component
public class FriendDaoImpl implements FriendDao {

    public boolean hasFriend(String srcPhoneNum, String friendPhoneNum) {
        FriendMapper friendMapper = DaoFactory.getFriendMapper();
        FriendExample friendExample = new FriendExample();
        Criteria criteria = friendExample.createCriteria();
        criteria.andPhoneNum1EqualTo(srcPhoneNum);
        criteria.andPhoneNum2EqualTo(friendPhoneNum);
        Criteria criteria2 = friendExample.or();
        criteria2.andPhoneNum1EqualTo(friendPhoneNum);
        criteria2.andPhoneNum2EqualTo(srcPhoneNum);
        long friendCount = friendMapper.countByExample(friendExample);
        return friendCount > 0;
        //
        // if (friendCount > 0) {
        // return true;
        // }
        //
        // friendExample = new FriendExample();
        // criteria = friendExample.createCriteria();
        // criteria.andPhoneNum1EqualTo(friendPhoneNum);
        // criteria.andPhoneNum2EqualTo(srcPhoneNum);
        // friendCount = friendMapper.countByExample(friendExample);
        //
        // return friendCount > 0;
    }

}
