package lld.wru.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoFactory {
    private final static ApplicationContext applicationContext;

    static {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static UserMapper getUserMapper() {
        UserMapper userDao = (UserMapper) applicationContext.getBean("userDao");
        return userDao;
    }

    public static LocationMapper getLocationMapper() {
        LocationMapper locationDao = (LocationMapper) applicationContext.getBean("locationDao");
        return locationDao;
    }

    public static FriendMapper getFriendMapper() {
        FriendMapper friendDao = (FriendMapper) applicationContext.getBean("friendDao");
        return friendDao;
    }
}
